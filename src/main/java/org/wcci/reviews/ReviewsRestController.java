package org.wcci.reviews;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
public class ReviewsRestController {
	
	@Resource 
	private ReviewRepository reviewRepo;
	
	@Resource
	private CategoryRepository categoryRepo;
	
	@RequestMapping("")
	public Iterable<Review> findAllReviews() {
		return reviewRepo.findAll();
	}
	
	@RequestMapping("/{id}")
	public Optional<Review> findOneReview(@PathVariable long id) {
		return reviewRepo.findById(id);
	}
	
	@RequestMapping("/categories/(categoryName")
	public Collection<Review> findAllReviewsByCategory(@PathVariable(value = "categoryName") String categoryName) {
		Category category = categoryRepo.findByNameIgnoreCase(categoryName);
		return reviewRepo.findByCategoriesContains(category);
	}

}
