package org.example.quizz.service.UserAnswerService;

import org.example.quizz.dto.UserAnswerDto;
import org.example.quizz.model.UserAnswer;

public interface IUserAnswerService {
    UserAnswer submitAnswer(UserAnswerDto userAnswerDto);
}
