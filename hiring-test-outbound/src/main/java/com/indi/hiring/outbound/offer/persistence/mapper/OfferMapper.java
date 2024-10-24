package com.indi.hiring.outbound.offer.persistence.mapper;

import java.util.List;

import com.indi.hiring.domain.offer.model.Offer;
import com.indi.hiring.outbound.offer.persistence.model.OfferEntity;

public class OfferMapper {

	private OfferMapper() {
	}

	public static Offer toDomain(OfferEntity entity) {
		return new Offer(entity.getOfferId(), entity.getBrandId(), entity.getStartDate(),
				entity.getEndDate(), entity.getPriceListId(), entity.getTalla(),
				entity.getModelo(), entity.getCalidad(), entity.getPriority(), 
				entity.getPrice(), entity.getCurrencyIso());
	}
	public static List<Offer> toDomain(List<OfferEntity> entityList) {
		return entityList.stream().map(OfferMapper::toDomain).toList();
	}

	public static OfferEntity toEntity(Offer offer) {
		return new OfferEntity(offer.offerId(), offer.brandId(),
				offer.startDate(), offer.endDate(), offer.priceListId(),
				offer.talla(), offer.modelo(), offer.calidad(), 
				offer.priority(), offer.price(), offer.currencyIso());
	}
}
