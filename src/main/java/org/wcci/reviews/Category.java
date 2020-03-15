package org.wcci.reviews;

<<<<<<< HEAD
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
=======
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Category {
	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private Review review;
	private String name;

	public Category() {

	}

	public Category(String name, Review review) {
		this.name = name;
		this.review = review;
	}

	public Long getId() {
		return id;
	}

	public Review getReview() {
		return review;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", review=" + review + ", name=" + name + "]";
	}
>>>>>>> origin/module-9-dillon

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
<<<<<<< HEAD
		result = prime * result + (int) (id ^ (id >>> 32));
=======
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((review == null) ? 0 : review.hashCode());
>>>>>>> origin/module-9-dillon
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
<<<<<<< HEAD
		if (id != other.id)
			return false;
		return true; 
	}

	
	
}
=======
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (review == null) {
			if (other.review != null)
				return false;
		} else if (!review.equals(other.review))
			return false;
		return true;
	}

}
>>>>>>> origin/module-9-dillon
