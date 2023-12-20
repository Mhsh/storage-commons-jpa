package com.storage.jpa;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.storage.jpa.Enums.ConnectorType;

@Entity
@Table(name = "error_ingestion_detail")
public class JpaIngestionErrorDetail {

	/**
	 * The unique identifier for the entity.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private UUID id;

	@ManyToOne
	@JoinColumn(name = "subscription_detail_id")
	private JpaSubscriptionDetail subscriptionDetail;

	@Column(name = "type", columnDefinition = "text")
	private String type;

	@Column(name = "error_detail", columnDefinition = "text")
	private String errorDetail;

	@Column(name = "retry_count")
	private Integer retryCount;

	private ConnectorType connectorType;

	@ManyToOne
	@JoinColumn(name = "subscription_id")
	private JpaSubscription subscription; // Many-to-one relationship to Subscription

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
	 * @return the subscriptionDetail
	 */
	public JpaSubscriptionDetail getSubscriptionDetail() {
		return subscriptionDetail;
	}

	/**
	 * @param subscriptionDetail the subscriptionDetail to set
	 */
	public void setSubscriptionDetail(JpaSubscriptionDetail subscriptionDetail) {
		this.subscriptionDetail = subscriptionDetail;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the errorDetail
	 */
	public String getErrorDetail() {
		return errorDetail;
	}

	/**
	 * @param errorDetail the errorDetail to set
	 */
	public void setErrorDetail(String errorDetail) {
		this.errorDetail = errorDetail;
	}

	/**
	 * @return the retryCount
	 */
	public Integer getRetryCount() {
		return retryCount;
	}

	/**
	 * @param retryCount the retryCount to set
	 */
	public void setRetryCount(Integer retryCount) {
		this.retryCount = retryCount;
	}

	/**
	 * @return the connectorType
	 */
	public ConnectorType getConnectorType() {
		return connectorType;
	}

	/**
	 * @param connectorType the connectorType to set
	 */
	public void setConnectorType(ConnectorType connectorType) {
		this.connectorType = connectorType;
	}

	/**
	 * @return the subscription
	 */
	public JpaSubscription getSubscription() {
		return subscription;
	}

	/**
	 * @param subscription the subscription to set
	 */
	public void setSubscription(JpaSubscription subscription) {
		this.subscription = subscription;
	}

}
