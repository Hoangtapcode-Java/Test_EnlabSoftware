package org.example.quizz.controller;

import org.example.quizz.model.Questions;
import org.example.quizz.service.QuestionsService.IQuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200/", allowedHeaders = "*")
public class QuestionsController {
    @Autowired
    private IQuestionsService questionsService;

    @GetMapping("/getQuestionByTopic/{id}")
    public ResponseEntity<List<Questions>> getQuestionByTopic(@PathVariable("id") Long id) {
        return ResponseEntity.ok(questionsService.getQuestionsByTopic(id));
    }
}
