package org.wcci.reviews;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewController {

	@Resource
	private ReviewRepository reviewRepo;

	@Resource
	private CategoryRepository categoryRepo;

	private Long reviewId;

	@RequestMapping("/show-review")
	public String findReview(@RequestParam(value = "id") long Id, Model model) {
		Optional<Review> review = reviewRepo.findById(Id);
		model.addAttribute("reviews", review.get());
		return "review-template";

	}

	@RequestMapping("/show-reviews")
	public String findAllReviews(Model model) {
		model.addAttribute("reviews", reviewRepo.findAll());
		return "reviews-template";

	}

	@RequestMapping("category")
	public String findCategory(@RequestParam(value = "id") long Id, Model model) {
		Optional<Category> category = categoryRepo.findById(Id);
		model.addAttribute("Categories", category.get());
		model.addAttribute("Reviews", reviewRepo.findByCategoryContains(category.get()));
		return "category";

	}

	@RequestMapping("/show-categories")
	public String findAllCategories(Model model) {
		model.addAttribute("categories", categoryRepo.findAll());
		return "categories";

	}

	@RequestMapping("/add-review")
	public String addReview(String reviewName, String reviewDescription, String categoryName) {
		
		Category category = categoryRepo.findByName(categoryName);
		if (category == null) {
			category = new Category(categoryName);
			categoryRepo.save(category);
		}
		
		Review newReview = reviewRepo.findByName(reviewName);
		
		if (newReview == null) {
			newReview = new Review(reviewName, reviewDescription, category);
			reviewRepo.save(newReview);
		}
		return "redirect:/show-reviews";
	}

	@RequestMapping("/delete-review")
	public String deleteReviewByName(String reviewName) {
		
		if (reviewRepo.findByName(reviewName) != null) {
			Review deletedReview = reviewRepo.findByName(reviewName);
			reviewRepo.delete(deletedReview);
		}
		
		return "redirect:/show-reviews";
		
	}

	public String deleteReviewById() {
		reviewRepo.deleteById(reviewId);
		
		return "redirect:/show-reviews";
		
	}

}
