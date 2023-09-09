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

@Entity
@Table(name = "subscription")
public class JpaSubscription extends BaseEntity {

	// Constructors
	public JpaSubscription() {
	}

	public JpaSubscription(JpaClient client, JpaConnector connector) {
		this.client = client;
		this.connector = connector;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "client_name", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_client_id"))
	private JpaClient client;

	@ManyToOne
	@JoinColumn(name = "connector_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_connector_id"))
	private JpaConnector connector;

	@OneToMany(mappedBy = "subscription", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
	private Set<JpaSubscriptionProperty> properties = new HashSet<>();

	@Column(name = "location")
	private String location;

	@Column(name = "duration")
	private Integer duration;

	@Column(name = "nextSchedule")
	private Date nextSchedule;

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public JpaClient getClient() {
		return client;
	}

	public void setClient(JpaClient client) {
		this.client = client;
	}

	public JpaConnector getConnector() {
		return connector;
	}

	public void setConnector(JpaConnector connector) {
		this.connector = connector;
	}

	public Set<JpaSubscriptionProperty> getProperties() {
		return properties;
	}

	public void setProperties(Set<JpaSubscriptionProperty> properties) {
		this.properties = properties;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Date getNextSchedule() {
		return nextSchedule;
	}

	public void setNextSchedule(Date nextSchedule) {
		this.nextSchedule = nextSchedule;
	}

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
