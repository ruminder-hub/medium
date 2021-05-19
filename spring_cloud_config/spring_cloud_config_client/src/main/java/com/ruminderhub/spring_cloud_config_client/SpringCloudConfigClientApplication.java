package com.ruminderhub.spring_cloud_config_client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController("/")
public class SpringCloudConfigClientApplication {

	@Value("${database}")
	private String database;

	private static Logger log = LoggerFactory.getLogger(SpringCloudConfigClientApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigClientApplication.class, args);
	}

	@GetMapping("log")
	public void printLoggingLevel() {
		// Will print all logs if active profile is development else will print only info level
		log.info("Printing logs with info level");
		log.debug("Printing logs of debug level as well");
		log.info("Database we are using is {}", database);
	}

}
