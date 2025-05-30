package org.example.quizz.service.QuestionsService;

import org.example.quizz.model.Questions;

import java.util.List;

public interface IQuestionsService {
    List<Questions> getQuestionsByTopic(Long id);
}
