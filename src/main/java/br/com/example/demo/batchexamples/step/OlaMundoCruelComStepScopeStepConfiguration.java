package br.com.example.demo.batchexamples.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OlaMundoCruelComStepScopeStepConfiguration {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step olaMundoCruelComStepScopeStep(Tasklet tasklet) {
        return stepBuilderFactory
                .get("olaMundoCruelComStepScopeStep")
                .tasklet(tasklet)
                .build();
    }

}
