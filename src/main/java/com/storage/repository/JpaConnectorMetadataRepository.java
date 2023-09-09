package com.storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storage.jpa.JpaConnectorMetadata;

public interface JpaConnectorMetadataRepository extends JpaRepository<JpaConnectorMetadata, Long> {

}
