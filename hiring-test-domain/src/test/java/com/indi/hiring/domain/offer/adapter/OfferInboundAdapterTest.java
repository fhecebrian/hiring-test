package com.indi.hiring.domain.offer.adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.indi.hiring.architecture.usecase.UseCaseBus;
import com.indi.hiring.domain.offer.model.Offer;
import com.indi.hiring.domain.offer.usecase.CreateOfferCmd;
import com.indi.hiring.domain.offer.usecase.DeleteOfferByIdCmd;
import com.indi.hiring.domain.offer.usecase.DeleteOffersCmd;
import com.indi.hiring.domain.offer.usecase.GetOffersQry;


class OfferInboundAdapterTest {

	private final UseCaseBus bus = mock(UseCaseBus.class);
	private final OfferInboundAdapter sut = new OfferInboundAdapter(bus);

	private  Offer offer = new Offer(null, 2,  Timestamp.from(Instant.now()), null, 3, 
			"00","0100","233", 1, new BigDecimal(99.99), "USD");
	private  Offer offerExpeted = new Offer(1L, 2,  Timestamp.from(Instant.now()), null, 3, 
			"01","0200","333", 1, new BigDecimal(99.99), "USD");
	
	@Test
	void create_whenInvoke_thenCallCreateOfferCmd() {

		sut.create(offer);

		verify(bus).invoke(any(CreateOfferCmd.class));
	}

	@Test
	void create_whenCreateClientCmdReturnClient_thenReturnCorrectly() {
		doReturn(offerExpeted).when(bus).invoke(any(CreateOfferCmd.class));

		var result = sut.create(offer);

		assertEquals(offerExpeted, result);
	}

	@Test
	void findAll_whenInvoke_thenCallGetOffersQry() {
		sut.findAll();

		verify(bus).invoke(any(GetOffersQry.class));
	}

	@Test
	void findAll_whenPortReturnElements_thenReturnCorrectly() {
		var expectedList = List.of(
				offer,
				offerExpeted
		);
		doReturn(expectedList).when(bus).invoke(any(GetOffersQry.class));

		var result = sut.findAll();

		assertEquals(expectedList, result);
	}

	@Test
	void DeleteOfferById_whenInvoked_shouldCallDeleteOfferByIdCmd() {
		var offerId = 1L;

		doReturn(offerExpeted).when(bus).invoke(any(DeleteOfferByIdCmd.class));

		var result = sut.deleteOfferById(offerId);

		verify(bus).invoke(any(DeleteOfferByIdCmd.class));
		assertEquals(offerId, result.offerId());
	}
	
	@Test
	void DeleteOffers_whenInvoked_shouldCallDeleteOffersCmd() {
		var expectedList = List.of(
				offer,
				offerExpeted
		);
		doReturn(expectedList).when(bus).invoke(any(DeleteOffersCmd.class));

		var result = sut.deleteAll();

		verify(bus).invoke(any(DeleteOffersCmd.class));
		assertEquals(2, result.size());
	}	
}
