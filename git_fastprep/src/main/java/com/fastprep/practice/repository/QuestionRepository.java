package com.fastprep.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fastprep.practice.entity.Question;

//QuestionRepository.java (Repository interface)
@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
