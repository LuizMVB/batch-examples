package br.com.example.demo.batchexamples.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImparOuParWriterConfiguration {

    @Bean
    public ItemWriter<String> imparOuParWriter() {
        return list -> list.forEach(System.out::println);
    }

}
