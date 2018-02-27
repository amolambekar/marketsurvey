package com.marketsurvey.example.repository;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashSet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marketsurvey.example.domain.Option;
import com.marketsurvey.example.domain.Question;


@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc 
public class QuestionRepositoryTest {
	
	 @Autowired
	  private MockMvc mockMvc;
	

    @Test
    public void addQuestionWithOptionsTest() throws Exception {
    ObjectMapper objectMapper = new ObjectMapper();
/*    	String content ="{ \"options\": [{\"optionText\": \"Strongly Agree\"}],\"question\": \"DO you agree that the product has increased your productivity\" }";
    	mockMvc.perform(MockMvcRequestBuilders.post("/questions/").contentType(MediaType.APPLICATION_JSON).content(content)).andExpect(status().isCreated());
*/              Question question =new Question("DO you agree that the product has increased your productivity",null);
    		
    	    	HashSet<Option> options = new HashSet<>();
    	    	Option option1 = new Option();
    	    	option1.setOptionText("Strongly Agree");
    	    	options.add(option1);
    	    	Option option2 = new Option();
    	    	option2.setOptionText("Agree");
    	    	options.add(option2);
    	    	Option option3 = new Option();
    	    	option3.setOptionText("Neither agree not disagree");
    	    	options.add(option3);
    	    	Option option4 = new Option();
    	    	option4.setOptionText("disagree");
    	    	options.add(option4);
    	    	Option option5 = new Option();
    	    	option5.setOptionText("Strongly disagree");
    	    	options.add(option5);
    	    	question.setOptions(options);
     	    	mockMvc.perform(MockMvcRequestBuilders.post("/questions/").contentType(MediaType.APPLICATION_JSON)
    	    			.content(objectMapper.writeValueAsString(question))).andExpect(status().isCreated());
    	    	String result = mockMvc.perform(MockMvcRequestBuilders.get("/questions/5/options").contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse().getContentAsString();
    	    	 assertTrue(result!=null && result.length()>0);  
    	
    	
    }
    
    @Test
    public void ReadSingleQuestionWithOptionsTest() throws Exception {
    	  mockMvc.perform(MockMvcRequestBuilders.get("/questions/2").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    	
    }
    
    @Test
    public void RemoveQuestionWithOptionsTest() throws Exception {
    	mockMvc.perform(MockMvcRequestBuilders.delete("/questions/3").contentType(MediaType.APPLICATION_JSON));
    	 mockMvc.perform(MockMvcRequestBuilders.get("/questions/3").contentType(MediaType.APPLICATION_JSON)).andExpect(status().is(404));
  
    }
    
    @Test
    public void ReadListOfAllQuestions() throws Exception {
    	String result = mockMvc.perform(MockMvcRequestBuilders.get("/questions").contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse().getContentAsString();
    	System.out.println(result);
    	 assertTrue(result!=null && result.length()>0);  
    }
    
    @Test
    public void EditQuestionWithOptionsTest() throws Exception {
    	String content ="{ \"questionId\":5,\"question\": \"DO you agree that the product has sharply increased your productivity\" }";
    	 mockMvc.perform(MockMvcRequestBuilders.put("/questions/5").contentType(MediaType.APPLICATION_JSON).content(content)).andExpect(status().isCreated());
    	 String result = mockMvc.perform(MockMvcRequestBuilders.get("/questions/5").contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse().getContentAsString();
    	 assertTrue(result!=null && result.length()>0);   	
    	
    }

}
