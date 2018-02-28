package com.marketsurvey.example.repository;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc 
public class SurveyRepositoryTest {
	
	 @Autowired
	  private MockMvc mockMvc;
	 
	
	 @Test
	 public void createSurveywithQuestions() throws Exception{
	   String content = "{\"name\": \"ProductSurvey\", \"questions\": [\"/questions/3\",\"/questions/4\"]}";
	     mockMvc.perform(MockMvcRequestBuilders.post("/surveys").contentType(MediaType.APPLICATION_JSON).content(content)).andExpect(status().isCreated());
	    System.out.println("The survey is +++++++++ " + mockMvc.perform(MockMvcRequestBuilders.get("/surveys/1").contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse().getContentAsString());
	 }
	 
	 /*@Test
	 public void respondToSurvey() throws Exception{
		 
		 mockMvc.perform(MockMvcRequestBuilders.post("/respondents").contentType(MediaType.APPLICATION_JSON).content("{\"name\": \"John Smith\"}")).andExpect(status().isCreated());
	    //String s=  "{ \"options\": [{\"optionText\": \"Strongly Agree\"}],\"question\": \"DO you agree that the product has increased your productivity\" }";
	   String content = "{\"name\": \"ProductSurvey\", \"questions\": [\"http://localhost:8080/questions/3\",\"http://localhost:8080/questions/4\"]}";
	     mockMvc.perform(MockMvcRequestBuilders.post("/surveys").contentType(MediaType.APPLICATION_JSON).content(content).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
	     
	 }*/

}
