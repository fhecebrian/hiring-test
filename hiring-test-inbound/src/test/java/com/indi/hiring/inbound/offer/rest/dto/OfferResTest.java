package com.indi.hiring.inbound.offer.rest.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.indi.hiring.domain.offer.model.Offer;

class OfferResTest {

	private  Offer offer1 = new Offer(1L, 2,  Timestamp.valueOf("2023-12-12 01:02:03.123456789"), null, 3, 
			"Product123", 1, new BigDecimal(99.99), "USD");
	private  Offer offer2 = new Offer(2L, 3,  Timestamp.valueOf("2023-12-12 01:02:03.123456789"), null, 4, 
			"Product345", 1, new BigDecimal(199.99), "EUR");
	
	@Test
	void toResponse_whenHasList_thenMappingCorrectly() {
		var offerDomainList = List.of(
				offer1,
				offer2
		);
		var offerResList = List.of(
				new OfferRes(1L, 2,  Timestamp.valueOf("2023-12-12 01:02:03.123456789"), null, 3, 
						"Product123", 1, new BigDecimal(99.99), "USD"),
				new OfferRes(2L, 3,  Timestamp.valueOf("2023-12-12 01:02:03.123456789"), null, 4, 
						"Product345", 1, new BigDecimal(199.99), "EUR")
		);

		var result = OfferRes.toResponse(offerDomainList);

		assertEquals(offerResList, result);
	}

}
