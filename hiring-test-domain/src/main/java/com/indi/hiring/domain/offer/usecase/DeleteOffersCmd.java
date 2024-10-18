package com.indi.hiring.domain.offer.usecase;

import static com.indi.hiring.architecture.context.ServiceLocator.locate;

import java.util.List;

import com.indi.hiring.architecture.usecase.Command;
import com.indi.hiring.domain.offer.model.Offer;
import com.indi.hiring.domain.offer.port.OfferOutboundPort;

public class DeleteOffersCmd extends Command<List<Offer>> {

	private final OfferOutboundPort offerPort;

	DeleteOffersCmd(
			OfferOutboundPort offerOutboundPort
	) {
		offerPort = offerOutboundPort;
	}

	public DeleteOffersCmd() {
		this(locate(OfferOutboundPort.class));
	}

	@Override
	protected List<Offer> run() {
		List<Offer> totalOfferts = offerPort.findAll();
		offerPort.deleteAll();
		return totalOfferts;
	}
}
