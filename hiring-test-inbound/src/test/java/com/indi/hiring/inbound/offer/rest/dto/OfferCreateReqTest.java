package com.indi.hiring.inbound.offer.rest.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.junit.jupiter.api.Test;

import com.indi.hiring.domain.offer.model.Offer;

class OfferCreateReqTest {

	@Test
	void toDomain_whenInvoke_thenMappingCorrectly() {
		var createReq = new OfferCreateReq(2,  Timestamp.valueOf("2023-12-12 01:02:03.123456789"), null, 3, 
				"Product123", 1, new BigDecimal(99.99), "USD");
		var clientDomain = new Offer(null, 2,  Timestamp.valueOf("2023-12-12 01:02:03.123456789"), null, 3, 
				"Product123", 1, new BigDecimal(99.99), "USD");

		var result = OfferCreateReq.toDomain(createReq);

		assertEquals(clientDomain, result);
	}

}
