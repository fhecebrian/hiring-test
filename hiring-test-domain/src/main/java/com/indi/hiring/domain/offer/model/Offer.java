package com.indi.hiring.domain.offer.model;

import java.math.BigDecimal;
import java.sql.Timestamp;


public record Offer(Long offerId, Integer brandId, Timestamp startDate,
		Timestamp endDate,Integer priceListId, String talla, String modelo,
		 String calidad, Integer priority, BigDecimal price, String currencyIso) {
	
}
