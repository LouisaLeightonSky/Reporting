package com.bskyb.gdm.batch.reporting.configuration;


import com.bskyb.gdm.batch.reporting.business.ExportData;
import com.bskyb.gdm.batch.reporting.business.ImportData;
import com.bskyb.gdm.batch.reporting.business.ImportDataImpl;

import com.bskyb.gdm.batch.reporting.model.LogResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class JobConfiguration {
    Logger logger = LoggerFactory.getLogger(JobConfiguration.class);
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private ImportData importData;

    @Autowired
    private ExportData exportData;

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
                        logger.debug("This is a debug message");
                        LogResponse logResponse=(importData.parseResponse("activities"));
                        exportData.writeFileForUpload(logResponse.getResults());
                        return RepeatStatus.FINISHED;
                    }
                }).build();
    }

    @Bean
    public Job UserReportingJob() {
        logger.debug("This is start of the job");
        logger.info("This is start of the job");
        return jobBuilderFactory.get("UserReportingJob")
                .start(step1())
                .build();
    }
}

