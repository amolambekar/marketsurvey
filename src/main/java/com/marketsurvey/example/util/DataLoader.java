package com.marketsurvey.example.util;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.marketsurvey.example.domain.Option;
import com.marketsurvey.example.domain.Question;
import com.marketsurvey.example.domain.Respondent;
import com.marketsurvey.example.domain.Survey;
import com.marketsurvey.example.domain.SurveyResponse;
import com.marketsurvey.example.repository.RespondentRepository;
import com.marketsurvey.example.repository.SurveyRepository;

@Component
public class DataLoader implements ApplicationRunner {

    private SurveyRepository surveyRepository;
	private RespondentRepository respondentRepository;

    @Autowired
    public DataLoader(SurveyRepository surveyRepository,RespondentRepository respondentRepository) {
        this.surveyRepository = surveyRepository;
        this.respondentRepository=respondentRepository;
    }

    public void run(ApplicationArguments args) {
    	Survey survey = new Survey("productSurvey",null,null);
        
       	SurveyResponse surveyResponse = new SurveyResponse();
       	surveyResponse.setSurvey(survey);
    	//surveyRepository.save(new User("lala", "lala", "lala"));
    	HashSet<Question> questionSet = new HashSet<>();
    	Question question1 = new Question("what is your first reaction to the product",null); 
    	HashSet<Option> options = new HashSet<>();
    	Option option1 = new Option();
    	option1.setOptionText("very positive");
    	option1.setQuestion(question1);
    	options.add(option1);
    	Option option2 = new Option();
    	option2.setOptionText("positive");
    	options.add(option2);
    	option2.setQuestion(question1);
    	Option option3 = new Option();
    	option3.setOptionText("somewhat positive");
    	option3.setQuestion(question1);
    	options.add(option3);
    	Option option4 = new Option();
    	option4.setOptionText("neutral");
    option4.setQuestion(question1);
    	options.add(option4);
    	Option option5 = new Option();
    	option5.setOptionText("somewhat negative");
    	option5.setQuestion(question1);
    	options.add(option5);
    	Option option6 = new Option();
    	option6.setQuestion(question1);
    	option6.setOptionText("very negative");
    	options.add(option6);
    	question1.setOptions(options);

    	Question question2 = new Question("how would you rate the quality of the product",null);
    	question1.setOptions(options);
    	questionSet.add(question1);
    	HashSet<Option> question2Options = new HashSet<>();
    	 option1 = new Option();
    	option1.setOptionText("very high quality");
    	option1.setQuestion(question2);
    	question2Options.add(option1);
    	 option2 = new Option();
    	option2.setOptionText("high quality");
    	option2.setQuestion(question2);
    	question2Options.add(option2);
    	 option3 = new Option();
    	option3.setOptionText("average quality");
    	option3.setQuestion(question2);
    	question2Options.add(option3);
    	 option4 = new Option();
    	option4.setOptionText("neutral on quality");
    	option4.setQuestion(question2);
    	question2Options.add(option4);
    	 option5 = new Option();
    	option5.setOptionText("low Quality");
    	option5.setQuestion(question2);
    	question2Options.add(option5);
    	 option6 = new Option();
    	option6.setOptionText("very poor quality");
    	question2Options.add(option6);
    	option6.setQuestion(question2);
    	
    	question2.setOptions(question2Options);
    	questionSet.add(question2);
       	Question question3 = new Question("how would you rate value for money of the product",null);
       	question3.setOptions(options);
       	questionSet.add(question3);
    	Question question4 = new Question("how likely are you to replace your current product with the new product",null);
    	question4.setOptions(question2Options);
    	questionSet.add(question4);
        survey.setQuestions(questionSet);
       	Respondent respondent = new Respondent();
       	respondent.setName("John");
    	respondentRepository.save(respondent);
        	surveyRepository.save(survey);
       	
    }
}