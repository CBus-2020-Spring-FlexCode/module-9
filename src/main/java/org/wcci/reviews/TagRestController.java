package org.wcci.reviews;

import java.util.Collection;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import courses.Course;
import courses.Topic;

@RestController
@RequestMapping("/tags")
public class TagRestController {
	
	@Resource
	private ReviewRepository reviewRepo;
	
	@Resource TagRepository tagRepo;
	
	@RequestMapping("")
	public Iterable<Tag> findAllTags() {
		return tagRepo.findAll();
	}
	
	@RequestMapping("/{id}")
	public Optional<Tag> findOneTopic(@PathVariable long id) {
		return tagRepo.findById(id);
	}
	
	@RequestMapping("/(tagName)/reviews")
	public Collection<Tag> findAllCoursesByTopic(@PathVariable(value = "tagName") String tagName) {
		Tag tag = tagRepo.findByNameIgnoreCase(tagName);
		return reviewRepo.findByTagsContains(topic);
	}

}
