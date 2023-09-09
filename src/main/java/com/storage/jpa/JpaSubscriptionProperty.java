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

@Entity
@Table(name = "subscription_property")
public class JpaSubscriptionProperty {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "connector_metadata")
	private JpaConnectorMetadata connectorMetadata;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "sub_conn_metadata_values", joinColumns = @JoinColumn(name = "subscription_property_id"))
	@Column(name = "property_value")
	private Set<String> values = new HashSet<>();

	@ManyToOne
	@JoinColumn(name = "subscription_id")
	private JpaSubscription subscription;

	public JpaSubscriptionProperty() {
		super();
	}

	public JpaSubscriptionProperty(JpaConnectorMetadata connectorMetadata, Set<String> values) {
		super();
		this.connectorMetadata = connectorMetadata;
		this.values = values;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public JpaConnectorMetadata getConnectorMetadata() {
		return connectorMetadata;
	}

	public void setConnectorMetadata(JpaConnectorMetadata connectorMetadata) {
		this.connectorMetadata = connectorMetadata;
	}

	public Set<String> getValues() {
		return values;
	}

	public void setValues(Set<String> values) {
		this.values = values;
	}

	public JpaSubscription getSubscription() {
		return subscription;
	}

	public void setSubscription(JpaSubscription subscription) {
		this.subscription = subscription;
	}

}
