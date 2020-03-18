package org.wcci.reviews;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Collection;
import java.util.Optional;

import javax.annotation.Resource;

import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest
public class ReviewControllerMockMvcTest {
	
	@Resource
	private MockMvc mvc;
	
	@MockBean
	private ReviewRepository reviewRepo;
	
	@MockBean
	private CategoryRepository categoryRepo;
	
	@Mock
	private Review review;
	
	@Mock
	private Review anotherReview;
	
	@Test
	public void shouldRouteToSingleReview() throws Exception {
		long reviewId = 1;
		when(reviewRepo.findById(reviewId)).thenReturn(Optional.of(review));
		mvc.perform(get("/review?id=1")).andExpect(view().name(is("review")));
	}
	
	@Test
	public void shouldBeOkayForSingleReview()throws Exception {
		long reviewId = 1;
		when(reviewRepo.findById(reviewId)).thenReturn(Optional.of(review));
		mvc.perform(get("/show-review?id=1")).andExpect(status().isOk());
	}
	
	@Test
	public void shouldPutSingleReviewIntoModel() throws Exception {
		when(reviewRepo.findById(1L)).thenReturn(Optional.of(review));
		
		mvc.perform(get("/review?id=1")).andExpect(model().addAttribute("reviews", (is(review))));
	}
	
	@Test
	public void shouldRouteToAllReviews() throws Exception {
		mvc.perform(get("/show-reviews")).andExpect(view().name(is("reviews")));
	}
	
	@Test
	public void shouldBeOkayForAllReviews() throws Exception {
		mvc.perform(get("/show-reviews")).andExpect(status().isOk());
	}
	
	@Test
	public void shouldPutAllReviewsIntoModel() throws Exception {
		Collection<Review> allReviews = Arrays.asList(review, anotherReview);
		when(reviewRepo.findAll()).thenReturn(allReviews);
		
		mvc.perform(get("/show-reviews")).andExpect(model().attribute("reviews", is(allReviews)));
	}
	
	

}
