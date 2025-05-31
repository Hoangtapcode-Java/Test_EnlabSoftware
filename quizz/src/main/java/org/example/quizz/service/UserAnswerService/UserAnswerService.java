package org.example.quizz.service.UserAnswerService;

import org.example.quizz.dto.UserAnswerDto;
import org.example.quizz.model.*;
import org.example.quizz.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAnswerService implements IUserAnswerService {
    @Autowired
    private IUserRepo userRepo;
    @Autowired
    private IUserAnswerRepo userAnswerRepo;
    @Autowired
    private IQuestionsRepo questionsRepo;
    @Autowired
    private IAnswersRepo answersRepo;
    @Autowired
    private ITopicRepo topicRepo;
    @Override
    public UserAnswer submitAnswer(UserAnswerDto userAnswerDto) {
        User user = userRepo.findByEmail(userAnswerDto.getEmail());
        Optional<Questions> question = questionsRepo.findById(userAnswerDto.getQuestionsId());

        List<Answers> selectedAnswers = answersRepo.findAllById(userAnswerDto.getAnswersId());

        UserAnswer userAnswer = new UserAnswer();
        System.out.println("user: " + user);
        userAnswer.setUser(user);
        userAnswer.setQuestions(question.get());
        userAnswer.setAnswers(selectedAnswers); // <-- gán danh sách đáp án
        userAnswer.setCorrect(userAnswerDto.getCorrect());
        userAnswer.setTotalTime(userAnswerDto.getTotalTime());

        return userAnswerRepo.save(userAnswer);
    }
}
