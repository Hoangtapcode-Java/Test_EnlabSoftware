package org.example.quizz.controller;

import org.example.quizz.model.Topic;
import org.example.quizz.service.TopicService.ITopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200/", allowedHeaders = "*")
public class TopicController {
    @Autowired
    private ITopicService topicService;

    @GetMapping("/getAllTopic")
    public ResponseEntity<List<Topic>> getAllTopic() {
        return ResponseEntity.ok(topicService.getAll());
    }

}
