package com.storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storage.jpa.JpaConnector;
import com.storage.jpa.Enums.ConnectorType;

public interface JpaConnectorRepository extends JpaRepository<JpaConnector, ConnectorType> {

}
