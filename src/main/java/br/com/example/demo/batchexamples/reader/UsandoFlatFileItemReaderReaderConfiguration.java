package br.com.example.demo.batchexamples.reader;

import br.com.example.demo.batchexamples.domain.Seguro;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class UsandoFlatFileItemReaderReaderConfiguration {

    @Bean
    @StepScope
    public FlatFileItemReader<Seguro> usandoFlatFileItemReaderReader(
            @Value("#{jobParameters['arquivoSeguros']}") Resource resource) {
        return new FlatFileItemReaderBuilder<Seguro>()
                .name("usandoFlatFileItemReaderReader")
                .resource(resource)
                .fixedLength()
                .columns(new Range[] {new Range(1, 10), new Range(11, 20), new Range(21, 24)})
                .names("id", "nome", "tipo")
                .targetType(Seguro.class)
                .build();
    }

}
