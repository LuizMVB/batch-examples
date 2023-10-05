package br.com.example.demo.batchexamples.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OlaMundoCruelStepConfiguration {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step olaMundoCruelStep() {
        return stepBuilderFactory
                .get("olaMundoCruelStep")
                .tasklet((stepContribution, chunkContext) -> {
                    System.out.println("Olá, mundo cruel!");
                    return RepeatStatus.FINISHED;
                })
                .build();
    }

}
