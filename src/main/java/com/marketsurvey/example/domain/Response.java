package com.marketsurvey.example.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Response implements Serializable{
	

	private static final long serialVersionUID = 323270143338199384L;
	
	@Id
	private ResponseId responseId;
	private  String comment;
	
	
		
	@Override
	public int hashCode(){
	 return super.hashCode();	
	}
	
	@Override
	public boolean equals(Object object){
		if(object!=null && object instanceof Response ){

	 return this.responseId.equals(((Response)object).getResponseId());
		} 
		return false;
	}
	

}
