package com.jpa.example.corseapidata.topic;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // it will register it when the class will be loaded. Its a stereotype
			// annotation.
public class TopicService {

			@Autowired
			private TopicRepository topicRepository; // creation of JPA .. so created one interface and autowired it.
	
	
/*	List<Topic> topics = new ArrayList<>(Arrays.asList(

			new Topic("Spring", "Spring framework", "Spring Framework Description"),
			new Topic("Java", "Spring framework java", "Spring Framework Description java"),
			new Topic("Javascript", "Spring framework json", "Spring Framework Description json"),
			new Topic("JSON", "Nilay framework json", "Spring 4 Framework Description json")

	));*/
			
			List<Topic> topics= new ArrayList<>(); // Connecting with database calling this topics object for JPA.

	public List<Topic> getAlltopics() {
		//return topics;
		List<Topic> topics= new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}

/*	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();// Lambda
																					// expression
																					// to
																					// traverse
																					// the
																					// List
																					// array
																					// elements
																					// on
																					// the
																					// basis
																					// of
																					// ids


		
	}*/
	
	public Optional<Topic> getTopicById(String id){
			return topicRepository.findById(id);
		
	}

	public void addTopic(Topic topic) {
		// TODO Auto-generated method stub
		//topics.add(topic);
		topicRepository.save(topic);
	}

	/*
	 * public Object updateTopic(Topic topic) { // TODO Auto-generated method
	 * stub return null; }
	 */

	public void updateTopic(String id, Topic topic) {
		// TODO Auto-generated method stub
		//topics.add(topic);
		topicRepository.save(topic);
	}

	
	public void updateTopic(Topic topic, String id) {
		// TODO Auto-generated method stub

		for (int i = 0; i < topics.size(); i++) {
			System.out.println("currently we into this location:" + i);

			Topic t = topics.get(i);
			System.out.println("out put inside : t***********:" + t);

			if (t.getId().equals(id)) {
				topics.set(i, topic);

				System.out.println("out put inside : i***********:" + i);

				System.out.println("out put inside loop: topic***********:" + topic);

				System.out.println("##################################");
				System.out.println("##################################");
				System.out.println("##################################");

			}
		}
		System.out.println("out put inside outer loop: topic***********:" + topic);

		System.out.println("out put outer loop: id***********:" + id);

	}

	public void deleteTopic(String id) {
		// TODO Auto-generated method stub
		//topics.removeIf(t -> t.getId().equals(id)); // this will delete the topics.

		// topics.removeIf(t ->t.getId().equals(id));

		// System.out.println("The deleted items will be: id: " +id);

		// System.out.println("The deleted items will be: t: " +topics.get);

		topicRepository.deleteById(id);
		
		
	}

}