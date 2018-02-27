package com.marketsurvey.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marketsurvey.example.domain.Response;

public interface ResponseRepository extends JpaRepository<Response, Long> {

}
