package com.example.forohub.controller;

import com.example.forohub.model.Topic;
import com.example.forohub.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    @GetMapping
    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topic> getTopicById(@PathVariable Long id) {
        return topicRepository.findById(id)
                .map(topic -> ResponseEntity.ok().body(topic))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Topic createTopic(@Valid @RequestBody Topic topic) {
        return topicRepository.save(topic);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topic> updateTopic(@PathVariable Long id, @Valid @RequestBody Topic topicDetails) {
        return topicRepository.findById(id)
                .map(topic -> {
                    topic.setTitle(topicDetails.getTitle());
                    topic.setMessage(topicDetails.getMessage());
                    topic.setStatus(topicDetails.getStatus());
                    topic.setAuthor(topicDetails.getAuthor());
                    topic.setCourse(topicDetails.getCourse());
                    Topic updatedTopic = topicRepository.save(topic);
                    return ResponseEntity.ok().body(updatedTopic);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTopic(@PathVariable Long id) {
        return topicRepository.findById(id)
                .map(topic -> {
                    topicRepository.delete(topic);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
