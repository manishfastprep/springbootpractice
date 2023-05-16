package com.fastprep.practice.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.fastprep.practice.entity.Question;
import com.fastprep.practice.repository.QuestionRepository;

//TestPrepService.java
@Service
public class TestPrepService {

 private final QuestionRepository questionRepository;

 public TestPrepService(QuestionRepository questionRepository) {
     this.questionRepository = questionRepository;
 }

 public List<Question> getAllQuestions() {
     return questionRepository.findAll();
 }

 public Question getQuestionById(int questionId) {
     return questionRepository.findById(questionId)
             .orElseThrow(() -> new NoSuchElementException("Question not found"));
 }

 public Question createQuestion(Question question) {
     return questionRepository.save(question);
 }

 public Question updateQuestion(Long questionId, Question question) {
     question.setQuestionId(questionId);
     return questionRepository.save(question);
 }

 public void deleteQuestion(int questionId) {
     questionRepository.deleteById(questionId);
 }
}
