package com.storage.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "subscription_detail")
public class JpaSubscriptionDetail extends BaseEntity {

	/**
	 * The unique identifier for the subscription property.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

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
	@Column(name = "nextSchedule", nullable = false)
	private Date nextSchedule;

	@Column(name = "rawFileLocation", nullable = false)
	private String rawFileLocation;

	@Column(name = "content")
	private String content;

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
	public Long getId() {
		return id;
	}

	/**
	 * Set the unique identifier for the subscription property.
	 *
	 * @param id The property's identifier to set.
	 */
	public void setId(Long id) {
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
	public Date getNextSchedule() {
		return nextSchedule;
	}

	/**
	 * @param nextSchedule the nextSchedule to set
	 */
	public void setNextSchedule(Date nextSchedule) {
		this.nextSchedule = nextSchedule;
	}

	/**
	 * @return the rawFileLocation
	 */
	public String getRawFileLocation() {
		return rawFileLocation;
	}

	/**
	 * @param rawFileLocation the rawFileLocation to set
	 */
	public void setRawFileLocation(String rawFileLocation) {
		this.rawFileLocation = rawFileLocation;
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

}
