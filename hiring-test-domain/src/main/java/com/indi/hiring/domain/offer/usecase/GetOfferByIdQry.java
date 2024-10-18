package com.indi.hiring.domain.offer.usecase;

import static com.indi.hiring.architecture.context.ServiceLocator.locate;

import com.indi.hiring.architecture.usecase.Query;
import com.indi.hiring.domain.offer.model.Offer;
import com.indi.hiring.domain.offer.port.OfferOutboundPort;

public class GetOfferByIdQry extends Query<Offer> {

	private final Long offerId;
	private final OfferOutboundPort offerPort;

	GetOfferByIdQry(
			Long id,
			OfferOutboundPort offerOutboundPort
	) {
		offerId = id;
		offerPort = offerOutboundPort;
	}

	public GetOfferByIdQry(
			Long id
	) {
		this(id, locate(OfferOutboundPort.class));
	}

	@Override
	protected Offer run() {
		return offerPort.findById(offerId);
	}
}
