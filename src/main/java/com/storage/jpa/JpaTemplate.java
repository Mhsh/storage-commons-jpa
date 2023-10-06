package com.storage.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.storage.BaseEntity;

/**
 * Represents a JPA entity for storing templates with JSON data in a PostgreSQL
 * database. Each template has a unique identifier (ID) and a JSON template.
 */
@Entity
@Table(name = "etl_template")
public class JpaTemplate extends BaseEntity{

	/**
	 * Unique identifier for the template.
	 */
	@Id
	@Column(name = "id")
	private String id;

	/**
	 * JSON template stored as a string with the "jsonb" column definition.
	 */
	@Column(name = "template", columnDefinition = "TEXT", nullable = false)
	private String template;

	/**
	 * Default constructor for JpaTemplate.
	 */
	public JpaTemplate() {
	}

	/**
	 * Creates a new JpaTemplate with the specified ID and JSON template.
	 *
	 * @param id       The unique identifier for the template.
	 * @param template The JSON template stored as a string.
	 */
	public JpaTemplate(String id, String template) {
		this.id = id;
		this.template = template;
	}

	/**
	 * Gets the unique identifier for the template.
	 *
	 * @return The ID of the template.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the unique identifier for the template.
	 *
	 * @param id The ID of the template.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the JSON template stored as a string.
	 *
	 * @return The JSON template.
	 */
	public String getTemplate() {
		return template;
	}

	/**
	 * Sets the JSON template stored as a string.
	 *
	 * @param template The JSON template.
	 */
	public void setTemplate(String template) {
		this.template = template;
	}
}
