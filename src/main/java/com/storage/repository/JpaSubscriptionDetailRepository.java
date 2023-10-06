package com.storage.repository;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.storage.jpa.JpaSubscription;
import com.storage.jpa.JpaSubscriptionDetail;

/**
 * The JpaSubscriptionDetailRepository interface provides data access methods
 * for interacting with JpaSubscriptionDetailMetadata entities in the database.
 * It extends the JpaSubscriptionDetailMetadata interface, providing CRUD
 * (Create, Read, Update, Delete) operations for JpaClient entities.
 */
public interface JpaSubscriptionDetailRepository extends JpaRepository<JpaSubscriptionDetail, Long> {

	List<JpaSubscriptionDetail> findBySubscription(JpaSubscription subscription);

	List<JpaSubscriptionDetail> findByNextScheduleBefore(OffsetDateTime currentDate);

	@Transactional
	@Modifying
	@Query("UPDATE JpaSubscriptionDetail s SET s.content = :content, s.updatedDate = CURRENT_TIMESTAMP WHERE s.id = :id")
	void updateContentById(@Param("id") Long id, @Param("content") String content);

	@Transactional
	@Modifying
	@Query("UPDATE JpaSubscriptionDetail s SET s.nextSchedule = :nextSchedule, s.lastExecution = :lastExecution, s.duration = :duration WHERE s.id = :id")
	void updateNextExecution(@Param("id") Long id, @Param("nextSchedule") OffsetDateTime nextSchedule,
			@Param("lastExecution") OffsetDateTime lastExecution, Integer duration);
}