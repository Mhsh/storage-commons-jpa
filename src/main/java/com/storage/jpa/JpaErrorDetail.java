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
@Table(name = "error_detail")
public class JpaErrorDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "subscription_detail_id")
	private JpaSubscriptionDetail jpaSubscriptionDetail;

	@Column(name = "error_code")
	private Integer errorCode;

	@Column(name = "error_detail")
	private String errorDetail;

	@Column(name = "retry_count")
	private Integer retryCount;

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
	 * @return the jpaSubscriptionDetail
	 */
	public JpaSubscriptionDetail getJpaSubscriptionDetail() {
		return jpaSubscriptionDetail;
	}

	/**
	 * @param jpaSubscriptionDetail the jpaSubscriptionDetail to set
	 */
	public void setJpaSubscriptionDetail(JpaSubscriptionDetail jpaSubscriptionDetail) {
		this.jpaSubscriptionDetail = jpaSubscriptionDetail;
	}

	/**
	 * @return the errorCode
	 */
	public Integer getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
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

}
