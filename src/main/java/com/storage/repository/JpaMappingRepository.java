package com.storage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storage.jpa.JpaMapping;
import com.storage.jpa.JpaSubscription;

public interface JpaMappingRepository extends JpaRepository<JpaMapping, Long> {

	List<JpaMapping> findBySubscription(JpaSubscription subscription);
}
