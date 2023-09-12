package com.storage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storage.jpa.JpaClientTemplate;

/**
 * The JpaClientTemplateRepository interface provides data access methods for
 * interacting with JpaClientTemplate entities in the database. It extends the
 * JpaRepository interface, providing CRUD (Create, Read, Update, Delete)
 * operations for JpaClient entities.
 */
public interface JpaClientTemplateRepository extends JpaRepository<JpaClientTemplate, Long> {

	/**
	 * Retrieve a client template by the client's unique identifier (ID).
	 *
	 * @param clientId The unique identifier of the client.
	 * @return The client template associated with the specified client ID, or null
	 *         if not found.
	 */
	JpaClientTemplate findByClient_Id(String clientId);

	/**
	 * Retrieve a list of client templates associated with a specific client's
	 * unique identifier (ID).
	 *
	 * @param clientId The unique identifier of the client.
	 * @return A list of client templates associated with the specified client ID.
	 */
	List<JpaClientTemplate> findAllByClient_Id(Long clientId);
}
