package com.storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storage.jpa.JpaSubscriptionProperty;

/**
 * The JpaSubscriptionPropertyRepository interface provides data access methods for
 * interacting with JpaSubscriptionProperty entities in the database. It extends
 * the JpaRepository interface, providing CRUD (Create, Read, Update, Delete)
 * operations for JpaClient entities.
 */
public interface JpaSubscriptionPropertyRepository extends JpaRepository<JpaSubscriptionProperty, Long> {

}
