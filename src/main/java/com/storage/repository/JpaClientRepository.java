package com.storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storage.jpa.JpaClient;

public interface JpaClientRepository extends JpaRepository<JpaClient, String> {

}
