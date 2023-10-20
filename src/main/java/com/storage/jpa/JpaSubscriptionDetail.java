package com.storage.jpa;

import java.time.OffsetDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.storage.BaseEntity;

/**
 * The JpaSubscriptionDetail class represents a property associated with a
 * subscription in a Java Persistence API (JPA) application. Subscription
 * properties are key-value pairs related to connector metadata values.
 */
@Entity
@Table(name = "subscription_detail", indexes = {
		@Index(name = "subscription_detail_exec_index", columnList = "nextExecution"),
		@Index(name = "subscription_detail_content_index", columnList = "content"),
		@Index(name = "subscription_detail_blacklist_index", columnList = "blacklist"),
		@Index(name = "subscription_detail_subscription_index", columnList = "subscription_id") })
public class JpaSubscriptionDetail extends BaseEntity {

	/**
	 * The unique identifier for the entity.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private UUID id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "properties", nullable = false)
	private String properties;

	/**
	 * The duration of the subscription.
	 */
	@Column(name = "duration", nullable = false)
	private Integer duration;

	/**
	 * The date of the next scheduled event for the subscription.
	 */
	@Column(name = "nextExecution", columnDefinition = "timestamp with time zone")
	private OffsetDateTime nextExecution;

	/**
	 * The date of the next scheduled event for the subscription.
	 */
	@Column(name = "lastExecution", columnDefinition = "timestamp with time zone")
	private OffsetDateTime lastExecution;

	@Column(name = "content")
	private String content;

	@Column(name = "blacklist")
	private Boolean blacklist = false;

	@Column(name = "bodyEnabled")
	private Boolean isBodyEnabled = false;

	@ManyToOne
	@JoinColumn(name = "subscription_id")
	private JpaSubscription subscription; // Many-to-one relationship to Subscription

	/**
	 * Default constructor for JpaSubscriptionProperty.
	 */
	public JpaSubscriptionDetail() {
		super();
	}

	/**
	 * Get the unique identifier for the subscription property.
	 *
	 * @return The property's identifier.
	 */
	public UUID getId() {
		return id;
	}

	/**
	 * Set the unique identifier for the subscription property.
	 *
	 * @param id The property's identifier to set.
	 */
	public void setId(UUID id) {
		this.id = id;
	}

	/**
	 * @return the properties
	 */
	public String getProperties() {
		return properties;
	}

	/**
	 * @param properties the properties to set
	 */
	public void setProperties(String properties) {
		this.properties = properties;
	}

	/**
	 * @return the duration
	 */
	public Integer getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	/**
	 * @return the nextSchedule
	 */
	public OffsetDateTime getNextExecution() {
		return nextExecution;
	}

	/**
	 * @param nextSchedule the nextSchedule to set
	 */
	public void setNextExecution(OffsetDateTime nextExecution) {
		this.nextExecution = nextExecution;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the subscription
	 */
	public JpaSubscription getSubscription() {
		return subscription;
	}

	/**
	 * @param subscription the subscription to set
	 */
	public void setSubscription(JpaSubscription subscription) {
		this.subscription = subscription;
	}

	/**
	 * @return the lastExecution
	 */
	public OffsetDateTime getLastExecution() {
		return lastExecution;
	}

	/**
	 * @param lastExecution the lastExecution to set
	 */
	public void setLastExecution(OffsetDateTime lastExecution) {
		this.lastExecution = lastExecution;
	}

	/**
	 * @return the blacklist
	 */
	public Boolean isBlacklisted() {
		return blacklist;
	}

	/**
	 * @param blacklist the blacklist to set
	 */
	public void setBlacklisted(Boolean blacklist) {
		this.blacklist = blacklist;
	}

	/**
	 * @return the isBodyEnabled
	 */
	public Boolean isBodyEnabled() {
		return isBodyEnabled;
	}

	/**
	 * @param isBodyEnabled the isBodyEnabled to set
	 */
	public void setBodyEnabled(Boolean isBodyEnabled) {
		this.isBodyEnabled = isBodyEnabled;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
