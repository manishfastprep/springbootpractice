package com.fastprep.practice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fastprep.practice.entity.Question;
import com.fastprep.practice.service.TestPrepService;



//TestPrepController.java
@RestController
@RequestMapping("/api/testprep")
public class TestPrepController {

 private final TestPrepService testPrepService;

 public TestPrepController(TestPrepService testPrepService) {
     this.testPrepService = testPrepService;
 }

 @GetMapping("/questions")
 public List<Question> getAllQuestions() {
     return testPrepService.getAllQuestions();
 }

 @GetMapping("/questions/{questionId}")
 public Question getQuestionById(@PathVariable int questionId) {
     return testPrepService.getQuestionById(questionId);
 }

 @PostMapping("/questions")
 public Question createQuestion(@RequestBody Question question) {
     return testPrepService.createQuestion(question);
 }

 @PutMapping("/questions/{questionId}")
 public Question updateQuestion(@PathVariable Long questionId, @RequestBody Question question) {
     return testPrepService.updateQuestion(questionId, question);
 }

 @DeleteMapping("/questions/{questionId}")
 public void deleteQuestion(@PathVariable int questionId) {
     testPrepService.deleteQuestion(questionId);
 }
}
