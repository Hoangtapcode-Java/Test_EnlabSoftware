package org.example.quizz.repository;

import org.example.quizz.model.Answers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAnswersRepo extends JpaRepository<Answers, Long> {
    @Query("select a from Answers as a where a.questions.id =:id")
    List<Answers> getAnswersByQuestionId(@Param("id") Long id);
}
