package com.marketsurvey.example.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Survey implements Serializable{
	
	
	private static final long serialVersionUID = -4541679129078178552L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long surveyId;
	
	private String name;
	

	@ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinTable
	private Set<Question> questions = new HashSet<>();
	
	
	@OneToMany(mappedBy = "survey", cascade = CascadeType.ALL,fetch=FetchType.EAGER) 
	private Set<SurveyResponse> surveyResponses = new HashSet<>();
	

	
	@Override
	public int hashCode(){
	 return super.hashCode();	
	}
	
	@Override
	public boolean equals(Object surveyObj){
		if(surveyObj!=null && surveyObj instanceof Survey ){

	 return this.surveyId.equals(((Survey)surveyObj).getSurveyId());
		}
		return false;
	}
	
	@PrePersist
	public void prePersist(){ 
		if(surveyResponses!=null && !surveyResponses.isEmpty())
		for( SurveyResponse surveyResponse:surveyResponses){
			
			surveyResponse.setSurvey(this);
		}
		
	}

	public Survey(String name, Set<Question> questions,Set<SurveyResponse> surveyResponses) {
		this.name=name;
		this.questions=questions;
		this.surveyResponses=surveyResponses;
	}
	
	

}
