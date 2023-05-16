package com.fastprep.practice.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long questionId;

    private String question;

    @OneToMany
    private List<Answer> answers;

    // Constructors, getters, and setters

    public Long getQuestionId()
	{
		return questionId;
	}

	public void setQuestionId(Long questionId)
	{
		this.questionId = questionId;
	}

	public Question() {
    }

    public Question(String question) {
        this.question = question;
    }

    

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
