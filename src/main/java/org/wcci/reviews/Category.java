package org.wcci.reviews;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	
	@Id
	@GeneratedValue
	private long id;
	private String name;
	
    //@OneToMany(mappedBy = "categories")
	//private Collection<Review> reviews; 

	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Category () {
		
	}
	
	public Category(String name) {
		this.name = name;
	}

//	public Collection<Review> getReviews() {		
//		return reviews;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (id != other.id)
			return false;
		return true; 
	}

	
	
}