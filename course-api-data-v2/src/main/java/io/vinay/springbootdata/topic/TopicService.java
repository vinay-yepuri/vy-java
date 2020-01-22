/**
 * 
 */
package io.vinay.springbootdata.topic;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author VINAY
 *
 */
@Service
public class TopicService {
	
	@Autowired
	private TopicRespository topicRespository;
	
	/*
	 * private List<Topic> topics = new ArrayList<>(Arrays.asList( new
	 * Topic("Spring","Spring Framework","Spring Framework Description"), new
	 * Topic("Java","Core Java","Core Java Description"), new
	 * Topic("Javascript","JavaScript","JavaScript Description") ));
	 */

	
	/**
	 * @return
	 */
	public List<Topic> getAllTopics(){
		List<Topic> topics = new ArrayList<Topic>();
		topicRespository.findAll().forEach(topics::add);
		return topics;
	}
	
	
	/**
	 * @param id
	 * @return
	 */
	public Topic getTopic(String id) {
		return topicRespository.findById(id).get();
		///return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}


	/**
	 * @param topic adding a topic
	 */
	public void addTopic(Topic topic) {
		topicRespository.save(topic);
		//topics.add(topic);
		
	}


	/**
	 * update the given topic 
	 * 
	 * @param topic
	 * @param id
	 */
	public void updateTopic(Topic topic, String id) {
		topicRespository.save(topic);
		/*
		 * for(int i = 0; i < topics.size(); i++) { Topic t = topics.get(i);
		 * if(t.getId().equals(id)) { topics.set(i, topic); return; } }
		 */
	}

	/**
	 * 
	 * Delete a topic
	 * 
	 * @param id
	 */
	public void deleteTopic(String id) {
		topicRespository.deleteById(id);
		//topics.removeIf(t -> t.getId().equals(id));
	}
}
