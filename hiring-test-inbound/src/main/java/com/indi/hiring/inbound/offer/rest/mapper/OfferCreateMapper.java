package com.indi.hiring.inbound.offer.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.indi.hiring.domain.offer.model.Offer;
import com.indi.hiring.inbound.offer.rest.dto.OfferCreateReq;

@Mapper(componentModel = "spring")
public interface OfferCreateMapper {

    @Mappings({
        @Mapping(target = "talla", expression = "java(offer.productPartnumber().substring(0, 2))"),
        @Mapping(target = "modelo", expression = "java(offer.productPartnumber().substring(2, 6))"),
        @Mapping(target = "calidad", expression = "java(offer.productPartnumber().substring(6, 9))"),
        @Mapping(target = "offerId", ignore = true)
    })
	Offer toDomain(OfferCreateReq offer);

}
