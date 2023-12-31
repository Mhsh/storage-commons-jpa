package com.storage.jpa;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.storage.BaseEntity;

@Entity
@Table(name = "rss_digest", indexes = { @Index(name = "rss_digest_link_index", columnList = "link"),
		@Index(name = "rss_digest_link_guid_index", columnList = "guid, subscription_id"),
		@Index(name = "rss_digest_title_desc_index", columnList = "title, description, subscription_id"),
		@Index(name = "rss_digest_link_pubData_index", columnList = "pubDate, subscription_id") }, uniqueConstraints = {
				@UniqueConstraint(columnNames = { "title", "description", "subscription_id" }),
				@UniqueConstraint(columnNames = { "guid", "subscription_id" }),
				@UniqueConstraint(columnNames = { "link", "subscription_id" }),
				@UniqueConstraint(columnNames = { "title", "description", "link", "guid", "subscription_id" }) })
public class JpaRssDigest extends BaseEntity {

	/**
	 * The unique identifier for the entity.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private UUID id;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "link")
	private String link;

	@Column(name = "guid")
	private String guid;

	@Column(name = "pubDate")
	private Date pubDate;

	@ManyToOne
	@JoinColumn(name = "subscription_id")
	private JpaSubscription subscription; // Many-to-one relationship to Subscription

	@OneToOne
	@JoinColumn(name = "subscription_detail_id")
	private JpaSubscriptionDetail subscriptionDetailId;

	/**
	 * @return the id
	 */
	public UUID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(UUID id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the link
	 */
	public String getLink() {
		return link;
	}

	/**
	 * @param link the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}

	/**
	 * @return the guid
	 */
	public String getGuid() {
		return guid;
	}

	/**
	 * @param guid the guid to set
	 */
	public void setGuid(String guid) {
		this.guid = guid;
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
	 * @return the pubDate
	 */
	public Date getPubDate() {
		return pubDate;
	}

	/**
	 * @param pubDate the pubDate to set
	 */
	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	/**
	 * @return the subscriptionDetailId
	 */
	public JpaSubscriptionDetail getSubscriptionDetailId() {
		return subscriptionDetailId;
	}

	/**
	 * @param subscriptionDetailId the subscriptionDetailId to set
	 */
	public void setSubscriptionDetailId(JpaSubscriptionDetail subscriptionDetailId) {
		this.subscriptionDetailId = subscriptionDetailId;
	}

}
