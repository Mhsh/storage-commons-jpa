package com.storage;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The BaseEntity class serves as a base class for entities in a Java
 * Persistence API (JPA) application. It provides common fields like creation
 * and update timestamps that are inherited by other entities.
 */
@MappedSuperclass
public class BaseEntity {

	/**
	 * The timestamp when the entity was created.
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false, updatable = false)
	private Date createdDate;

	/**
	 * The timestamp when the entity was last updated.
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date", nullable = false)
	private Date updatedDate;

	/**
	 * Default constructor for BaseEntity.
	 */
	public BaseEntity() {
	}

	/**
	 * A callback method executed before persisting the entity to set the created
	 * and updated timestamps.
	 */
	@PrePersist
	protected void onCreate() {
		createdDate = new Date();
		updatedDate = createdDate;
	}

	/**
	 * A callback method executed before updating the entity to set the updated
	 * timestamp.
	 */
	@PreUpdate
	protected void onUpdate() {
		updatedDate = new Date();
	}

	/**
	 * Get the timestamp when the entity was created.
	 *
	 * @return The creation timestamp.
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * Set the timestamp when the entity was created.
	 *
	 * @param createdDate The creation timestamp to set.
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * Get the timestamp when the entity was last updated.
	 *
	 * @return The last update timestamp.
	 */
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * Set the timestamp when the entity was last updated.
	 *
	 * @param updatedDate The last update timestamp to set.
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
}
