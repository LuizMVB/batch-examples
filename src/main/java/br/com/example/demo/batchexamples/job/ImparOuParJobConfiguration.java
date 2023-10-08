package br.com.example.demo.batchexamples.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class ImparOuParJobConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Bean
    public Job imparOuParJob(Step step) {
        return jobBuilderFactory
                .get("imparOuParJob")
                .start(step)
                .build();
    }

}
