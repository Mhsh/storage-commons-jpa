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

/**
 * The JpaMapping class represents a mapping entity that associates a
 * subscription with source and internal keys in a Java Persistence API (JPA)
 * application. Mappings are used to establish relationships between
 * subscriptions and keys.
 */
@Entity
@Table(name = "etl_subscription_mapping")
public class JpaMapping extends BaseEntity {
	/**
	 * The unique identifier for the entity.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private UUID id;

	/**
	 * The subscription associated with the mapping.
	 */
	@ManyToOne
	@JoinColumn(name = "subscription_id")
	private JpaSubscription subscription;

	/**
	 * The source key associated with the mapping.
	 */
	@Column(name = "sourcekey", nullable = false)
	private String sourcekey;

	/**
	 * The internal key associated with the mapping.
	 */
	@Column(name = "internalkey", nullable = false)
	private String internalkey;

	/**
	 * The type of mapping.
	 */
	@Column(name = "type", nullable = false)
	private String type;

	/**
	 * Get the unique identifier for the mapping.
	 *
	 * @return The mapping's identifier.
	 */
	public UUID getId() {
		return id;
	}

	/**
	 * Set the unique identifier for the mapping.
	 *
	 * @param id The mapping's identifier to set.
	 */
	public void setId(UUID id) {
		this.id = id;
	}

	/**
	 * Get the subscription associated with the mapping.
	 *
	 * @return The associated subscription.
	 */
	public JpaSubscription getSubscription() {
		return subscription;
	}

	/**
	 * Set the subscription associated with the mapping.
	 *
	 * @param subscription The subscription to set.
	 */
	public void setSubscription(JpaSubscription subscription) {
		this.subscription = subscription;
	}

	/**
	 * Get the source key associated with the mapping.
	 *
	 * @return The source key.
	 */
	public String getSourcekey() {
		return sourcekey;
	}

	/**
	 * Set the source key associated with the mapping.
	 *
	 * @param sourcekey The source key to set.
	 */
	public void setSourcekey(String sourcekey) {
		this.sourcekey = sourcekey;
	}

	/**
	 * Get the internal key associated with the mapping.
	 *
	 * @return The internal key.
	 */
	public String getInternalkey() {
		return internalkey;
	}

	/**
	 * Set the internal key associated with the mapping.
	 *
	 * @param internalkey The internal key to set.
	 */
	public void setInternalkey(String internalkey) {
		this.internalkey = internalkey;
	}

	/**
	 * Get the type of mapping.
	 *
	 * @return The mapping type.
	 */
	public String getType() {
		return type;
	}

	/**
	 * Set the type of mapping.
	 *
	 * @param type The mapping type to set.
	 */
	public void setType(String type) {
		this.type = type;
	}
}
