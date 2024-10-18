package com.indi.hiring.outbound.offer.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.indi.hiring.outbound.offer.persistence.model.OfferEntity;

public interface OfferJpaRepository extends JpaRepository<OfferEntity, Long> {
}
