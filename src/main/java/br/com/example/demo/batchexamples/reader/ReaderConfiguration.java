package br.com.example.demo.batchexamples.reader;

import br.com.example.demo.batchexamples.domain.Seguro;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import javax.sql.DataSource;

@Configuration
public class ReaderConfiguration {

    @Bean
    public JdbcCursorItemReader<Seguro> reader(DataSource dataSource) {
        return new JdbcCursorItemReaderBuilder<Seguro>()
                .name("reader")
                .dataSource(dataSource)
                .sql("SELECT * FROM seguro")
                .rowMapper(new BeanPropertyRowMapper<>(Seguro.class))
                .build();
    }

}
