package com.indi.hiring.inbound.offer.rest.controller;

import java.util.List;

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
import com.indi.hiring.inbound.offer.rest.dto.OfferCreateReq;
import com.indi.hiring.inbound.offer.rest.dto.OfferRes;

@RestController
@RequestMapping("offer")
public class OfferController {
	private final OfferInboundPort port;

	public OfferController(OfferInboundPort port) {
		this.port = port;
	}

	@PostMapping()
	public ResponseEntity<OfferRes> createOffer(@RequestBody OfferCreateReq offerToCreate) {
		var offer = port.create(OfferCreateReq.toDomain(offerToCreate));
		return ResponseEntity.status(HttpStatus.CREATED).body(OfferRes.toResponse(offer));
	}

	@GetMapping()
	public List<OfferRes> getAllOffers() {
		return OfferRes.toResponse(port.findAll());
	}

	@GetMapping("/{id}")
	public OfferRes getOfferById(@PathVariable Long id) {
		return OfferRes.toResponse(port.findById(id));
	}	
	
	@DeleteMapping("/{id}")
	public Long deleteOfferById(@PathVariable Long id) {
		return OfferRes.toResponse(port.deleteOfferById(id)).offerId();
	}	

	@DeleteMapping()
	public List<Long> deleteAllOffers() {
		return (OfferRes.toResponse(port.deleteAll())).stream()
				.map(OfferRes::offerId).toList();
	}	
	
}
