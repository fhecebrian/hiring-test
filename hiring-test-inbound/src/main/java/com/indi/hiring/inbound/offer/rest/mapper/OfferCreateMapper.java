package com.indi.hiring.inbound.offer.rest.mapper;

import org.mapstruct.Mapper;

import com.indi.hiring.domain.offer.model.Offer;
import com.indi.hiring.inbound.offer.rest.dto.OfferCreateReq;

@Mapper(componentModel = "spring")
public interface OfferCreateMapper {

	Offer toDomain(OfferCreateReq offer);
	
	
}
