package com.marketsurvey.example.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
public class ResponseId  implements Serializable{

	private static final long serialVersionUID = 6065686599477756635L;
	
	@JsonBackReference(value="surveyResponse")
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name ="surveyResponseId")
	private SurveyResponse surveyResponse;
	
	
	public SurveyResponse getSurveyResponse(){
		return this.surveyResponse;
	}
	
	 @JsonBackReference(value="question")
	 @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name ="questionId")
	private Question question; 
    
	 
	
	public Question getQuestion(){
		return this.question;
	}
    
	 @JsonBackReference(value="answer")
   @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name ="optionId")
	private Option answer;
   
  	public Option getOption(){
  		return this.answer;
  	}
   
   public ResponseId(SurveyResponse surveyResponse,Question question,Option answer){
	   this.surveyResponse= surveyResponse;
	   this.question=question;
	   this.answer=answer;
   }
    
    	

}
