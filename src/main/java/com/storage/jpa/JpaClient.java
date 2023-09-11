package com.storage.jpa;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.storage.BaseEntity;

/**
 * The JpaClient class represents a client entity in a Java Persistence API
 * (JPA) application. Clients are entities that interact with the storage system
 * and may have associated subscriptions.
 */
@Entity
@Table(name = "client")
public class JpaClient extends BaseEntity {

	/**
	 * The unique identifier for the client.
	 */
	@Id
	@Column(name = "id", nullable = false, unique = true)
	private String id;

	/**
	 * A description of the client.
	 */
	@Column(name = "description")
	private String description;

	/**
	 * A set of subscriptions associated with the client.
	 */
	@OneToMany(mappedBy = "client")
	private Set<JpaSubscription> subscriptions = new HashSet<>();

	/**
	 * Default constructor for JpaClient.
	 */
	public JpaClient() {
	}

	/**
	 * Constructor for JpaClient with a specified identifier.
	 *
	 * @param id The unique identifier for the client.
	 */
	public JpaClient(String id) {
		this.id = id;
	}

	/**
	 * Get the unique identifier for the client.
	 *
	 * @return The client's identifier.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Set the unique identifier for the client.
	 *
	 * @param id The client's identifier to set.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Get the description of the client.
	 *
	 * @return The client's description.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set the description of the client.
	 *
	 * @param description The client's description to set.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Set the set of subscriptions associated with the client.
	 *
	 * @param subscriptions The set of subscriptions to set.
	 */
	public void setSubscriptions(Set<JpaSubscription> subscriptions) {
		this.subscriptions = subscriptions;
	}
}
