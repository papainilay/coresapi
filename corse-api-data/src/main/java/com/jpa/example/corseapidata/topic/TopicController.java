package com.jpa.example.corseapidata.topic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	

	@Autowired
	private TopicService topicService; // it looks as a registry and find it out
										// from made it work as a dependency and
										// inject it..

	// @RequestMapping("/topics")

	@RequestMapping("/topic")
	public String getAllTopic() {
		return "All Topic";
	}

	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		// return "All topics";
		/*
		 * return Arrays.asList(
		 * 
		 * new Topic("Spring", "Spring framework",
		 * "Spring Framework Description"), new Topic("Java",
		 * "Spring framework java", "Spring Framework Description java"), new
		 * Topic("Javascript", "Spring framework json",
		 * "Spring Framework Description json"), new Topic("JSON",
		 * "Nilay framework json", "Spring 4 Framework Description json")
		 * 
		 * );
		 * 
		 * //return Arrays.
		 */

		return topicService.getAlltopics();
	}

@RequestMapping("/topics/{id}")
	public Optional<Topic> getTopic(@PathVariable String id) {

		return topicService.getTopicById(id);
	}

	/*@RequestMapping("/topics/{id}")
	public Optional<Topic> getTopic(@PathVariable String id) {

		return topicService.getTopicById(id);
	}*/
	
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	public void addTopic(@RequestBody Topic topic) {

		topicService.addTopic(topic);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {

		topicService.updateTopic(id,topic);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
	public void deleteTopic(@PathVariable String id) {

		topicService.deleteTopic(id);
	}

}
