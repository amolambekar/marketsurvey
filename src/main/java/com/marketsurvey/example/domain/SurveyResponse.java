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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class SurveyResponse implements Serializable {
	
	
	private static final long serialVersionUID = 3780410000175252428L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long surveyResponseId;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="surveyId")
	private Survey survey;
	
	
	@ManyToOne
	 @JoinColumn(name = "respondentId")
	private Respondent respondentId;
	
	
	@OneToMany(mappedBy="responseId.surveyResponse",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<Response> responses = new HashSet<>();

	@Override
	public int hashCode(){
	 return super.hashCode();	
	}
	
	@Override
	public boolean equals(Object object){
		if(object!=null && object instanceof SurveyResponse ){

	 return this.surveyResponseId.equals(((SurveyResponse)object).getSurveyResponseId());
		} 
		return false;
	}
	

	@PrePersist
	public void prePersist(){
		
		for(Response response:responses){
			System.out.println(" is response.getResponsed  empty &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&   "+response.getResponseId());
			response.getResponseId().setSurveyResponse(this);
		}
		
		
	}
	
}
