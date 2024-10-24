package com.indi.hiring.inbound.offer.rest.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indi.hiring.domain.offer.port.OfferInboundPort;
import com.indi.hiring.inbound.exception.BussinesRuleException;
import com.indi.hiring.inbound.offer.rest.dto.OfferCreateReq;
import com.indi.hiring.inbound.offer.rest.dto.OfferRes;
import com.indi.hiring.inbound.offer.rest.mapper.OfferCreateMapper;
import com.indi.hiring.inbound.offer.rest.mapper.OfferResMapper;
import com.indi.hiring.inbound.offer.rest.validation.OfferValidation;

@RestController
@RequestMapping("offer")
public class OfferController {
	private final OfferInboundPort port;

    private OfferCreateMapper offerCreateMapper;
    
    private OfferResMapper offerResMapper;
    
	public OfferController(OfferInboundPort port, OfferCreateMapper offerCreateMapper, OfferResMapper offerResMapper) {
		this.port = port;
		this.offerCreateMapper = offerCreateMapper;
		this.offerResMapper = offerResMapper;
	}

	@PostMapping()
	public ResponseEntity<?> createOffer(@RequestBody OfferCreateReq offerToCreate) throws BussinesRuleException {
		OfferValidation.validateOffer.accept(offerToCreate);
		var offer = port.create(offerCreateMapper.toDomain(offerToCreate));
		return ResponseEntity.status(HttpStatus.CREATED).body(offerResMapper.toResponse(offer));
	}

	@GetMapping()
	public ResponseEntity<List<OfferRes>> getAllOffers() throws BussinesRuleException {
        List<OfferRes> findAllOffers = offerResMapper.toResponse(port.findAll());
        if(findAllOffers.isEmpty()){
            return ResponseEntity.noContent().build();
        }
    	return ResponseEntity.ok(findAllOffers);       
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getOfferById(@PathVariable Long id) throws BussinesRuleException {
		OfferRes offer = offerResMapper.toResponse(port.findById(id));
		if(Objects.isNull(offer)) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(offerResMapper.toResponse(port.findById(id)));
	}	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteOfferById(@PathVariable Long id) throws BussinesRuleException {
		return ResponseEntity.status(HttpStatus.OK).body( offerResMapper.toResponse(port.deleteOfferById(id)).offerId());
	}	

	@DeleteMapping()
	public ResponseEntity<?> deleteAllOffers() throws BussinesRuleException {
		return ResponseEntity.status(HttpStatus.OK).body((offerResMapper.toResponse(port.deleteAll())).stream()
				.map(OfferRes::offerId).toList());
	}	
}
