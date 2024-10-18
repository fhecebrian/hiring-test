package com.indi.hiring.domain.offer.model;

import java.math.BigDecimal;
import java.sql.Timestamp;


public record Offer(Long offerId, Integer brandId, Timestamp startDate,
		Timestamp endDate,Integer priceListId, String productPartnumber,
		Integer priority, BigDecimal price, String currencyIso) {
}
