package br.com.example.demo.batchexamples.step;

import br.com.example.demo.batchexamples.reader.AgregadorDeParceirosAoSeguroReader;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StepConfiguration {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Bean
    public Step step(FlatFileItemReader reader,
                     ItemWriter writer) {
        return stepBuilderFactory
                .get("step")
                .chunk(10)
                .reader(new AgregadorDeParceirosAoSeguroReader(reader))
                .writer(writer)
                .build();
    }

}
