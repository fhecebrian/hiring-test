package com.indi.hiring.domain.offer.usecase;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

import com.indi.hiring.domain.offer.model.Offer;
import com.indi.hiring.domain.offer.port.OfferOutboundPort;

class GetOffertByIdQryTest {

	private final OfferOutboundPort offerPort = mock(OfferOutboundPort.class);

	@Test
	void run_whenInvoked_shouldCallOfferOutboundPortFindById() {
		Long offerId = 1L;
		Offer offer = mock(Offer.class);
		doReturn(offer).when(offerPort).findById(offerId);

		new GetOfferByIdQry(offerId, offerPort).run();

		verify(offerPort).findById(offerId);
	}
}
