package com.classwebbeta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;

@SpringBootApplication
public class ClassWebBetaApplication {
	// Main run the Spring Boot App
	public static void main(String[] args) {

		SpringApplication.run(ClassWebBetaApplication.class, args);
		try {
			openHomePage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// Open the browser at Login URL
	private static void openHomePage() throws IOException{
	    Runtime rt = Runtime.getRuntime();
	    rt.exec("rundll32 url.dll,FileProtocolHandler " + "http://localhost:8080/login");
	}

}
