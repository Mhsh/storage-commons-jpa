package com.storage.repository;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.storage.jpa.JpaEtlErrorDetail;

public interface JpaETLErrorDetailRepository extends JpaRepository<JpaEtlErrorDetail, UUID> {

	@Query(value = "SELECT error_detail AS errorDetail, COUNT(*) AS count FROM error_etl_detail GROUP BY error_detail", nativeQuery = true)
	List<Map<String, Long>> getCountGroupedByErrorDetail();

}
