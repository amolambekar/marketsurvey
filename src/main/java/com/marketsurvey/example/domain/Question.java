package com.marketsurvey.example.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Question implements Serializable{

	
	private static final long serialVersionUID = -487931570782832250L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long questionId;
	
	@Column
	private String question;
	
	
	@OneToMany(mappedBy="question",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private Set<Option> options = new HashSet<>();
	
	
	@ManyToMany(mappedBy="questions",cascade=CascadeType.ALL)
	Set<Survey> survey = new HashSet<>();
	
	
	@OneToMany(mappedBy="responseId.question",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private Set<Response> responses= new HashSet<>(); 
	
	

	@JsonCreator
	public Question( @JsonProperty("question") String question,@JsonProperty("options") Set<Option> options
			) {
		this.question = question;
		this.options=options;
		//this.responses=responses;

	}
	
	@Override
	public int hashCode(){
	 return super.hashCode();	
	}
	
	@Override
	public boolean equals(Object questionObj){
		if(questionObj!=null && questionObj instanceof Question ){

	 return this.questionId.equals(((Question)questionObj).getQuestionId());
		} 
		return false;
	}
	

	@PrePersist
	public void prePersist(){
		for(Option option:options){
			option.setQuestion(this);
		}
		
		for(Response response:responses){
			response.getResponseId().setQuestion(this);
		}
		
	}

}
