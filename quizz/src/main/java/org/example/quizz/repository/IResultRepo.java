package org.example.quizz.repository;

import org.example.quizz.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IResultRepo extends JpaRepository<Result, Long> {
    @Query("SELECT COUNT(ua) FROM UserAnswer ua WHERE ua.user.id = :userId AND ua.questions.topic.id = :topicId")
    Integer countTotalQuestionsByTopic(@Param("userId") Long userId, @Param("topicId") Long topicId);

    @Query("SELECT COUNT(ua) FROM UserAnswer ua WHERE ua.user.id = :userId AND ua.questions.topic.id = :topicId AND ua.isCorrect = true")
    Integer countCorrectAnswersByTopic(@Param("userId") Long userId, @Param("topicId") Long topicId);

    @Query("SELECT SUM(ua.totalTime) FROM UserAnswer ua WHERE ua.user.id = :userId AND ua.questions.topic.id = :topicId")
    Integer sumTotalTimeByTopic(@Param("userId") Long userId, @Param("topicId") Long topicId);

    Result findByUserIdAndTopicId(Long userId, Long topicId);
}
