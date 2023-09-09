package com.storage.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.storage.jpa.JpaSubscription;

public interface JpaSubscriptionRepository extends JpaRepository<JpaSubscription, Long> {

	List<JpaSubscription> findByNextScheduleBefore(Date currentDate);

	@Transactional
	@Modifying
	@Query("UPDATE JpaSubscription s SET s.nextSchedule = :newNextSchedule WHERE s.id = :subscriptionId")
	void updateNextScheduleById(Long subscriptionId, Date newNextSchedule);

}
