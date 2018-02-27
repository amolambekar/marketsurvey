package com.marketsurvey.example.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Response implements Serializable{
	

	private static final long serialVersionUID = 323270143338199384L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
