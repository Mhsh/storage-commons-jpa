package com.storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.storage.jpa.JpaRssDigest;
import com.storage.jpa.JpaSubscription;

/**
 * The JpaRssDigestRepository interface provides data access methods for
 * interacting with JpaRssDigest entities in the database. It extends the
 * JpaRepository interface, providing CRUD (Create, Read, Update, Delete)
 * operations for JpaRssDigest entities.
 */
public interface JpaRssDigestRepository extends JpaRepository<JpaRssDigest, Long> {

	// Custom query to check if any of the content, title, or description already
	// exists
	boolean existsByTitleOrDescription(String title, String description);

	// You can also combine conditions in a single query
	@Query("SELECT COUNT(d) > 0 FROM JpaRssDigest d WHERE (d.title = :title OR d.description = :description) AND d.subscription = :subscription")
	boolean existsByTitleOrDescriptionAndSubscription(@Param("title") String title,
			@Param("description") String description, @Param("subscription") JpaSubscription subscription);

	// Custom query to check if link already exists
	boolean existsByLinkAndSubscription(String link, JpaSubscription subscription);

	// Custom query to check if guid already exists
	boolean existsByGuidAndSubscription(String guid, JpaSubscription subscription);

	JpaRssDigest findByGuid(String uri);

	JpaRssDigest findByGuidAndSubscription(String guid, JpaSubscription jpaSubscription);
}
