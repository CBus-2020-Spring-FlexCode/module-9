package org.wcci.reviews;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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
	private TagRepository tagRepo;
	
	@Test
	public void shouldSaveAndLoadCategory() {
		Category category = new Category("Health");
		category = categoryRepo.save(category);
		
		entityManager.flush();
		entityManager.clear();
		
		assertThat(category.getName(), is("Health"));
	}
	
	@Test
	public void shouldSaveAndLoadTag() {
		Tag tag = tagRepo.save(new Tag("Health"));
		long tagId = tag.getId(); 
		
		entityManager.flush();
		entityManager.clear();
		
		Optional<Tag> result = tagRepo.findById(tagId);
		result.get();
		assertThat(tag.getName(), is("tag"));
	}

}
