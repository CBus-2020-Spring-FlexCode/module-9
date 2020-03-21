package org.wcci.reviews;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(ReviewController.class)
public class MockMVCTest {
	
	@Resource
	private MockMvc mvc;
	
	@Mock
	private Review reviewOne;
	
	@Mock
	private Review reviewTwo;
	
	@Mock
	private Category categoryOne;
	
	@Mock
	private Category categoryTwo;

	//Uncomment once Tag class is included in master
//	@Mock
//	private Tag tagOne;
//	
//	@Mock
//	private Tag tagTwo;
	
	@MockBean
	private ReviewRepository reviewRepo;
	
	@MockBean
	private CategoryRepository categoryRepo;

	//Uncomment once TagRepository is included in Master
//	@MockBean
//	private TagRepository tagRepo;
	
	@Test
	public void shouldBeOkForSingleReview() throws Exception {
		long testReviewId = 1;
		when(reviewRepo.findById(testReviewId)).thenReturn(Optional.of(reviewOne));
		mvc.perform(get("/review?id=1")).andExpect(status().isOk());
	}
	
	@Test
	public void shouldRouteToSingleReview() throws Exception {
		long testReviewId = 1;
		when(reviewRepo.findById(testReviewId)).thenReturn(Optional.of(reviewOne));
		mvc.perform(get("/review?id=1")).andExpect(view().name(is("review")));
	}
	
	@Test
	public void shouldNotBeOkForSingleReview() throws Exception {
		mvc.perform(get("/review?id=1")).andExpect(status().isNotFound());
	}

	@Test
	public void shouldPutSingleReviewIntoModel() throws Exception {
		when(reviewRepo.findById(1L)).thenReturn(Optional.of(reviewOne));
		
		mvc.perform(get("/review?id=1")).andExpect(model().attribute("reivews", is(reviewOne)));
	}
	
	@Test
	public void shouldRouteToAllReviews() throws Exception {
		mvc.perform(get("/reviews")).andExpect(view().name(is("reviews")));
	}
	
	@Test
	public void shouldBeOkForAllReviews() throws Exception {
		mvc.perform(get("/reviews")).andExpect(status().isOk());			
	}
	
	@Test
	public void shouldPutAllReviewsIntoModel() throws Exception {
		Collection<Review> allReviews = Arrays.asList(reviewOne, reviewTwo);
		when(reviewRepo.findAll()).thenReturn(allReviews);
		
		mvc.perform(get("/reviews")).andExpect(model().attribute("reviews", is(allReviews)));
	}
	
	@Test
	public void shouldBeOkForSingleCategory() throws Exception {
		long testCategoryId = 1;
		when(categoryRepo.findById(testCategoryId)).thenReturn(Optional.of(categoryOne));
		mvc.perform(get("/category?id=1")).andExpect(status().isOk());
	}
	
	@Test
	public void shouldRouteToSingleCategory() throws Exception {
		long testCategoryId = 1;
		when(categoryRepo.findById(testCategoryId)).thenReturn(Optional.of(categoryOne));
		mvc.perform(get("/category?id=1")).andExpect(view().name(is("category")));
	}
	
	@Test
	public void shouldNotBeOkForSingleCategory() throws Exception {
		mvc.perform(get("/category?id=1")).andExpect(status().isNotFound());
	}
	
	@Test
	public void shouldPutSingleCategoryIntoModel() throws Exception {
		when(categoryRepo.findById(1L)).thenReturn(Optional.of(categoryOne));
		
		mvc.perform(get("/category?id=1")).andExpect(model().attribute("cateogries", is(categoryOne)));
	}

	@Test
	public void shouldRouteToAllCategories() throws Exception {
		mvc.perform(get("/categories")).andExpect(view().name(is("categories")));
	}
	
	@Test
	public void shouldBeOkForAllCategories() throws Exception {
		mvc.perform(get("/categories")).andExpect(status().isOk());
	}
	
	@Test
	public void shouldPutAllCategoriesIntoModel() throws Exception {
		Collection<Category> allCategories = Arrays.asList(categoryOne, categoryTwo);
		when(categoryRepo.findAll()).thenReturn(allCategories);
		
		mvc.perform(get("/categories")).andExpect(model().attribute("categories", is(allCategories)));
	}
	
	//Add tag tests once Tag.java and TagRepository.java are included
//	@Test
//	public void shouldBeOkForSingleTag() throws Exception {
//		long testTagId = 1;
//		when(tagRepo.findById(testTagId)).thenReturn(Optional.of(tagOne));
//		mvc.perform(get("/tag?id=1")).andExpect(status().isOk());
//	}
//	
//	@Test
//	public void shouldRouteToSingleTag() throws Exception {
//		long testTagId = 1;
//		when(tagRepo.findById(testTagId)).thenReturn(Optional.of(tagOne));
//		mvc.perform(get("/tag?id=1")).andExpect(view().name(is("tag")));
//	}
//	
//	@Test
//	public void shouldNotBeOkForSingleTag() throws Exception {
//		mvc.perform(get("/tag?id=1")).andExpect(status().isNotFound());
//	}
//	
//	@Test
//	public void shouldPutSingleTagIntoModel() throws Exception {
//		when(tagRepo.findById(1L)).thenReturn(Optional.of(tagOne));
//		
//		mvc.perform(get("/tag?id=1")).andExpect(model().attribute("tags", is(tagOne)));
//	}
//	
//	@Test
//	public void shouldRouteToAllTags() throws Exception {
//		mvc.perform(get("/tags")).andExpect(view().name(is("tags")));
//	}
//	
//	@Test
//	public void shouldBeOkForAllTags() throws Exception {
//		mvc.perform(get("/tags")).andExpect(status().isOk());		
//	}
//	
//	@Test
//	public void shouldPutAllTagsIntoModel() throws Exception {
//		Collection<Category> allTags = Arrays.asList(tagOne, tagTwo);
//		when(tagRepo.findAll()).thenReturn(allTags);
//		
//		mvc.perform(get("/tags")).andExpect(model().attribute("tags", is(allTags)));
//	}


}























