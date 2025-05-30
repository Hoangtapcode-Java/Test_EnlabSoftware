package org.example.quizz.repository;

import org.example.quizz.model.UserAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserAnswerRepo extends JpaRepository<UserAnswer, Long> {
}
