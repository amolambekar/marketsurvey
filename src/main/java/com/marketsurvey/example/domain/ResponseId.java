package com.marketsurvey.example.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
public class ResponseId  implements Serializable{

	private static final long serialVersionUID = 6065686599477756635L;
	

	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name ="surveyResponseId")
	private SurveyResponse surveyResponse;
	
	@JsonBackReference(value="surveyResponse")
	public SurveyResponse getSurveyResponse(){
		return this.surveyResponse;
	}
	
	 
	 @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name ="questionId")
	private Question question; 
    
	 
	 @JsonBackReference(value="question")
	public Question getQuestion(){
		return this.question;
	}
    
	
   @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name ="optionId")
	private Option answer;
   
   @JsonBackReference(value="answer")
  	public Option getOption(){
  		return this.answer;
  	}
   
   public ResponseId(SurveyResponse surveyResponse,Question question,Option answer){
	   this.surveyResponse= surveyResponse;
	   this.question=question;
	   this.answer=answer;
   }
   
   @Override
	public int hashCode(){
	 return super.hashCode();	
	}
	
	@Override
	public boolean equals(Object object){
		if(object!=null && object instanceof ResponseId ){
      ResponseId responseId = (ResponseId)object;
	 return this.surveyResponse.equals(responseId.getSurveyResponse()) && this.question.equals(responseId.getQuestion()) && this.answer.equals(responseId.getAnswer());
		} 
		return false;
	}
	
	@Override
	public String toString(){
		return ""+this.surveyResponse.getSurvey().getSurveyId()+this.question.getQuestionId()+this.answer.getOptionId();
	
	}
    	

}
