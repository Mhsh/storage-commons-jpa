package com.storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storage.jpa.JpaSubscription;

/**
 * The JpaSubscriptionRepository interface provides data access methods for
 * interacting with JpaSubscription entities in the database. It extends the
 * JpaRepository interface, providing CRUD (Create, Read, Update, Delete)
 * operations for JpaClient entities.
 */
public interface JpaSubscriptionRepository extends JpaRepository<JpaSubscription, Long> {

}
