package br.com.example.demo.batchexamples.reader;

import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class ImparOuParReaderConfiguration {

    @Bean
    public IteratorItemReader<Integer> imparOuParReader() {
        List<Integer> numerosDeUmAteDez = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        return new IteratorItemReader<>(numerosDeUmAteDez.iterator());
    }

}
