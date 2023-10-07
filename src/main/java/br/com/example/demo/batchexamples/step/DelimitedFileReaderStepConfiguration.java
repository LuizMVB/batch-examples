package br.com.example.demo.batchexamples.step;

import br.com.example.demo.batchexamples.domain.Seguro;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DelimitedFileReaderStepConfiguration {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step delimitedFileReaderStep(
            @Qualifier("delimitedFileReaderReader")ItemReader<Seguro> reader,
            @Qualifier("delimitedFileReaderWriter")ItemWriter<Seguro> writer) {
        return stepBuilderFactory
                .get("delimitedFileReaderStep")
                .<Seguro, Seguro>chunk(10)
                .reader(reader)
                .writer(writer)
                .build();
    }

}
