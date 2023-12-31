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
public class FixedLengthFileReaderStepConfiguration {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step fixedLengthFileReaderStep(
            @Qualifier("fixedLengthFileReaderReader") ItemReader<Seguro> reader,
            @Qualifier("fixedLengthFileReaderWriter") ItemWriter<Seguro> writer
    ) {
        return stepBuilderFactory
                .get("fixedLengthFileReaderStep")
                .<Seguro, Seguro>chunk(10)
                .reader(reader)
                .writer(writer)
                .build();
    }

}
