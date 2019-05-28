package com.kgate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kgate.entity.Question;

@Repository 
public interface QuestionRepository extends JpaRepository<Question, Long> {

}
