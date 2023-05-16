package com.fastprep.practice.repository;

import com.fastprep.practice.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    // Add additional query methods if needed
}

