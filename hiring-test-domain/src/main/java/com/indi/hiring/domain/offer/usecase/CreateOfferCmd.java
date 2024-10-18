package com.indi.hiring.domain.offer.usecase;

import static com.indi.hiring.architecture.context.ServiceLocator.locate;

import com.indi.hiring.architecture.usecase.Command;
import com.indi.hiring.domain.offer.model.Offer;
import com.indi.hiring.domain.offer.port.OfferOutboundPort;

public class CreateOfferCmd extends Command<Offer> {

	private final Offer offer;
	private final OfferOutboundPort offerPort;

	CreateOfferCmd(
			Offer offerToCreate,
			OfferOutboundPort offerOutboundPort
	) {
		offer = offerToCreate;
		offerPort = offerOutboundPort;
	}

	public CreateOfferCmd(
			Offer offerToCreate
	) {
		this(offerToCreate, locate(OfferOutboundPort.class));
	}

	@Override
	protected Offer run() {
		return offerPort.create(offer);
	}
}
