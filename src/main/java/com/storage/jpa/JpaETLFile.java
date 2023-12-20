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

import com.storage.BaseEntity;
import com.storage.jpa.Enums.ConnectorType;
import com.storage.jpa.Enums.FileType;

@Entity
@Table(name = "etl_file")
public class JpaETLFile extends BaseEntity {

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

	@ManyToOne
	@JoinColumn(name = "subscription_id")
	private JpaSubscription subscription; // Many-to-one relationship to Subscription
	/**
	 * The file path of the transformed data file.
	 */
	@Column(name = "rawFilePath")
	private String rawFilePath;

	/**
	 * The client id for subscription.
	 */
	@Column(name = "clientId")
	private String clientId;

	/**
	 * The file type to be handled.
	 */
	@Column(name = "fileType")
	private FileType fileType;

	private ConnectorType connectorType;

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
	 * @return the rawFilePath
	 */
	public String getRawFilePath() {
		return rawFilePath;
	}

	/**
	 * @param rawFilePath the rawFilePath to set
	 */
	public void setRawFilePath(String rawFilePath) {
		this.rawFilePath = rawFilePath;
	}

	/**
	 * @return the clientId
	 */
	public String getClientId() {
		return clientId;
	}

	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return the fileType
	 */
	public FileType getFileType() {
		return fileType;
	}

	/**
	 * @param fileType the fileType to set
	 */
	public void setFileType(FileType fileType) {
		this.fileType = fileType;
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
