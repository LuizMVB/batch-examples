package br.com.example.demo.batchexamples.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WriterConfiguration {

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Bean
    public ItemWriter writer() {
        return item -> item.forEach(System.out::println);
    }

}
