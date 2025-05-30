package org.example.quizz.service.TopicService;

import org.example.quizz.model.Topic;
import org.example.quizz.repository.ITopicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService implements ITopicService {
    @Autowired
    private ITopicRepo topicRepo;
    @Override
    public List<Topic> getAll() {
        return topicRepo.findAll();
    }
}
