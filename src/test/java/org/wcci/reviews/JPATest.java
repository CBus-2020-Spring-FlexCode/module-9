package org.wcci.reviews;

	import static org.hamcrest.CoreMatchers.equalTo;
	import static org.hamcrest.CoreMatchers.hasItems;
	import static org.junit.Assert.assertThat;

	import javax.annotation.Resource;

	import org.junit.Test;
	import org.junit.runner.RunWith;
	import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
	import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
	import org.springframework.test.context.junit4.SpringRunner;

	@DataJpaTest
	@RunWith(SpringRunner.class)
	public class JPATest {

		@Resource
		private ReviewRepository reviewRepo;

		@Resource
		private CategoryRepository categoryRepo;

		@Resource
		private TestEntityManager entityManager;

		@Resource
		private Category Category;

		@Test

		public void retrievedReviewIsTheSameAsOriginalReview() {

			Review testReview = new Review("review", "description", "image", Category);
			testReview = reviewRepo.save(testReview);

			entityManager.flush();
			entityManager.clear();

			Review retrievedReview = reviewRepo.findById(testReview.getId()).get();

			assertThat(retrievedReview, equalTo(testReview));

		}

		@Test
		public void retrieveReviewHasListOfCategories() {
			Review testReview = new Review("review", "description", "image", Category);
			testReview = reviewRepo.save(testReview);

			Category category = new Category("category", testReview);
			category = categoryRepo.save(category);
			Category anotherCategory = new Category("anotherCategory", testReview);
			anotherCategory = categoryRepo.save(category);

			entityManager.flush();
			entityManager.clear();

			Review retrievedReview = reviewRepo.findById(testReview.getId()).get();

			assertThat(retrievedReview.getCategories(), hasItems(category, anotherCategory));
		}
	}

}
