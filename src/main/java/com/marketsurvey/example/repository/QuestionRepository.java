package com.marketsurvey.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.marketsurvey.example.domain.Question;



@RepositoryRestResource(collectionResourceRel = "questions", path = "questions")
public interface QuestionRepository extends JpaRepository<Question, Long>{


}
