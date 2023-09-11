package com.storage.jpa;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
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
	 * The unique identifier for the subscription.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * The client associated with the subscription.
	 */
	@ManyToOne
	@JoinColumn(name = "client_name", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_client_id"))
	private JpaClient client;

	/**
	 * The connector associated with the subscription.
	 */
	@ManyToOne
	@JoinColumn(name = "connector_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_connector_id"))
	private JpaConnector connector;

	/**
	 * The set of subscription properties associated with the subscription.
	 */
	@OneToMany(mappedBy = "subscription", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private Set<JpaSubscriptionProperty> properties = new HashSet<>();

	/**
	 * The duration of the subscription.
	 */
	@Column(name = "duration")
	private Integer duration;

	/**
	 * The date of the next scheduled event for the subscription.
	 */
	@Column(name = "nextSchedule")
	private Date nextSchedule;

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
	public Long getId() {
		return id;
	}

	/**
	 * Set the unique identifier for the subscription.
	 *
	 * @param id The subscription's identifier to set.
	 */
	public void setId(Long id) {
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

	/**
	 * Get the set of subscription properties associated with the subscription.
	 *
	 * @return The set of properties.
	 */
	public Set<JpaSubscriptionProperty> getProperties() {
		return properties;
	}

	/**
	 * Set the set of subscription properties associated with the subscription.
	 *
	 * @param properties The set of properties to set.
	 */
	public void setProperties(Set<JpaSubscriptionProperty> properties) {
		this.properties = properties;
	}

	/**
	 * Get the duration of the subscription.
	 *
	 * @return The subscription duration.
	 */
	public Integer getDuration() {
		return duration;
	}

	/**
	 * Set the duration of the subscription.
	 *
	 * @param duration The subscription duration to set.
	 */
	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	/**
	 * Get the date of the next scheduled event for the subscription.
	 *
	 * @return The next scheduled event date.
	 */
	public Date getNextSchedule() {
		return nextSchedule;
	}

	/**
	 * Set the date of the next scheduled event for the subscription.
	 *
	 * @param nextSchedule The next scheduled event date to set.
	 */
	public void setNextSchedule(Date nextSchedule) {
		this.nextSchedule = nextSchedule;
	}

	/**
	 * A callback method called before persisting and updating the subscription to
	 * validate connector metadata.
	 */
	@PrePersist
	@PreUpdate
	private void validateConnectorMetadata() {
		for (JpaSubscriptionProperty property : properties) {
			if (!connector.getMetadata().contains(property.getConnectorMetadata())) {
				throw new IllegalArgumentException("ConnectorMetadata does not belong to the subscribed connector");
			}
		}
	}
}
