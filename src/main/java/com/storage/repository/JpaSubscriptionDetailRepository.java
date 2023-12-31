package com.storage.repository;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.storage.jpa.Enums.ConnectorType;
import com.storage.jpa.JpaSubscription;
import com.storage.jpa.JpaSubscriptionDetail;

/**
 * The JpaSubscriptionDetailRepository interface provides data access methods
 * for interacting with JpaSubscriptionDetailMetadata entities in the database.
 * It extends the JpaSubscriptionDetailMetadata interface, providing CRUD
 * (Create, Read, Update, Delete) operations for JpaClient entities.
 */
public interface JpaSubscriptionDetailRepository extends JpaRepository<JpaSubscriptionDetail, UUID> {

	List<JpaSubscriptionDetail> findBySubscription(JpaSubscription subscription);

	List<JpaSubscriptionDetail> findByNextExecutionBeforeAndBlacklistIsFalse(OffsetDateTime currentDate);

	@Transactional
	@Modifying
	@Query("UPDATE JpaSubscriptionDetail s SET s.content = :content, s.updatedDate = CURRENT_TIMESTAMP WHERE s.id = :id")
	void updateContentById(@Param("id") UUID id, @Param("content") String content);

	@Transactional
	@Modifying
	@Query("UPDATE JpaSubscriptionDetail s SET s.blacklist = :blacklist, s.updatedDate = CURRENT_TIMESTAMP WHERE s.id = :id")
	void updateBlackListById(@Param("id") UUID id, @Param("blacklist") Boolean blacklist);

	@Transactional
	@Modifying
	@Query("UPDATE JpaSubscriptionDetail s SET s.nextExecution = :nextExecution, s.updatedDate = CURRENT_TIMESTAMP, s.lastExecution = :lastExecution, s.duration = :duration WHERE s.id = :id")
	void updateNextExecution(@Param("id") UUID id, @Param("nextExecution") OffsetDateTime nextExecution,
			@Param("lastExecution") OffsetDateTime lastExecution, @Param("duration") Integer duration);

	@Query("SELECT COUNT(sd) FROM JpaSubscriptionDetail sd " + "JOIN sd.subscription s " + "JOIN s.connector c "
			+ "WHERE c.id = :connectorType")
	Long countByConnectorType(@Param("connectorType") ConnectorType connectorType);

}
