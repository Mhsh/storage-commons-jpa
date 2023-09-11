package com.storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storage.jpa.JpaClient;

/**
 * The JpaClientRepository interface provides data access methods for
 * interacting with JpaClient entities in the database. It extends the
 * JpaRepository interface, providing CRUD (Create, Read, Update, Delete)
 * operations for JpaClient entities.
 */
public interface JpaClientRepository extends JpaRepository<JpaClient, String> {
}
