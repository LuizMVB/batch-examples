package br.com.example.demo.batchexamples.writer;

import br.com.example.demo.batchexamples.domain.Seguro;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FixedLengthFileReaderWriterConfiguration {

    @Bean
    public ItemWriter<Seguro> fixedLengthFileReaderWriter() {
        return items -> items.forEach(System.out::println);
    }
}
