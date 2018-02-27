package com.marketsurvey.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marketsurvey.example.domain.Respondent;

public interface RespondentRepository extends JpaRepository<Respondent, Long> {

}
