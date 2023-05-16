package com.fastprep.practice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

//AnswerText.java (Entity class)
@Entity
@Getter
@Setter
@Table
public class AnswerText {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int answerTextId;

 @ManyToOne
 @JoinColumn(name = "question_id")
 private Question question;

 @ManyToOne
 @JoinColumn(name = "answer_id")
 private Answer answer;

 private String text;

}
