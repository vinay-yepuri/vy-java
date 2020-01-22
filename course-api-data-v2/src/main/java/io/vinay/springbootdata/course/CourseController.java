/**
 * 
 */
package io.vinay.springbootdata.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.vinay.springbootdata.topic.Topic;

/**
 * @author VINAY
 *
 */
@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	/**
	 * Get All courses for a given topic
	 * 
	 * @return
	 */
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id) {
		return courseService.getAllCourses(id);
	}
	
	/**
	 * Get course for given topic
	 * 
	 * @param id topic id
	 * @return topic
	 */
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
	}
	
	/**
	 * Adding new course to topic
	 * 
	 * @param course
	 * @param topicId
	 */
	@RequestMapping(method=RequestMethod.POST,value="/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.addCourse(course);
	}
	
	/**
	 * Delete a course of a topic 
	 * 
	 * @param id
	 */
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{topicId}/courses/{id}")
	public void deleteCourse(@PathVariable String id) {
		courseService.deleteCourse(id);
	}
	
	/**
	 * Updating a course ( of a topic ) with the id provided.
	 * 
	 * @param topic
	 */
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{topicId}/courses/{id}")
	public void updateTopic(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.updateCourse(course);
	}
}
