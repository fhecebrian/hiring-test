package com.indi.hiring.inbound.offer.rest.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import com.indi.hiring.domain.offer.model.Offer;
import com.indi.hiring.inbound.offer.rest.dto.OfferCreateReq;

class OfferCreateMapperTest {
	
	private OfferCreateMapper offerCreateMapper = Mappers.getMapper( OfferCreateMapper.class );

	@Test
	void toDomain_whenInvoke_thenMappingCorrectly() {
		var createReq = new OfferCreateReq(2,  Timestamp.valueOf("2023-12-12 01:02:03.123456789"), null, 3, 
				"000100233", 1, new BigDecimal(99.99), "USD");
		var offerDomain = new Offer(null, 2,  Timestamp.valueOf("2023-12-12 01:02:03.123456789"), null, 3, 
				"00", "0100", "233", 1, new BigDecimal(99.99), "USD");

		var result = offerCreateMapper.toDomain(createReq);

		assertEquals(offerDomain, result);
	}

}
