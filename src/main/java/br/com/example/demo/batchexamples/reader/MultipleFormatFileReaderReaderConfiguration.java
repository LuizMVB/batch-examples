package br.com.example.demo.batchexamples.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class MultipleFormatFileReaderReaderConfiguration {

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Bean
    @StepScope
    public FlatFileItemReader multipleFormatFileReaderReader(
            @Value("#{jobParameters['arquivoSegurosMultiple']}")Resource resource,
            @Qualifier("multipleFormatFileReaderLineMapper")LineMapper lineMapper) {
        return new FlatFileItemReaderBuilder<>()
                .name("multipleFormatFileReaderReader")
                .resource(resource)
                .lineMapper(lineMapper)
                .build();
    }

}
