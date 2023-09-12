package com.storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storage.jpa.JpaTemplate;

public interface JpaTemplateRepository extends JpaRepository<JpaTemplate, String> {
	// You can define custom query methods here if needed
}
