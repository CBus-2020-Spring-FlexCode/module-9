package org.wcci.reviews;

<<<<<<< HEAD
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
=======
import java.util.Collection;
>>>>>>> origin/module-9-dillon

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
<<<<<<< HEAD
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
=======
import javax.persistence.OneToMany;
>>>>>>> origin/module-9-dillon

@Entity
public class Review {
	
<<<<<<< HEAD
=======
	private String name;
>>>>>>> origin/module-9-dillon
	@Id
	@GeneratedValue
	private Long id;
	
<<<<<<< HEAD
	private String title;
	private String image;
	@Lob
	private String content;
	
	@ManyToMany
	private Collection<Category> categories;
	
	public long getId() {
		return id;
	}
	
	//Possibly name, depends on how others name it
	public String getTitle() {
		return title;
	}
	
	public String getImage() {
		return image;	
	}
	
	public String getContent() {
		return content;
	}
	
	public Collection<Category> getCategories() {
		return categories;
	}
	
	public Review() {
		
	}
	
	//Add category once class is created "Category...category"
	public Review(String title, String image, String content, Category...categories) {
		this.title = title;
		this.image = image;
		this.content = content;
		this.categories = new HashSet<>(Arrays.asList(categories));
=======
	@OneToMany(mappedBy="review")
	private Collection<Category> categories;
	
	public Review() {
		
	}

	public Review(String name, String description, String image, Category category) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Review [name=" + name + ", id=" + id + "]";
>>>>>>> origin/module-9-dillon
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
<<<<<<< HEAD
=======
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Review other = (Review) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
<<<<<<< HEAD
		return true;
	}
	
=======
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public Iterable<Category> getCategories() {
		
		return categories;
	}
>>>>>>> origin/module-9-dillon

}
