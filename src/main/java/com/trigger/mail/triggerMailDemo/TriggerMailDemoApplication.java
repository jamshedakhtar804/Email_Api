package com.trigger.mail.triggerMailDemo;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TriggerMailDemoApplication {
	private static final Logger AppLog=Logger.getLogger(TriggerMailDemoApplication.class);
	/*{
		BasicConfigurator.configure();
	}*/
	public static void main(String[] args) {
		SpringApplication.run(TriggerMailDemoApplication.class, args);
		AppLog.info("Success");

	}

}
