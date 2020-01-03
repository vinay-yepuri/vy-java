/**
 * 
 */
package io.vinay.springbootdata.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * @author VINAY
 *
 */
public interface CourseRespository extends CrudRepository<Course,String>{

	public List<Course> findByTopicId(String topicId);
}
