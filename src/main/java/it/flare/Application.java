package it.flare;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	 static final Logger log = LoggerFactory.getLogger(Application.class);

    
	public static void main(String[] args) {
         log.info("let us start");
		SpringApplication.run(Application.class, args);
        
	}
}
