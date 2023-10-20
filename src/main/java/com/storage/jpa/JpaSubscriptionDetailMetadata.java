package com.storage.jpa;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "subscription_detail_metadata", uniqueConstraints = @UniqueConstraint(columnNames = { "metadata_key",
		"subscription_detail_id" }), indexes = {
				@Index(name = "subscription_detail_metadata_exec_metadata_key", columnList = "metadata_key") })
public class JpaSubscriptionDetailMetadata {

	/**
	 * The unique identifier for the entity.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private UUID id;

	@ManyToOne
	@JoinColumn(name = "subscription_detail_id")
	private JpaSubscriptionDetail subscriptionDetail; // Many-to-one relationship to Subscription

	@Column(name = "metadata_key")
	private String metadataKey;

	@Column(name = "metadata_value")
	private String metadataValue;

	/**
	 * @return the id
	 */
	public UUID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(UUID id) {
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
