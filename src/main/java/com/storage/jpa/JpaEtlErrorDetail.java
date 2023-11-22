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
import com.storage.jpa.Enums.FileType;

@Entity
@Table(name = "error_etl_detail")
public class JpaEtlErrorDetail {

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

	@Column(name = "error_type", columnDefinition = "text")
	private String errorType;

	@Column(name = "error_detail", columnDefinition = "text")
	private String errorDetail;

	private ConnectorType connectorType;

	private FileType fileType;

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
	 * @return the errorType
	 */
	public String getErrorType() {
		return errorType;
	}

	/**
	 * @param errorType the errorType to set
	 */
	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}

}
