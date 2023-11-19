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
import com.storage.jpa.Enums.EngineType;

@Entity
@Table(name = "error_detail")
public class JpaErrorDetail {

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

	private EngineType engineType;

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
	 * @return the engineType
	 */
	public EngineType getEngineType() {
		return engineType;
	}

	/**
	 * @param engineType the engineType to set
	 */
	public void setEngineType(EngineType engineType) {
		this.engineType = engineType;
	}

}
