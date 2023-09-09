package com.storage.jpa;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "connector_metadata")
public class JpaConnectorMetadata {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "connector_id")
	private JpaConnector connector;

	private String key;

	public JpaConnectorMetadata() {
		super();
	}

	public JpaConnectorMetadata(String key, boolean multiValued) {
		super();
		this.key = key;
		this.multiValued = multiValued;
	}

	private boolean multiValued;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public boolean isMultiValued() {
		return multiValued;
	}

	public void setMultiValued(boolean multiValued) {
		this.multiValued = multiValued;
	}

	public JpaConnector getConnector() {
		return connector;
	}

	public void setConnector(JpaConnector connector) {
		this.connector = connector;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JpaConnectorMetadata other = (JpaConnectorMetadata) obj;
		return Objects.equals(id, other.id);
	}

}
