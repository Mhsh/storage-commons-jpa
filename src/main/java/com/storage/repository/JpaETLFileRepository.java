package com.storage.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.storage.jpa.JpaETLFile;
import com.storage.jpa.JpaIngestionErrorDetail;
import com.storage.jpa.JpaSubscriptionDetail;

public interface JpaETLFileRepository extends JpaRepository<JpaETLFile, UUID> {

	List<JpaIngestionErrorDetail> findBySubscriptionDetail(JpaSubscriptionDetail jpaSubscriptionDetail);

	@Transactional
	void deleteById(UUID id);

	@Transactional
	void deleteBySubscriptionDetailId(UUID subscriptionDetailId);

	boolean existsBySubscriptionDetailId(UUID subscriptionDetailId);

	Optional<JpaIngestionErrorDetail> findBySubscriptionDetailId(UUID subscriptionDetailId);

	@Query(value = "SELECT error_detail AS errorDetail, COUNT(*) AS count FROM error_detail GROUP BY error_detail", nativeQuery = true)
	List<Map<String, Long>> getCountGroupedByErrorDetail();
}
