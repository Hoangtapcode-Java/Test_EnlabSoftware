package org.example.quizz.controller;

import org.example.quizz.model.Answers;
import org.example.quizz.service.AnswersService.IAnswersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200/", allowedHeaders = "*")
public class AnswersController {
    @Autowired
    private IAnswersService answersService;

    @GetMapping("/getAnswersByQuestion/{id}")
    public ResponseEntity<List<Answers>> getAnswersByQuestion(@PathVariable("id") Long id){
        return ResponseEntity.ok(answersService.getAnswersByQuestions(id));
    }

}
