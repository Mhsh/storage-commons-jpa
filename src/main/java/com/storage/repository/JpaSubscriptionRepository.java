package com.storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.storage.jpa.JpaSubscription;

/**
 * The JpaSubscriptionRepository interface provides data access methods for
 * interacting with JpaSubscription entities in the database. It extends the
 * JpaRepository interface, providing CRUD (Create, Read, Update, Delete)
 * operations for JpaClient entities.
 */
public interface JpaSubscriptionRepository extends JpaRepository<JpaSubscription, Long> {

}
