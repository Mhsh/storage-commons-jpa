package com.storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storage.jpa.JpaConnector;
import com.storage.jpa.Enums.ConnectorType;

/**
 * The JpaConnectorRepository interface provides data access methods for
 * interacting with JpaConnector entities in the database. It extends
 * the JpaRepository interface, providing CRUD (Create, Read, Update, Delete)
 * operations for JpaClient entities.
 */
public interface JpaConnectorRepository extends JpaRepository<JpaConnector, ConnectorType> {

}
