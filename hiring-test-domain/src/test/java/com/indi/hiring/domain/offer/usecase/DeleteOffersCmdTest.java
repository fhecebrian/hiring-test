package com.indi.hiring.domain.offer.usecase;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

import com.indi.hiring.domain.offer.model.Offer;
import com.indi.hiring.domain.offer.port.OfferOutboundPort;

class DeleteOffersCmdTest {

	private final OfferOutboundPort offerPort = mock(OfferOutboundPort.class);

	@Test
	void run_whenInvoked_shouldCallOfferOutboundPortFindAllAndDeleteAll() {
		Offer offer = mock(Offer.class);
		Offer offerWithId = mock(Offer.class);
		doReturn(offerWithId).when(offerPort).create(offer);

		new DeleteOffersCmd(offerPort).run();

		verify(offerPort).findAll();
		verify(offerPort).deleteAll();
	}
	
}
