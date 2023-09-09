package com.storage.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "subscription_mapping")
public class JpaMapping {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "subscription_id")
	private JpaSubscription subscription;

	@Column(name = "sourcekey")
	private String sourcekey;

	@Column(name = "internalkey")
	private String internalkey;

	@Column(name = "type")
	private String type;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public JpaSubscription getSubscription() {
		return subscription;
	}

	public void setSubscription(JpaSubscription subscription) {
		this.subscription = subscription;
	}

	public String getSourcekey() {
		return sourcekey;
	}

	public void setSourcekey(String sourcekey) {
		this.sourcekey = sourcekey;
	}

	public String getInternalkey() {
		return internalkey;
	}

	public void setInternalkey(String internalkey) {
		this.internalkey = internalkey;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
}
