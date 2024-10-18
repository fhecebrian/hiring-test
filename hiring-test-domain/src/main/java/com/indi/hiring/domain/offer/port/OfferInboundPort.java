package com.indi.hiring.domain.offer.port;

import java.util.List;

import com.indi.hiring.domain.offer.model.Offer;

public interface OfferInboundPort {
	Offer create(Offer offer);

	List<Offer> findAll();

	Offer findById(Long offerId);
	
	Offer deleteOfferById (Long offerId);
	
	List<Offer> deleteAll();
}
