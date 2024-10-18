package com.indi.hiring.domain.offer.usecase;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

import com.indi.hiring.domain.offer.model.Offer;
import com.indi.hiring.domain.offer.port.OfferOutboundPort;

class CreateOfferCmdTest {

	private final OfferOutboundPort offerPort = mock(OfferOutboundPort.class);

	@Test
	void run_whenInvoked_shouldCallOfferOutboundPortFindAll() {
		Offer offer = mock(Offer.class);
		Offer offerWithId = mock(Offer.class);
		doReturn(offerWithId).when(offerPort).create(offer);

		new CreateOfferCmd(offer, offerPort).run();

		verify(offerPort).create(offer);
	}

}
