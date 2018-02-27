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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Option implements Serializable {

	private static final long serialVersionUID = 2757971109308298904L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long optionId;

	@Column
	private String optionText;

	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "questionId")
	private Question question;

	
	public Question getQuestion() {
		return this.question;

	}

	public void setQuestion(Question question) {
		this.question = question;

	}


	@OneToMany(mappedBy = "responseId.answer", cascade = CascadeType.ALL)
	private Set<Response> responses = new HashSet<>();

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object object) {
		if (object != null && object instanceof Option) {

			return this.optionId.equals(((Option) object).getOptionId());
		}
		return false;
	}

	public Option(String optionText) {
		this.optionText = optionText;

	}
	
	@PrePersist
	public void prePersist(){
		for(Response response:responses){
			response.getResponseId().setAnswer(this);
		}
		
	}

}
