package com.marketsurvey.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableAutoConfiguration
@EnableSwagger2
@Import({springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration.class})
@PropertySource("classpath:application.properties")
public class MarketsurveyApplication {
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer configs() {
	        return new PropertySourcesPlaceholderConfigurer();
	    }

	public static void main(String[] args) {
		SpringApplication.run(MarketsurveyApplication.class, args);
	}
}
