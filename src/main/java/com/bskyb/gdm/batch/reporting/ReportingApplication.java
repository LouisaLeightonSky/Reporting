package com.bskyb.gdm.batch.reporting;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableBatchProcessing
@EnableScheduling
@ComponentScan("com.bskyb.gdm.batch.reporting")
public class ReportingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReportingApplication.class, args);
	}

}
