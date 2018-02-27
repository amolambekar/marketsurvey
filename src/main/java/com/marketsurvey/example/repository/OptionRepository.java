package com.marketsurvey.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marketsurvey.example.domain.Option;

public interface OptionRepository extends JpaRepository<Option, Long> {

}
