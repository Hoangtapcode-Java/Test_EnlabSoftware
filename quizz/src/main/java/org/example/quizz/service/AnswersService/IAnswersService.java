package org.example.quizz.service.AnswersService;

import org.example.quizz.model.Answers;

import java.util.List;

public interface IAnswersService {
    List<Answers> getAnswersByQuestions(Long id);
}
