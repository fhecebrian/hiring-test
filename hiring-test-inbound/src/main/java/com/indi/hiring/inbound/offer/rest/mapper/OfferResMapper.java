package com.indi.hiring.inbound.offer.rest.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.indi.hiring.domain.offer.model.Offer;
import com.indi.hiring.inbound.offer.rest.dto.OfferRes;

@Mapper(componentModel = "spring")
public interface OfferResMapper {

	OfferRes toResponse(Offer offer);
	
	List<OfferRes> toResponse(List<Offer> offers);	
	
}
