package com.storage.repository;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storage.jpa.JpaMapping;
import com.storage.jpa.JpaSubscription;

/**
 * The JpaMappingRepository interface provides data access methods for
 * interacting with JpaMapping entities in the database. It extends the
 * JpaRepository interface, providing CRUD (Create, Read, Update, Delete)
 * operations for JpaClient entities.
 */
public interface JpaMappingRepository extends JpaRepository<JpaMapping, UUID> {

	/**
	 * Retrieves a list of JPA mappings associated with a specific subscription.
	 *
	 * @param subscription The subscription for which to retrieve mappings.
	 * @return A list of JPA mappings associated with the specified subscription, or
	 *         an empty list if none are found.
	 */
	List<JpaMapping> findBySubscription(JpaSubscription subscription);

	@Transactional
	public void deleteBySubscription(JpaSubscription subscription);
}
