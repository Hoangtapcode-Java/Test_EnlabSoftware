package org.example.quizz.dto;

import java.util.List;

public class UserAnswerDto {
    private Boolean isCorrect;
    private Integer totalTime;
    private String email;
    private Long questionsId;
    private List<Long> answersId;
    private Long topicId;

    public UserAnswerDto(Boolean isCorrect, Integer totalTime, String email, Long questionsId, List<Long> answersId, Long topicId) {
        this.isCorrect = isCorrect;
        this.totalTime = totalTime;
        this.email = email;
        this.questionsId = questionsId;
        this.answersId = answersId;
        this.topicId = topicId;
    }

    public Boolean getCorrect() {
        return isCorrect;
    }

    public void setCorrect(Boolean correct) {
        isCorrect = correct;
    }

    public Integer getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Integer totalTime) {
        this.totalTime = totalTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getQuestionsId() {
        return questionsId;
    }

    public void setQuestionsId(Long questionsId) {
        this.questionsId = questionsId;
    }

    public List<Long> getAnswersId() {
        return answersId;
    }

    public void setAnswersId(List<Long> answersId) {
        this.answersId = answersId;
    }

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }
}
