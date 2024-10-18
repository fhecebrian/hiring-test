package com.indi.hiring.domain.offer.usecase;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.indi.hiring.domain.offer.model.Offer;
import com.indi.hiring.domain.offer.port.OfferOutboundPort;

class GetOffersQryTest {

	private final OfferOutboundPort offerPort = mock(OfferOutboundPort.class);

	@Test
	void run_whenInvoked_shouldCallOfferOutboundPortFindAll() {
		Offer offer = mock(Offer.class);
		doReturn(List.of(offer)).when(offerPort).findAll();

		new GetOffersQry(offerPort).run();

		verify(offerPort).findAll();
	}
}
