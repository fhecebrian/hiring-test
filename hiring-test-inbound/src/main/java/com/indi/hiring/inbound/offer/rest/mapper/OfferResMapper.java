package com.indi.hiring.inbound.offer.rest.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.indi.hiring.domain.offer.model.Offer;
import com.indi.hiring.inbound.offer.rest.dto.OfferRes;

@Mapper(componentModel = "spring")
public interface OfferResMapper {

	@Mapping(target = "productPartnumber", expression = "java(getProductPartnumber(offer.talla(), "
			+ "offer.modelo(), offer.calidad()))")
	OfferRes toResponse(Offer offer);

	default String getProductPartnumber(String talla, String modelo, String calidad) {
		return blackIfIsNull(talla).concat(blackIfIsNull(modelo))
				.concat(blackIfIsNull(calidad));
	}	   
	
	private String blackIfIsNull(String dataModel) {
		return (dataModel.isEmpty())?"":dataModel;
	}
	
	List<OfferRes> toResponse(List<Offer> offers);	
	
}
