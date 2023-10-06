package com.storage.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "subscription_detail_metadata")
public class JpaSubscriptionDetailMetadata {

	/**
	 * The unique identifier for the mapping.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "subscription_detail")
	private JpaSubscriptionDetail subscriptionDetail; // Many-to-one relationship to Subscription

	@Column(name = "metadata_key")
	private String metadataKey;

	@Column(name = "metadata_value")
	private String metadataValue;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the subscriptionDetal
	 */
	public JpaSubscriptionDetail getSubscriptionDetail() {
		return subscriptionDetail;
	}

	/**
	 * @param subscriptionDetal the subscriptionDetal to set
	 */
	public void setSubscriptionDetail(JpaSubscriptionDetail subscriptionDetail) {
		this.subscriptionDetail = subscriptionDetail;
	}

	/**
	 * @return the metadataKey
	 */
	public String getMetadataKey() {
		return metadataKey;
	}

	/**
	 * @param metadataKey the metadataKey to set
	 */
	public void setMetadataKey(String metadataKey) {
		this.metadataKey = metadataKey;
	}

	/**
	 * @return the metadataValue
	 */
	public String getMetadataValue() {
		return metadataValue;
	}

	/**
	 * @param metadataValue the metadataValue to set
	 */
	public void setMetadataValue(String metadataValue) {
		this.metadataValue = metadataValue;
	}

}