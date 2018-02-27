package com.marketsurvey.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.marketsurvey.example.domain.Survey;

@RepositoryRestResource(collectionResourceRel = "surveys", path = "surveys")
public interface SurveyRepository extends  JpaRepository<Survey, Long>{
 
}
