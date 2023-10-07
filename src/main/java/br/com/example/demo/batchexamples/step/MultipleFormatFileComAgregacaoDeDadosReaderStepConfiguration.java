package br.com.example.demo.batchexamples.step;

import br.com.example.demo.batchexamples.reader.ArquivoSegurosDelimitedMultipleParceiroReader;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MultipleFormatFileComAgregacaoDeDadosReaderStepConfiguration {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Bean
    public Step multipleFormatFileComAgregacaoDeDadosReaderStep(
            @Qualifier("multipleFormatFileReaderReader") FlatFileItemReader reader,
            @Qualifier("multipleFormatFileReaderWriter") ItemWriter writer) {
        return stepBuilderFactory
                .get("multipleFormatFileComAgregacaoDeDadosReaderStep")
                .chunk(10)
                .reader(new ArquivoSegurosDelimitedMultipleParceiroReader(reader))
                .writer(writer)
                .build();
    }

}
