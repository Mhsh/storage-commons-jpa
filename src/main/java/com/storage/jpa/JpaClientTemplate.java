package com.storage.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.storage.BaseEntity;

/**
 * The JpaClientTemplate class represents an entity in a Java Persistence API
 * (JPA) application. This entity is associated with a JpaClient through a
 * one-to-one relationship and includes a JSON template stored as a JSON data
 * type. The unique identifier for this entity is 'id'.
 */
@Entity
@Table(name = "etl_client_template")
public class JpaClientTemplate extends BaseEntity {

	/**
	 * The unique identifier for the entity.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	/**
	 * The one-to-one relationship with JpaClient.
	 */
	@OneToOne
	@JoinColumn(name = "client_id", referencedColumnName = "id")
	private JpaClient client;

	/**
	 * The JSON template stored as a JSON data type.
	 */
	@Column(name = "template", columnDefinition = "TEXT", nullable = false)
	private String template;

	/**
	 * Get the unique identifier for the entity.
	 *
	 * @return The identifier of the entity.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Set the unique identifier for the entity.
	 *
	 * @param id The identifier to set.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Get the associated JpaClient.
	 *
	 * @return The associated JpaClient.
	 */
	public JpaClient getClient() {
		return client;
	}

	/**
	 * Set the associated JpaClient.
	 *
	 * @param client The JpaClient to set.
	 */
	public void setClient(JpaClient client) {
		this.client = client;
	}

	/**
	 * Get the JSON template stored as a JSON data type.
	 *
	 * @return The JSON template.
	 */
	public String getTemplate() {
		return template;
	}

	/**
	 * Set the JSON template stored as a JSON data type.
	 *
	 * @param template The JSON template to set.
	 */
	public void setTemplate(String template) {
		this.template = template;
	}
}
