package br.com.example.demo.batchexamples.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MultipleFormatFileReaderWriterConfiguration {

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Bean
    public ItemWriter multipleFormatFileReaderWriter() {
        return item -> item.forEach(System.out::println);
    }

}
