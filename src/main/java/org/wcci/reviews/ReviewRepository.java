package org.wcci.reviews;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long> {

	Collection<Review> findByCategoryContains(Category category);

	Review findByName(String reviewName);

	Review deleteById(Review reviewId);

}
