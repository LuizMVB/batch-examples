package br.com.example.demo.batchexamples.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LeituraDeFlatFileDelimitedComMultiplosFormatosStepConfiguration {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Bean
    public Step leituraDeFlatFileDelimitedComMultiplosFormatosStep(ItemReader reader,
                                                                   ItemWriter writer) {
        return stepBuilderFactory
                .get("leituraDeFlatFileDelimitedComMultiplosFormatosStep")
                .chunk(2)
                .reader(reader)
                .writer(writer)
                .build();
    }

}
