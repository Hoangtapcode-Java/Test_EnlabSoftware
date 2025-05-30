package org.example.quizz.service.QuestionsService;

import org.example.quizz.model.Questions;
import org.example.quizz.repository.IQuestionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionsService implements IQuestionsService {
    @Autowired
    private IQuestionsRepo questionsRepo;
    @Override
    public List<Questions> getQuestionsByTopic(Long id) {
        return questionsRepo.findAllByTopic(id);
    }
}
