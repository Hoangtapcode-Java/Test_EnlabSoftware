package org.example.quizz.repository;

import org.example.quizz.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITopicRepo extends JpaRepository<Topic, Long> {
}
