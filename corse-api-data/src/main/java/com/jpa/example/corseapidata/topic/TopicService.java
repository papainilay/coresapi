package com.jpa.example.corseapidata.topic;

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

	public List<Topic> getAlltopics() {

		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);// method reference || Lamda expression 1.8
		return topics;
	}

	public Optional<Topic> getTopicById(String id) {
		return topicRepository.findById(id);

	}

	public void addTopic(Topic topic) {

		topicRepository.save(topic);
	}

	public void updateTopic(String id, Topic topic) {

		topicRepository.save(topic);
	}

	public void deleteTopic(String id) {

		topicRepository.deleteById(id);

	}

}