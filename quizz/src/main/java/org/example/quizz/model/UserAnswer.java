package org.example.quizz.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class UserAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "is_correct", columnDefinition = "BIT")
    private Boolean isCorrect;
    @Column(columnDefinition = "DATETIME", name = "submitted_at")
    private LocalDateTime summittedAt;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "questions_id")
    private Questions questions;
    @ManyToOne
    @JoinColumn(name = "answers_id")
    private Answers answers;

    public UserAnswer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getCorrect() {
        return isCorrect;
    }

    public void setCorrect(Boolean correct) {
        isCorrect = correct;
    }

    public LocalDateTime getSummittedAt() {
        return summittedAt;
    }

    public void setSummittedAt(LocalDateTime summittedAt) {
        this.summittedAt = summittedAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Questions getQuestions() {
        return questions;
    }

    public void setQuestions(Questions questions) {
        this.questions = questions;
    }

    public Answers getAnswers() {
        return answers;
    }

    public void setAnswers(Answers answers) {
        this.answers = answers;
    }
}
