package org.example.quizz.service.UserService;

import org.example.quizz.model.User;

public interface IUserService {
    User addUser(User user);
    Boolean existEmail(String email);
}
