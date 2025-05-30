package org.example.quizz.repository;

import org.example.quizz.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IResultRepo extends JpaRepository<Result, Long> {
}
