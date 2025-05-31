package org.example.quizz.service.UserService;

import org.example.quizz.dto.UserAnswerDto;
import org.example.quizz.model.User;
import org.example.quizz.model.UserAnswer;
import org.example.quizz.repository.IUserAnswerRepo;
import org.example.quizz.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepo userRepo;
    @Autowired
    private IUserAnswerRepo userAnswerRepo;
    @Override
    public User addUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public Boolean existEmail(String email) {
        return userRepo.existsByEmail(email);
    }


}
