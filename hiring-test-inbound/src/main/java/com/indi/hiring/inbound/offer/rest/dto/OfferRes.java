package com.indi.hiring.inbound.offer.rest.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

public record OfferRes(Long offerId, Integer brandId, Timestamp startDate,
		Timestamp endDate,Integer priceListId, String productPartnumber,
		Integer priority, BigDecimal price, String currencyIso) {
}
