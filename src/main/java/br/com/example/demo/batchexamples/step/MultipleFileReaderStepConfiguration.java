package br.com.example.demo.batchexamples.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MultipleFileReaderStepConfiguration {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Bean
    public Step multipleFileReaderStep(
            @Qualifier("multipleFileReaderReader")ItemReader reader,
            @Qualifier("multipleFileReaderWriter")ItemWriter writer) {
        return stepBuilderFactory
                .get("multipleFileReaderStep")
                .chunk(10)
                .reader(reader)
                .writer(writer)
                .build();
    }

}
