package org.example.quizz.controller;

import org.example.quizz.service.ResultService.IResultService;
import org.example.quizz.service.TopicService.ITopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200/", allowedHeaders = "*")
public class ResultController {
    @Autowired
    private ITopicService topicService;
    @Autowired
    private IResultService resultService;
    @PostMapping("/addResult")
    public ResponseEntity<?> addResult(@RequestParam("topicId") Long topicId, @RequestParam("email") String email) {
        resultService.addResult(topicId, email);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/getResult")
    public ResponseEntity<?> getResult(@RequestParam("topicId") Long topicId, @RequestParam("email") String email) {
        return ResponseEntity.ok(resultService.getRsult(topicId, email));
    }
}
