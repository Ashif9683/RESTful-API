package com.in28minutes.rest.webservices.restful_web_services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.in28minutes.rest.webservices.restful_web_services.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;

@Entity
public class Post {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=15)
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private User user;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	

	@Override
	public String toString() {
		return "Post [id=" + id + ", description=" + description + "]";
	}

	public void setUser(User user) {
		this.user=user;	
	}
	
	

}
