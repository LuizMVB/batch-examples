package br.com.example.demo.batchexamples.writer;

import br.com.example.demo.batchexamples.domain.Seguro;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WriterConfiguration {

    @Bean
    public ItemWriter<Seguro> writer() {
        return list -> list.forEach(System.out::println);
    }

}
