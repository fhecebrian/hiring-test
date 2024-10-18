package com.indi.hiring.domain.offer.usecase;

import com.indi.hiring.architecture.usecase.Query;
import com.indi.hiring.domain.offer.model.Offer;
import com.indi.hiring.domain.offer.port.OfferOutboundPort;

import java.util.List;

import static com.indi.hiring.architecture.context.ServiceLocator.locate;

public class GetOffersQry extends Query<List<Offer>> {

	private final OfferOutboundPort offerPort;

	GetOffersQry(
			OfferOutboundPort offerOutboundPort
	) {
		offerPort = offerOutboundPort;
	}

	public GetOffersQry() {
		this(locate(OfferOutboundPort.class));
	}

	@Override
	protected List<Offer> run() {
		return offerPort.findAll();
	}
}
