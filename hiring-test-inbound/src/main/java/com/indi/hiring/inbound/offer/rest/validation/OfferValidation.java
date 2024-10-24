package com.indi.hiring.inbound.offer.rest.validation;

import java.util.function.Consumer;

import org.springframework.http.HttpStatus;

import com.indi.hiring.inbound.exception.BussinesRuleException;
import com.indi.hiring.inbound.offer.rest.dto.OfferCreateReq;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OfferValidation {

	public static final Consumer<OfferCreateReq> validateProductPartnumber = offer -> {
		if (offer.productPartnumber() == null || offer.productPartnumber().length() != 9) {
			throw new BussinesRuleException("1025", "Error validation, product whith productPartnumber "
					+ offer.productPartnumber() + " is not correct", HttpStatus.PRECONDITION_FAILED);
		}
	};

	public static final Consumer<OfferCreateReq> validateOffer = offer -> validateProductPartnumber.accept(offer);

}
