package org.wcci.reviews;

import java.util.Collection;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryRestController {

	@Resource
	private ReviewRepository reviewRepo;

	@Resource
	private CategoryRepository categoryRepo;

	@RequestMapping("")
	public Iterable<Category> findAllCategories() {
		return categoryRepo.findAll();
	}

	@RequestMapping("/{id}")
	public Optional<Category> findOneCategory(@PathVariable long id) {
		return categoryRepo.findById(id);
	}
	
	@RequestMapping("/(categoryName)/reviews")
	public Collection<Review> findAllReviewsByCategory(@PathVariable(value = "categoryName") String categoryName) {
		Category category = categoryRepo.findByNameIgnoreCase(categoryName);
		return reviewRepo.findByCategoryContains(category);
	}

}
