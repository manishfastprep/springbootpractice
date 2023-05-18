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

//Option.java (Entity class)
@Entity
@Getter
@Setter
@Table(name = "option_for_question")
public class Option {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int optionId;

 @ManyToOne
 @JoinColumn(name = "question_id")
 private Question question;

 private String optionText;

 private boolean isCorrect;

}
