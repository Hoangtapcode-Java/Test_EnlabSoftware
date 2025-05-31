package org.example.quizz.service.ResultService;

import org.example.quizz.model.Result;

public interface IResultService {
    Result addResult(Long topicId, String email);
    Result getRsult(Long topicId, String email);
}
