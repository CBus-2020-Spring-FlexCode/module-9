package org.wcci.reviews;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

import java.util.Collection;
import java.util.Optional;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class JPAMappingsTest {
	
	@Resource
	private TestEntityManager entityManager;
	
	@Resource
	private CategoryRepository categoryRepo;
	
	@Resource
	private ReviewRepository reviewRepo;
	
	@Resource TagRepository tagRepo;
	
	@Test
	public void shouldSaveAndLoadCategory() {
		Category category = new Category("Health");
		category = categoryRepo.save(category);
		
		entityManager.flush();
		entityManager.clear();
		
		assertThat(category.getName(), is("Health"));
	}
	
	@Test
	public void shouldGenerateReviewId() {
		Category category = categoryrepo.save(new Category("category"));
		Long categoryId = category.getId();
		
		entityManager.flush();
		entityManager.clear();
		
		assertThat(categoryId, is(greaterThan(0L)));
	}
	
	@Test
	public void shouldSaveAndLoadReviews() {
		Review review = new Review("name", "description", "image");
		review = reviewRepo.save(review);
		long reviewId = review.getId();
		
		entityManager.flush();
		entityManager.clear();
		
		Optional<Review> result = reviewRepo.findById(reviewId);
		review = result.get();
		assertThat(review.getName(), is("name"));
	}
	
	@Test
	public void ahouldEstablishReviewToCategoryRelationship() {
		Category category = categoryRepo.save(new Category("category"));
		Category anotherCategory = categoryrepo.save(new Category("anotherCategory"));
		
		Review review = new Review("name", "description", "image", category, anotherCategory);
		review = reviewRepo.save(review);
		long reviewId = review.getId();
		
		Optional<Review> result = reviewRepo.findById(reviewId);
		review = result.get();
		assertThat(review.getCategory(), containsInAnyOrder(category, anotherCategory));
	}

	@Test
	public void shouldFindReviewsForCategory() {
		Category category = categoryRepo.save(new Category("category"));
		
		Review review = reviewRepo.save(new Review("review", "description", "image", category));
		Review anotherReview = reviewRepo.save(new Review("anotherReview", "description", "image", category));
		
		entityManager.flush();
		entityManager.clear();
		
		Collection<Review> reviewsForCategory = reviewRepo.findByCategoryId(categoryId);
		assertThat(reviewsForCategory, containsInAnyOrder(review, anotherReview));
	}
	
	@Test
	public void shouldGenerateTagId() {
		Tag tag = tagRepo.save(new Tag("tag"));
		Long tagId = tag.getId();
		
		entityManager.flush();
		entityManager.clear();
		
		assertThat(tagId, is(greaterThan(0L)));
	}
	
	@Test
	public void shouldSaveAndLoadTags() {
		Tag tag = new Tag("tag");
		tag = tagRepo.save(tag);
		long tagId = tag.getId();
		
		entityManager.flush();
		entityManager.clear();
		
		Optional<Tag> result = tagRepo.findById(tagId);
		review = result.get();
		assertThat(tag.getName(), is("tag"));
	}
	
	@Test
	public void shouldSaveAndTagToReviewRelationship() {
		Review review = new Review("name", "description", "image");
		reviewRepo.save(review);
		long reviewId = review.getId();
		
		Tag tag = new Tag("tag", review);
		tagRepo.save("tag");
		
		Tag anotherTag = new Tag("anotherTag", review);
		tagRepo.save("anotherTag");
		
		entityManager.flush();
		entityManager.clear();
		
		Optional<Review> result = reviewRepo.findById(reviewId);
		review = result.get();
		assertThat(review.getTags(), containsInAnyOrder(tag, anotherTag));

		@Test
		public void shouldSortReviews() {
			Review review = new Review("review", "description", "image");
			review = reviewRepo.save(review);
			
			Review anotherReview = new Review("anotherReview", "description", "image");
			anotherReview = reviewRepo.save(anotherReview);
			
			entityManager.flush();
			entityManager.clear();
			
			Collection<Review> sortedReviews = reviewRepo.findAll();
			assertThat(sortedReviews, contains(anotherReview, review));
		}