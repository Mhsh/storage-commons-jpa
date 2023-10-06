package com.storage;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

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
	@Column(name = "created_date", nullable = false, updatable = false, columnDefinition = "timestamp with time zone")
	private OffsetDateTime createdDate;

	/**
	 * The timestamp when the entity was last updated.
	 */
	@Column(name = "updated_date", nullable = false,columnDefinition = "timestamp with time zone")
	private OffsetDateTime updatedDate;

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
		createdDate = OffsetDateTime.now();
		updatedDate = OffsetDateTime.now();
	}

	/**
	 * A callback method executed before updating the entity to set the updated
	 * timestamp.
	 */
	@PreUpdate
	protected void onUpdate() {
		updatedDate = OffsetDateTime.now();
	}

	/**
	 * Get the timestamp when the entity was created.
	 *
	 * @return The creation timestamp.
	 */
	public OffsetDateTime getCreatedDate() {
		return createdDate;
	}

	/**
	 * Set the timestamp when the entity was created.
	 *
	 * @param createdDate The creation timestamp to set.
	 */
	public void setCreatedDate(OffsetDateTime createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * Get the timestamp when the entity was last updated.
	 *
	 * @return The last update timestamp.
	 */
	public OffsetDateTime getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * Set the timestamp when the entity was last updated.
	 *
	 * @param updatedDate The last update timestamp to set.
	 */
	public void setUpdatedDate(OffsetDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
}
