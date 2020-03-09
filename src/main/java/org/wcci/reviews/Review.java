package org.wcci.reviews;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Review {

	private Collection<Category> category;
	private String description;
	private String name;
	@Id
	@GeneratedValue
	private Long id;

	public Review(String name, String description, Category categoryName) {
		this.name = name;
		this.description = description;
		this.category = new HashSet<>();
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	public Long getId() {
		return id;
	}

}
