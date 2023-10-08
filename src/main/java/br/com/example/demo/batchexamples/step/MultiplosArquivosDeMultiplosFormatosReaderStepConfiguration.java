package br.com.example.demo.batchexamples.step;

import br.com.example.demo.batchexamples.domain.Seguro;
import br.com.example.demo.batchexamples.reader.ArquivoSegurosDelimitedMultipleParceiroReader;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MultiplosArquivosDeMultiplosFormatosReaderStepConfiguration {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Bean
    public Step multiplosArquivosDeMultiplosFormatosReaderStep(
            @Qualifier("multiplosArquivosDeMultiplosFormatosReaderReader")MultiResourceItemReader<Seguro> reader,
            @Qualifier("multiplosArquivosDeMultiplosFormatosReaderWriter")ItemWriter writer) {
        return stepBuilderFactory
                .get("multiplosArquivosDeMultiplosFormatosReaderWriter")
                .chunk(3)
                .reader(reader)
                .writer(writer)
                .build();
    }

}
