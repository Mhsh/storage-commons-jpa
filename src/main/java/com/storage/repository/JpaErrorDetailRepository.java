package com.storage.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.storage.jpa.JpaErrorDetail;
import com.storage.jpa.JpaSubscriptionDetail;

public interface JpaErrorDetailRepository extends JpaRepository<JpaErrorDetail, Long> {

	List<JpaErrorDetail> findBySubscriptionDetail(JpaSubscriptionDetail jpaSubscriptionDetail);

	@Transactional
	void deleteById(Long id);

	@Transactional
	void deleteBySubscriptionDetail(JpaSubscriptionDetail jpaSubscriptionDetail);

	Optional<JpaErrorDetail> findBySubscriptionDetailId(Long subscriptionDetailId);
}
