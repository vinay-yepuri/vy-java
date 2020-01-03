/**
 * 
 */
package io.vinay.springbootdata.course;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author VINAY
 *
 */
@Service
public class CourseService {
	
	@Autowired
	private CourseRespository courseRespository;
	
	/*
	 * private List<Topic> topics = new ArrayList<>(Arrays.asList( new
	 * Topic("Spring","Spring Framework","Spring Framework Description"), new
	 * Topic("Java","Core Java","Core Java Description"), new
	 * Topic("Javascript","JavaScript","JavaScript Description") ));
	 */

	
	/**
	 * @return
	 */
	public List<Course> getAllCourses(String topicId){
		List<Course> courses = new ArrayList<Course>();
		courseRespository.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}
	
	
	/**
	 * @param id
	 * @return
	 */
	public Course getCourse(String id) {
		return courseRespository.findById(id).get();
		///return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}


	/**
	 * @param topic adding a course
	 */
	public void addCourse(Course topic) {
		courseRespository.save(topic);
		//topics.add(topic);
		
	}


	/**
	 * update the given course 
	 * 
	 * @param topic
	 * @param id
	 */
	public void updateCourse(Course topic) {
		courseRespository.save(topic);
		/*
		 * for(int i = 0; i < topics.size(); i++) { Topic t = topics.get(i);
		 * if(t.getId().equals(id)) { topics.set(i, topic); return; } }
		 */
	}

	/**
	 * 
	 * Delete a course
	 * 
	 * @param id
	 */
	public void deleteCourse(String id) {
		courseRespository.deleteById(id);
		//topics.removeIf(t -> t.getId().equals(id));
	}
}
