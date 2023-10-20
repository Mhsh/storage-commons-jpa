package com.storage.jpa;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.storage.BaseEntity;

/**
 * The JpaSubscription class represents a subscription entity in a Java
 * Persistence API (JPA) application. Subscriptions are associations between a
 * client, a connector, and related properties.
 */
@Entity
@Table(name = "subscription")
public class JpaSubscription extends BaseEntity {

	/**
	 * The unique identifier for the entity.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private UUID id;

	/**
	 * The client associated with the subscription.
	 */
	@ManyToOne
	@JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_client_id"))
	private JpaClient client;

	/**
	 * The connector associated with the subscription.
	 */
	@ManyToOne
	@JoinColumn(name = "connector_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_connector_id"))
	private JpaConnector connector;

	/**
	 * A set of metadata associated with the connector.
	 */
	@OneToMany(mappedBy = "subscription", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private Set<JpaSubscriptionDetail> metadata = new HashSet<>();

	/**
	 * Default constructor for JpaSubscription.
	 */
	public JpaSubscription() {
	}

	/**
	 * Constructor for JpaSubscription with a specified client and connector.
	 *
	 * @param client    The client associated with the subscription.
	 * @param connector The connector associated with the subscription.
	 */
	public JpaSubscription(JpaClient client, JpaConnector connector) {
		this.client = client;
		this.connector = connector;
	}

	/**
	 * Get the unique identifier for the subscription.
	 *
	 * @return The subscription's identifier.
	 */
	public UUID getId() {
		return id;
	}

	/**
	 * Set the unique identifier for the subscription.
	 *
	 * @param id The subscription's identifier to set.
	 */
	public void setId(UUID id) {
		this.id = id;
	}

	/**
	 * Get the client associated with the subscription.
	 *
	 * @return The associated client.
	 */
	public JpaClient getClient() {
		return client;
	}

	/**
	 * Set the client associated with the subscription.
	 *
	 * @param client The client to set.
	 */
	public void setClient(JpaClient client) {
		this.client = client;
	}

	/**
	 * Get the connector associated with the subscription.
	 *
	 * @return The associated connector.
	 */
	public JpaConnector getConnector() {
		return connector;
	}

	/**
	 * Set the connector associated with the subscription.
	 *
	 * @param connector The connector to set.
	 */
	public void setConnector(JpaConnector connector) {
		this.connector = connector;
	}

}
