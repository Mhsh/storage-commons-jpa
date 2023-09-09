package com.storage.jpa;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.storage.BaseEntity;

@Entity
@Table(name = "client")
public class JpaClient extends BaseEntity {

	@Id
	@Column(name = "id", nullable = false, unique = true)
	private String id;

	@Column(name = "description")
	private String description;

	@OneToMany(mappedBy = "client")
	private Set<JpaSubscription> subscriptions = new HashSet<>();

	// Constructors, getters, setters, and other methods

	// Constructors
	public JpaClient() {
	}

	public JpaClient(String id) {
		this.id = id;
	}

	// Getters and Setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<JpaSubscription> getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(Set<JpaSubscription> subscriptions) {
		this.subscriptions = subscriptions;
	}
}
