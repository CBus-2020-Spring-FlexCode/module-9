package org.wcci.reviews;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

public class ReviewControllerTest {

	@InjectMocks
	private ReviewController underTest;

	@Mock
	private Review review;
	Long reviewId;
	@Mock
	private Review anotherReview;

	@Mock
	private ReviewRepository reviewRepo;

	@Mock
	private Category category;
	@Mock
	private Category anotherCategory;

	@Mock
	private CategoryRepository categoryRepo;

	@Mock
	private Model model;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldAddSingleReviewToModel() {
		long reviewId = 1;
		when(reviewRepo.findById(reviewId)).thenReturn(Optional.of(review));

		underTest.findReview(reviewId, model);
		verify(model).addAttribute("reviews", review);
	}

	@Test
	public void shouldAddAllReviewsToModel() {
		Collection<Review> allReviews = Arrays.asList(review, anotherReview);
		when(reviewRepo.findAll()).thenReturn(allReviews);

		underTest.findAllReviews(model);
		verify(model).addAttribute("reviews", allReviews);
	}

	@Test
	public void shouldAddSingleCategoryToModel() {
		long categoryId = 1;
		when(categoryRepo.findById(categoryId)).thenReturn(Optional.of(category));

		underTest.findCategory(categoryId, model);
		verify(model).addAttribute("Categories", category);
	}

	@Test
	public void shouldAddAllCategoriesToModel() {
		Collection<Category> allCategories = Arrays.asList(category, anotherCategory);
		when(categoryRepo.findAll()).thenReturn(allCategories);

		underTest.findAllCategories(model);
		verify(model).addAttribute("categories", allCategories);
	}

	@Test
	public void shouldAddAdditionalReviewToModel() {
		String categoryName = "catgory name";
		Category newCategory = categoryRepo.findByName(categoryName);

		String reviewName = "new review";
		String reviewDescription = "new review description";

		underTest.addReview(reviewName, reviewDescription, categoryName);
		Review newReview = new Review(reviewName, reviewDescription, newCategory);
		when(reviewRepo.save(newReview)).thenReturn(newReview);

	}

	@Test
	public void shouldRemoveReviewFromModelByName() {
		String reviewName = review.getName();
		when(reviewRepo.findByName(reviewName)).thenReturn(review);
		underTest.deleteReviewByName(reviewName);

		verify(reviewRepo).delete(review);
	}

	@Test
	public void shouldRemoveReviewFromModelById() {
		underTest.deleteReviewById();
		verify(reviewRepo).deleteById(reviewId);
	}

}