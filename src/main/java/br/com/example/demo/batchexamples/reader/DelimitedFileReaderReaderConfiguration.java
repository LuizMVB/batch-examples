package br.com.example.demo.batchexamples.reader;

import br.com.example.demo.batchexamples.domain.Seguro;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class DelimitedFileReaderReaderConfiguration {

    @Bean
    @StepScope
    public FlatFileItemReader<Seguro> delimitedFileReaderReader(
            @Value("#{jobParameters['arquivoSegurosDelimited']}") Resource resource) {
        return new FlatFileItemReaderBuilder<Seguro>()
                .name("delimitedFileReaderReader")
                .resource(resource)
                .delimited()
                .names("id", "nome", "tipo")
                .targetType(Seguro.class)
                .build();
    }

}
