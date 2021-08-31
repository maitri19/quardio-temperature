package com.quardio.temperature;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

// TODO: Auto-generated Javadoc
/**
 * The Class Application.
 */
@SpringBootApplication
public class Application {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private ObjectMapper objectMapper;


	@PostConstruct
	public void setUp() {
	   objectMapper.registerModule(new JavaTimeModule());
	}
}
