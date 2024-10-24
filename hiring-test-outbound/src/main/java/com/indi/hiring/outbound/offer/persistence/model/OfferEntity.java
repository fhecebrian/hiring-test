package com.indi.hiring.outbound.offer.persistence.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(name = "Offer")
@AllArgsConstructor
@NoArgsConstructor
public class OfferEntity {
	
	@Id	
	@Column(name = "OFFER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long offerId;

	@Column(name = "BRAND_ID")
	private Integer brandId;

	@Column(name = "START_DATE")
	private Timestamp startDate;

	@Column(name = "END_DATE")
	private Timestamp endDate;

	@Column(name = "PRICE_LIST")
	private Integer priceListId;

	@Column(name = "TALLA")
	private String talla;
	
	@Column(name = "MODELO")
	private String modelo;
	
	@Column(name = "CALIDAD")
	private String calidad;

	@Column(name = "PRIORITY")
	private Integer priority;

	@Column(name = "PRICE")
	private BigDecimal price;

	@Column(name = "CURR")
	private String currencyIso;
}
