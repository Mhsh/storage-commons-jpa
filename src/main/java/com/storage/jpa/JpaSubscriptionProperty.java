package com.storage.jpa;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.storage.BaseEntity;

/**
 * The JpaSubscriptionProperty class represents a property associated with a
 * subscription in a Java Persistence API (JPA) application. Subscription
 * properties are key-value pairs related to connector metadata values.
 */
@Entity
@Table(name = "subscription_property")
public class JpaSubscriptionProperty extends BaseEntity{

	/**
	 * The unique identifier for the subscription property.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * The connector metadata associated with the subscription property.
	 */
	@ManyToOne
	@JoinColumn(name = "connector_metadata")
	private JpaConnectorMetadata connectorMetadata;

	/**
	 * The set of values associated with the subscription property.
	 */
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "sub_conn_metadata_values", joinColumns = @JoinColumn(name = "subscription_property_id"))
	@Column(name = "property_value")
	private Set<String> values = new HashSet<>();

	/**
	 * The subscription to which the property belongs.
	 */
	@ManyToOne
	@JoinColumn(name = "subscription_id")
	private JpaSubscription subscription;

	/**
	 * Default constructor for JpaSubscriptionProperty.
	 */
	public JpaSubscriptionProperty() {
		super();
	}

	/**
	 * Constructor for JpaSubscriptionProperty with a specified connector metadata
	 * and set of values.
	 *
	 * @param connectorMetadata The connector metadata associated with the
	 *                          subscription property.
	 * @param values            The set of values associated with the subscription
	 *                          property.
	 */
	public JpaSubscriptionProperty(JpaConnectorMetadata connectorMetadata, Set<String> values) {
		super();
		this.connectorMetadata = connectorMetadata;
		this.values = values;
	}

	/**
	 * Get the unique identifier for the subscription property.
	 *
	 * @return The property's identifier.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Set the unique identifier for the subscription property.
	 *
	 * @param id The property's identifier to set.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Get the connector metadata associated with the subscription property.
	 *
	 * @return The associated connector metadata.
	 */
	public JpaConnectorMetadata getConnectorMetadata() {
		return connectorMetadata;
	}

	/**
	 * Set the connector metadata associated with the subscription property.
	 *
	 * @param connectorMetadata The connector metadata to set.
	 */
	public void setConnectorMetadata(JpaConnectorMetadata connectorMetadata) {
		this.connectorMetadata = connectorMetadata;
	}

	/**
	 * Get the set of values associated with the subscription property.
	 *
	 * @return The set of values.
	 */
	public Set<String> getValues() {
		return values;
	}

	/**
	 * Set the set of values associated with the subscription property.
	 *
	 * @param values The set of values to set.
	 */
	public void setValues(Set<String> values) {
		this.values = values;
	}

	/**
	 * Get the subscription to which the property belongs.
	 *
	 * @return The associated subscription.
	 */
	public JpaSubscription getSubscription() {
		return subscription;
	}

	/**
	 * Set the subscription to which the property belongs.
	 *
	 * @param subscription The subscription to set.
	 */
	public void setSubscription(JpaSubscription subscription) {
		this.subscription = subscription;
	}
}
