package br.com.example.demo.batchexamples.reader;

import br.com.example.demo.batchexamples.domain.Seguro;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.database.builder.JdbcPagingItemReaderBuilder;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import javax.sql.DataSource;

@Configuration
public class ReaderConfiguration {

    @Bean
    public PagingQueryProvider pagingQueryProvider(DataSource dataSource) throws Exception {
        SqlPagingQueryProviderFactoryBean provider = new SqlPagingQueryProviderFactoryBean();
        provider.setDataSource(dataSource);
        provider.setSelectClause("SELECT * ");
        provider.setFromClause("FROM seguro ");
        provider.setSortKey("id");
        return provider.getObject();
    }

    @Bean
    public JdbcPagingItemReader<Seguro> reader(DataSource dataSource,
                                               PagingQueryProvider pagingQueryProvider) {
        return new JdbcPagingItemReaderBuilder<Seguro>()
                .name("reader")
                .dataSource(dataSource)
                .queryProvider(pagingQueryProvider)
                .pageSize(2)
                .rowMapper(new BeanPropertyRowMapper<>(Seguro.class))
                .build();
    }

}
