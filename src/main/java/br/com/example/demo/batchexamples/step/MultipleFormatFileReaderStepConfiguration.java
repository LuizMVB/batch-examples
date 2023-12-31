package br.com.example.demo.batchexamples.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MultipleFormatFileReaderStepConfiguration {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Bean
    public Step multipleFormatFileReaderStep(
            @Qualifier("multipleFormatFileReaderReader") FlatFileItemReader reader,
            @Qualifier("multipleFormatFileReaderWriter") ItemWriter writer) {
        return stepBuilderFactory
                .get("multipleFormatFileReaderStep")
                .chunk(2)
                .reader(reader)
                .writer(writer)
                .build();
    }

}
