package com.storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storage.jpa.JpaConnectorMetadata;

/**
 * The JpaConnectorMetadataRepository interface provides data access methods for
 * interacting with JpaConnectorMetadata entities in the database. It extends
 * the JpaRepository interface, providing CRUD (Create, Read, Update, Delete)
 * operations for JpaClient entities.
 */
public interface JpaConnectorMetadataRepository extends JpaRepository<JpaConnectorMetadata, Long> {

}
