package com.indi.hiring.outbound.offer.persistence.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.indi.hiring.domain.offer.model.Offer;
import com.indi.hiring.outbound.offer.persistence.model.OfferEntity;

class OfferMapperTest {

    @Test
    void whenHasSingleElement_thenMappingCorrectly() {
    	OfferEntity entity = new OfferEntity(1L, 2,  Timestamp.from(Instant.now()), null, 3, 
    			"Product123", 1, new BigDecimal(99.99), "USD");
        Offer offer = OfferMapper.toDomain(entity);

        assertEquals(entity.getOfferId(), offer.offerId());
        assertEquals(entity.getBrandId(), offer.brandId());
        assertEquals(entity.getStartDate(), offer.startDate());
        assertEquals(entity.getEndDate(), offer.endDate());
        assertEquals(entity.getPriceListId(), offer.priceListId());
        assertEquals(entity.getProductPartnumber(), offer.productPartnumber());
        assertEquals(entity.getPriority(), offer.priority());
        assertEquals(entity.getPrice(), offer.price());
        assertEquals(entity.getCurrencyIso(), offer.currencyIso());
    }

    @Test
    void toDomain_whenHasList_thenMappingCorrectly() {
    	OfferEntity entity1 = new OfferEntity(1L, 2,  Timestamp.from(Instant.now()), null, 3, 
    			"Product123", 1, new BigDecimal(99.99), "USD");
    	OfferEntity entity2 = new OfferEntity(2L, 3,  Timestamp.from(Instant.now()), null, 4, 
    			"Product456", 1, new BigDecimal(199.99), "EUR");
        List<OfferEntity> entityList = Arrays.asList(entity1, entity2);

        List<Offer> offerList = OfferMapper.toDomain(entityList);

        assertEquals(2, offerList.size());
        assertEquals(entity1.getOfferId(), offerList.get(0).offerId());
        assertEquals(entity2.getOfferId(), offerList.get(1).offerId());
    }

    @Test
    void toEntity_whenInvoke_thenMappingCorrectly() {
    	Offer offer = new Offer(1L, 2,  Timestamp.from(Instant.now()), null, 3, 
    			"Product123", 1, new BigDecimal(99.99), "USD");
        OfferEntity entity = OfferMapper.toEntity(offer);

        assertEquals(offer.offerId(), entity.getOfferId());
        assertEquals(offer.brandId(), entity.getBrandId());
        assertEquals(offer.startDate(), entity.getStartDate());
        assertEquals(offer.endDate(), entity.getEndDate());
        assertEquals(offer.priceListId(), entity.getPriceListId());
        assertEquals(offer.productPartnumber(), entity.getProductPartnumber());
        assertEquals(offer.priority(), entity.getPriority());
        assertEquals(offer.price(), entity.getPrice());
        assertEquals(offer.currencyIso(), entity.getCurrencyIso());
    }
}