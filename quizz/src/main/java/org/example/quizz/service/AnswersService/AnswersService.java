package org.example.quizz.service.AnswersService;

import org.example.quizz.model.Answers;
import org.example.quizz.repository.IAnswersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswersService implements IAnswersService {
    @Autowired
    private IAnswersRepo answersRepo;
    @Override
    public List<Answers> getAnswersByQuestions(Long id) {
        return answersRepo.getAnswersByQuestionId(id);
    }
}
