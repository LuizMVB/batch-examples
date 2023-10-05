package br.com.example.demo.batchexamples.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class ImparOuParStepConfiguration {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step imparOuParStep(
            @Qualifier("imparOuParReader") IteratorItemReader<Integer> reader,
            @Qualifier("imparOuParProccessor") FunctionItemProcessor<Integer, String> processor,
            @Qualifier("imparOuParWriter") ItemWriter<String> writer) {
        return stepBuilderFactory
                .get("imprimeParImparStep")
                .<Integer, String>chunk(10)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

}
