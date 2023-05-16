package com.fastprep.practice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long answerId;

    private String answerText;

    // Constructors, getters, and setters

    public Answer() {
    }

    public Answer(String answerText) {
        this.answerText = answerText;
    }

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }
}

