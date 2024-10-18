package com.indi.hiring.outbound.offer.persistence.adapter;

import java.util.List;
import java.util.Optional;

import com.indi.hiring.domain.offer.model.Offer;
import com.indi.hiring.domain.offer.port.OfferOutboundPort;
import com.indi.hiring.outbound.offer.persistence.OfferJpaRepository;
import com.indi.hiring.outbound.offer.persistence.mapper.OfferMapper;
import com.indi.hiring.outbound.offer.persistence.model.OfferEntity;

import jakarta.inject.Singleton;

@Singleton
public class OfferJpaAdapter implements OfferOutboundPort {

	private final OfferJpaRepository repository;

	public OfferJpaAdapter(OfferJpaRepository repository) {
		this.repository = repository;
	}

	@Override
	public Offer create(Offer offer) {
		return OfferMapper.toDomain(repository.save(OfferMapper.toEntity(offer)));
	}

	@Override
	public List<Offer> findAll() {
		return OfferMapper.toDomain(repository.findAll());
	}

	@Override
	public Offer findById(Long offerId) {
		Optional<OfferEntity> result = repository.findById(offerId);
		return result.map(OfferMapper::toDomain).orElse(null);
	}

//	@Override
//	public Offer update(Offer offer) {
//		return OfferMapper.toDomain(repository.save(OfferMapper.toEntity(offer)));
//	}
	

	@Override
	public void deleteById(Long offerId) {
		repository.deleteById(offerId);
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
	}
	
}
