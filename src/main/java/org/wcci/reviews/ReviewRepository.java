package org.wcci.reviews;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long> {
	
	Collection<Review> findByCategoriesContains(Category, name);
	//Collection<Review> findByTagContains(Tag, name);

}
