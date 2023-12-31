package com.storage.jpa;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.storage.BaseEntity;
import com.storage.jpa.Enums.ConnectorType;
import com.storage.jpa.Enums.FileType;

/**
 * The JpaConnector class represents a connector entity in a Java Persistence
 * API (JPA) application. Connectors are used to connect to external systems and
 * may have associated metadata.
 */
@Entity
@Table(name = "connector")
public class JpaConnector extends BaseEntity {

	/**
	 * The unique identifier for the connector, represented as a ConnectorType
	 * enumeration.
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "id", nullable = false, unique = true)
	@Id
	private ConnectorType id; // Manually set the ID as it is not autogenerated

	/**
	 * A set of metadata associated with the connector.
	 */
	@OneToMany(mappedBy = "connector", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private Set<JpaConnectorMetadata> metadata = new HashSet<>();

	/**
	 * A description of the connector.
	 */
	@Column(name = "description")
	private String description;

	/**
	 * The type of files handled by the connector, represented as a FileType
	 * enumeration.
	 */
	@Column(name = "file_type", nullable = false)
	private FileType fileType;

	@Column(name = "smart_schedule_enabled", nullable = false)
	private Boolean smartScheudle = false;

	/**
	 * Default constructor for JpaConnector.
	 */
	public JpaConnector() {
		super();
	}

	/**
	 * Constructor for JpaConnector with a specified identifier.
	 *
	 * @param id The unique identifier for the connector.
	 */
	public JpaConnector(ConnectorType id) {
		super();
		this.id = id;
	}

	/**
	 * Get the unique identifier for the connector.
	 *
	 * @return The connector's identifier.
	 */
	public ConnectorType getId() {
		return id;
	}

	/**
	 * Set the unique identifier for the connector.
	 *
	 * @param id The connector's identifier to set.
	 */
	public void setId(ConnectorType id) {
		this.id = id;
	}

	/**
	 * Get the set of metadata associated with the connector.
	 *
	 * @return The set of metadata.
	 */
	public Set<JpaConnectorMetadata> getMetadata() {
		return metadata;
	}

	/**
	 * Set the set of metadata associated with the connector.
	 *
	 * @param metadata The set of metadata to set.
	 */
	public void setMetadata(Set<JpaConnectorMetadata> metadata) {
		this.metadata = metadata;
	}

	/**
	 * Get the description of the connector.
	 *
	 * @return The connector's description.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set the description of the connector.
	 *
	 * @param description The connector's description to set.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get the type of files handled by the connector.
	 *
	 * @return The file type handled by the connector.
	 */
	public FileType getFileType() {
		return fileType;
	}

	/**
	 * Set the type of files handled by the connector.
	 *
	 * @param fileType The file type to set.
	 */
	public void setFileType(FileType fileType) {
		this.fileType = fileType;
	}

	/**
	 * @return the smartScheudle
	 */
	public Boolean getSmartScheudle() {
		return smartScheudle;
	}

	/**
	 * @param smartScheudle the smartScheudle to set
	 */
	public void setSmartScheudle(Boolean smartScheudle) {
		this.smartScheudle = smartScheudle;
	}

}
