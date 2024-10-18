package com.indi.hiring.domain.offer.adapter;

import java.util.List;

import com.indi.hiring.architecture.usecase.UseCaseBus;
import com.indi.hiring.domain.offer.model.Offer;
import com.indi.hiring.domain.offer.port.OfferInboundPort;
import com.indi.hiring.domain.offer.usecase.CreateOfferCmd;
import com.indi.hiring.domain.offer.usecase.DeleteOfferByIdCmd;
import com.indi.hiring.domain.offer.usecase.DeleteOffersCmd;
import com.indi.hiring.domain.offer.usecase.GetOfferByIdQry;
import com.indi.hiring.domain.offer.usecase.GetOffersQry;

import jakarta.inject.Singleton;

@Singleton
class OfferInboundAdapter implements OfferInboundPort {
	private final UseCaseBus bus;

	public OfferInboundAdapter(UseCaseBus useCaseBus) {
		bus = useCaseBus;
	}

	@Override
	public Offer create(Offer offer) {
		return bus.invoke(new CreateOfferCmd(offer));
	}

	@Override
	public List<Offer> findAll() {
		return bus.invoke(new GetOffersQry());
	}

	@Override
	public Offer findById(Long offerId) {
		return bus.invoke(new GetOfferByIdQry(offerId));
	}

	@Override
	public Offer deleteOfferById(Long offerId) {
		return bus.invoke(new DeleteOfferByIdCmd(offerId));
	}

	@Override
	public List<Offer> deleteAll() {
		return bus.invoke(new DeleteOffersCmd());
	}
}
