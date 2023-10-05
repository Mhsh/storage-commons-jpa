package com.storage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.storage.jpa.JpaSubscriptionDetail;
import com.storage.jpa.JpaSubscriptionDetailMetadata;

/**
 * The JpaSubscriptionPropertyRepository interface provides data access methods
 * for interacting with JpaSubscriptionProperty entities in the database. It
 * extends the JpaRepository interface, providing CRUD (Create, Read, Update,
 * Delete) operations for JpaClient entities.
 */
public interface JpaSubscriptionDetailMetadataRepository extends JpaRepository<JpaSubscriptionDetailMetadata, Long> {

	List<JpaSubscriptionDetailMetadata> findBySubscriptionDetail(JpaSubscriptionDetail subscritionDetail);

	// Delete the existing entry based on the metadataKey and subscriptionDetail
	@Modifying
	@Transactional
	@Query("DELETE FROM JpaSubscriptionDetailMetadata s WHERE s.metadataKey = :metadataKey AND s.subscriptionDetail = :subscriptionDetail")
	void deleteByKeyAndSubscriptionDetail(String metadataKey, JpaSubscriptionDetail subscriptionDetail);

	default void createNewMetadata(String metadataKey, String metadataValue, JpaSubscriptionDetail subscriptionDetail) {
		deleteByKeyAndSubscriptionDetail(metadataKey, subscriptionDetail);
		JpaSubscriptionDetailMetadata newMetadata = new JpaSubscriptionDetailMetadata();
		newMetadata.setMetadataKey(metadataKey);
		newMetadata.setMetadataValue(metadataValue);
		newMetadata.setSubscriptionDetail(subscriptionDetail);
		save(newMetadata); // Assuming your repository extends JpaRepository
	}
}
