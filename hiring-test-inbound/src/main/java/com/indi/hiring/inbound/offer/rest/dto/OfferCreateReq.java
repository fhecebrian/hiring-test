package com.indi.hiring.inbound.offer.rest.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record OfferCreateReq(@NotNull(message = "Mandatory value brandId")Integer brandId, 
		@NotEmpty(message = "No empty value startDate")@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH.mm.ss'Z'", timezone="Europe/Berlin") Timestamp startDate,
		@NotEmpty(message = "No empty value startDate")@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH.mm.ss'Z'", timezone="Europe/Berlin") Timestamp endDate,
		@NotNull(message = "Mandatory value offerId")Integer priceListId, String productPartnumber, Integer priority, BigDecimal price, String currencyIso) {
}
