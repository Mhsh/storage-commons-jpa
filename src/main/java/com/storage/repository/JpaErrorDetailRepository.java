package com.storage.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.storage.jpa.JpaErrorDetail;
import com.storage.jpa.JpaSubscriptionDetail;

public interface JpaErrorDetailRepository extends JpaRepository<JpaErrorDetail, UUID> {

	List<JpaErrorDetail> findBySubscriptionDetail(JpaSubscriptionDetail jpaSubscriptionDetail);

	@Transactional
	void deleteById(UUID id);

	@Transactional
	void deleteBySubscriptionDetailId(UUID subscriptionDetailId);

	boolean existsBySubscriptionDetailId(UUID subscriptionDetailId);

	Optional<JpaErrorDetail> findBySubscriptionDetailId(UUID subscriptionDetailId);

    @Query(value = "SELECT error_detail AS errorDetail, COUNT(*) AS count FROM error_detail GROUP BY error_detail", nativeQuery = true)
	List<Map<String, Long>> getCountGroupedByErrorDetail();
}
