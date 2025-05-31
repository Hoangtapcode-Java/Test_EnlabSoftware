package org.example.quizz.repository;

import org.example.quizz.model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface IQuestionsRepo extends JpaRepository<Questions, Long> {
    @Query("select q from Questions as q where q.topic.id =:id")
    List<Questions> findAllByTopic(@Param("id") Long id);

    Optional<Questions> findById(Long id);
}
