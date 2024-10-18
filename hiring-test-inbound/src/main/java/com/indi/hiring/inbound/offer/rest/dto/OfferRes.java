package com.indi.hiring.inbound.offer.rest.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import com.indi.hiring.domain.offer.model.Offer;

public record OfferRes(Long offerId, Integer brandId, Timestamp startDate,
		Timestamp endDate,Integer priceListId, String productPartnumber,
		Integer priority, BigDecimal price, String currencyIso) {
	public static OfferRes toResponse(Offer offer) {
		if(Optional.ofNullable(offer).isEmpty()) {
			return new OfferRes(-1L, null, null, null, null, null, null, null, null);
		}
		return new OfferRes(offer.offerId(), offer.brandId(),
				offer.startDate(), offer.endDate(), offer.priceListId(),
				offer.productPartnumber(), offer.priority(), offer.price(), offer.currencyIso());
	}

	public static List<OfferRes> toResponse(List<Offer> offers) {
		return offers.stream().map(OfferRes::toResponse).toList();
	}
}
