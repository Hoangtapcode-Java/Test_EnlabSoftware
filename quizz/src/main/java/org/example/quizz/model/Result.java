package org.example.quizz.model;

import jakarta.persistence.*;

@Entity
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer total_time;
    private Integer correct_answers;
    @Column(columnDefinition = "BIT")
    private Boolean statusPass;
    private Integer total_questions;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

    public Result() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTotal_time() {
        return total_time;
    }

    public void setTotal_time(Integer total_time) {
        this.total_time = total_time;
    }

    public Integer getCorrect_answers() {
        return correct_answers;
    }

    public void setCorrect_answers(Integer correct_answers) {
        this.correct_answers = correct_answers;
    }

    public boolean isStatusPass() {
        return statusPass;
    }

    public void setStatusPass(boolean statusPass) {
        this.statusPass = statusPass;
    }

    public Integer getTotal_questions() {
        return total_questions;
    }

    public void setTotal_questions(Integer total_questions) {
        this.total_questions = total_questions;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
