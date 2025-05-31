package org.example.quizz.service.UserService;

import org.example.quizz.dto.UserAnswerDto;
import org.example.quizz.model.User;
import org.example.quizz.model.UserAnswer;

public interface IUserService {
    User addUser(User user);
    Boolean existEmail(String email);

}
