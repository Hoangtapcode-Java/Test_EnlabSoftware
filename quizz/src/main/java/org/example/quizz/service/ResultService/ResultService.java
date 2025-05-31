package org.example.quizz.service.ResultService;

import org.example.quizz.model.Result;
import org.example.quizz.model.Topic;
import org.example.quizz.model.User;
import org.example.quizz.repository.IResultRepo;
import org.example.quizz.repository.ITopicRepo;
import org.example.quizz.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResultService implements IResultService {
    @Autowired
    private IResultRepo resultRepo;
    @Autowired
    private IUserRepo userRepo;
    @Autowired
    private ITopicRepo topicRepo;
    @Override
    public Result addResult(Long topicId, String email) {
        User user = userRepo.findByEmail(email);
        Optional<Topic> topic = topicRepo.findById(topicId);
        Long userId = user.getId();
        Result result = new Result();
        Integer sumCorrect = resultRepo.countCorrectAnswersByTopic(userId,topicId);
        Integer sumTime = resultRepo.sumTotalTimeByTopic(userId,topicId);
        Integer sumQuestion = resultRepo.countTotalQuestionsByTopic(userId,topicId);
        result.setCorrectAnswers(sumCorrect);
        result.setTotalQuestions(sumQuestion);
        result.setTotalTime(sumTime);
        result.setStatusPass(sumCorrect >= 6 ? true: false);
        result.setTopic(topic.get());
        result.setUser(user);
        return resultRepo.save(result);
    }

    @Override
    public Result getRsult(Long topicId, String email) {
        Long userId = userRepo.findByEmail(email).getId();
        return resultRepo.findByUserIdAndTopicId(userId, topicId);
    }
}
