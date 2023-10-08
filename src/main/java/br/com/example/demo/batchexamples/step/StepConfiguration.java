package br.com.example.demo.batchexamples.step;

import br.com.example.demo.batchexamples.domain.Seguro;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StepConfiguration {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Bean
    public Step step(MultiResourceItemReader<Seguro> reader,
                     ItemWriter writer) {
        return stepBuilderFactory
                .get("step")
                .chunk(3)
                .reader(reader)
                .writer(writer)
                .build();
    }

}
