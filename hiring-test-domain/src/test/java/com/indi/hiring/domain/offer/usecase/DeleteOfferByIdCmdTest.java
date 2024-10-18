package com.indi.hiring.domain.offer.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;

import com.indi.hiring.domain.offer.model.Offer;
import com.indi.hiring.domain.offer.port.OfferOutboundPort;

class DeleteOfferByIdCmdTest {

	private final OfferOutboundPort offerPort = mock(OfferOutboundPort.class);

	@Test
	void run_whenInvoked_shouldCallOfferOutboundPortFindByIdAndDeleteById() {
		Offer offer = mock(Offer.class);
		Long number = 1L;
		
		try (MockedConstruction<GetOfferByIdQry> mocked = mockConstruction(GetOfferByIdQry.class)) {
			
			doReturn(offer).when(offerPort).findById(number);
			new DeleteOfferByIdCmd(number, offerPort).run();
			assertEquals(1, mocked.constructed().size());
			verify(offerPort).deleteById(number);
			
		}
		
	}
}
