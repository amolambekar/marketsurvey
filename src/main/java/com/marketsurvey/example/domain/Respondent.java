package com.marketsurvey.example.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Respondent implements Serializable {

	private static final long serialVersionUID = 3280760468657272376L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long respondentId;

	@Column
	private String name;

	
	  
	  @OneToMany(mappedBy = "surveyResponseId") 
	  private Set<SurveyResponse> surveyResponses = new HashSet<>();
	 

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object object) {
		if (object != null && object instanceof Respondent) {

			return this.respondentId.equals(((Respondent) object).getRespondentId());
		}
		return false;
	}
	
	
	@PrePersist
	public void prePersist(){
		for(SurveyResponse surveyResponse :surveyResponses){
			surveyResponse.setRespondentId(this);
		}
	}

}
