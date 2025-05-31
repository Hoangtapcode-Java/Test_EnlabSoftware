package org.example.quizz.controller;

import org.example.quizz.dto.UserAnswerDto;
import org.example.quizz.service.UserAnswerService.IUserAnswerService;
import org.example.quizz.service.UserAnswerService.UserAnswerService;
import org.example.quizz.service.UserService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200/", allowedHeaders = "*")
public class UserAnswerController {
    @Autowired
    private IUserAnswerService userAnswerService;
    @PostMapping("submitAnswer")
    public ResponseEntity<?> submitAnswer(@RequestBody UserAnswerDto userAnswer) {
        System.out.println(userAnswer.getAnswersId());
        userAnswerService.submitAnswer(userAnswer);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
