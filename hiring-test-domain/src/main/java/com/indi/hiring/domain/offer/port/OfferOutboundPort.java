package com.indi.hiring.domain.offer.port;

import java.util.List;

import com.indi.hiring.domain.offer.model.Offer;

public interface OfferOutboundPort {
	Offer create(Offer offer);

	List<Offer> findAll();

	Offer findById(Long offerId);
	
	void deleteById (Long offerId);
	
	void deleteAll();
}
