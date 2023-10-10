package com.storage.jpa;

import java.util.Objects;

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
 * The JpaConnectorMetadata class represents metadata associated with a
 * connector entity in a Java Persistence API (JPA) application. Metadata
 * provides additional information about a connector, including a key-value pair
 * and whether it is multi-valued.
 */
@Entity
@Table(name = "connector_metadata")
public class JpaConnectorMetadata extends BaseEntity {

	/**
	 * The unique identifier for the metadata.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * The associated JpaConnector entity to which this metadata belongs.
	 */
	@ManyToOne
	@JoinColumn(name = "connector_id")
	private JpaConnector connector;

	/**
	 * The key associated with the metadata.
	 */
	@Column(nullable = false)
	private String key;

	/**
	 * Default constructor for JpaConnectorMetadata.
	 */
	public JpaConnectorMetadata() {
		super();
	}

	/**
	 * Constructor for JpaConnectorMetadata with a specified key and multi-valued
	 * flag.
	 *
	 * @param key         The key associated with the metadata.
	 * @param multiValued Indicates whether the metadata is multi-valued (true) or
	 *                    not (false).
	 */
	public JpaConnectorMetadata(String key) {
		super();
		this.key = key;
	}

	/**
	 * Get the unique identifier for the metadata.
	 *
	 * @return The metadata's identifier.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Set the unique identifier for the metadata.
	 *
	 * @param id The metadata's identifier to set.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Get the key associated with the metadata.
	 *
	 * @return The metadata's key.
	 */
	public String getKey() {
		return key;
	}

	/**
	 * Set the key associated with the metadata.
	 *
	 * @param key The metadata's key to set.
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * Get the associated JpaConnector entity.
	 *
	 * @return The associated JpaConnector entity.
	 */
	public JpaConnector getConnector() {
		return connector;
	}

	/**
	 * Set the associated JpaConnector entity.
	 *
	 * @param connector The JpaConnector entity to set.
	 */
	public void setConnector(JpaConnector connector) {
		this.connector = connector;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	/**
	 * {@inheritDoc}
	 */
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
