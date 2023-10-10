package com.storage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.storage.jpa.JpaErrorDetail;
import com.storage.jpa.JpaSubscriptionDetail;

public interface JpaErrorDetailRepository extends JpaRepository<JpaErrorDetail, Long> {

	List<JpaErrorDetail> findByJpaSubscriptionDetail(JpaSubscriptionDetail jpaSubscriptionDetail);

	@Transactional
	void deleteById(Long id);

	@Transactional
	void deleteByJpaSubscriptionDetail(JpaSubscriptionDetail jpaSubscriptionDetail);
}