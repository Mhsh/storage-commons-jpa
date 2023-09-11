package com.storage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storage.jpa.JpaMapping;
import com.storage.jpa.JpaSubscription;

/**
 * The JpaMappingRepository interface provides data access methods for
 * interacting with JpaMapping entities in the database. It extends
 * the JpaRepository interface, providing CRUD (Create, Read, Update, Delete)
 * operations for JpaClient entities.
 */
public interface JpaMappingRepository extends JpaRepository<JpaMapping, Long> {

	List<JpaMapping> findBySubscription(JpaSubscription subscription);
}
