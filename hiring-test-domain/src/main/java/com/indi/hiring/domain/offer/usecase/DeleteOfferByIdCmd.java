package com.indi.hiring.domain.offer.usecase;

import static com.indi.hiring.architecture.context.ServiceLocator.locate;

import com.indi.hiring.architecture.usecase.Command;
import com.indi.hiring.domain.offer.model.Offer;
import com.indi.hiring.domain.offer.port.OfferOutboundPort;

public class DeleteOfferByIdCmd extends Command<Offer> {

	private final Long offerId;
	private final OfferOutboundPort offerPort;

	DeleteOfferByIdCmd(
			Long id,
			OfferOutboundPort offerOutboundPort
	) {
		offerId = id;
		offerPort = offerOutboundPort;
	}

	public DeleteOfferByIdCmd(
			Long id
	) {
		this(id, locate(OfferOutboundPort.class));
	}

	@Override
	protected Offer run() {
		Offer offer = run(new GetOfferByIdQry(offerId));
		offerPort.deleteById(offerId);
		return offer;
	}
}
