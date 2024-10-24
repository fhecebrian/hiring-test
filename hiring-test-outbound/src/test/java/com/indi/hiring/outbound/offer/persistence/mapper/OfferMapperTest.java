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

	private  OfferEntity offerEntity = new OfferEntity(null, 2,  Timestamp.from(Instant.now()), null, 3, 
			"00","0100","233", 1, new BigDecimal(99.99), "USD");
	private  OfferEntity offerEntityExpeted = new OfferEntity(1L, 2,  Timestamp.from(Instant.now()), null, 3, 
			"01","0200","333", 1, new BigDecimal(99.99), "USD");
	private Offer offer = new Offer(1L, 2,  Timestamp.from(Instant.now()), null, 3, 
			"00","0100","233", 1, new BigDecimal(99.99), "USD");
	
    @Test
    void whenHasSingleElement_thenMappingCorrectly() {
        Offer offer = OfferMapper.toDomain(offerEntity);

        assertEquals(offerEntity.getOfferId(), offer.offerId());
        assertEquals(offerEntity.getBrandId(), offer.brandId());
        assertEquals(offerEntity.getStartDate(), offer.startDate());
        assertEquals(offerEntity.getEndDate(), offer.endDate());
        assertEquals(offerEntity.getPriceListId(), offer.priceListId());
        assertEquals(offerEntity.getTalla(), offer.talla());
        assertEquals(offerEntity.getModelo(), offer.modelo());
        assertEquals(offerEntity.getCalidad(), offer.calidad());
        assertEquals(offerEntity.getPriority(), offer.priority());
        assertEquals(offerEntity.getPrice(), offer.price());
        assertEquals(offerEntity.getCurrencyIso(), offer.currencyIso());
    }

    @Test
    void toDomain_whenHasList_thenMappingCorrectly() {
        List<OfferEntity> entityList = Arrays.asList(offerEntity, offerEntityExpeted);

        List<Offer> offerList = OfferMapper.toDomain(entityList);

        assertEquals(2, offerList.size());
        assertEquals(offerEntity.getOfferId(), offerList.get(0).offerId());
        assertEquals(offerEntityExpeted.getOfferId(), offerList.get(1).offerId());
    }

    @Test
    void toEntity_whenInvoke_thenMappingCorrectly() {
        OfferEntity entity = OfferMapper.toEntity(offer);

        assertEquals(offer.offerId(), entity.getOfferId());
        assertEquals(offer.brandId(), entity.getBrandId());
        assertEquals(offer.startDate(), entity.getStartDate());
        assertEquals(offer.endDate(), entity.getEndDate());
        assertEquals(offer.priceListId(), entity.getPriceListId());
        assertEquals(offer.talla(), offerEntity.getTalla());
        assertEquals(offer.modelo(), offerEntity.getModelo());
        assertEquals(offer.calidad(), offerEntity.getCalidad());
        assertEquals(offer.priority(), entity.getPriority());
        assertEquals(offer.price(), entity.getPrice());
        assertEquals(offer.currencyIso(), entity.getCurrencyIso());
    }
}