package br.com.example.demo.batchexamples.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.builder.MultiResourceItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class MultiplosArquivosDeMultiplosFormatosReaderReaderConfiguration {


    @SuppressWarnings({"rawtypes", "unchecked"})
    @Bean
    @StepScope
    public MultiResourceItemReader multiplosArquivosDeMultiplosFormatosReaderReader(
            @Value("#{jobParameters['arquivosSegurosMultipleList']}")Resource[] resourceList,
            @Qualifier("multipleFormatFileReaderReader") FlatFileItemReader flatFileItemReader) {
        return new MultiResourceItemReaderBuilder<>()
                .name("multiplosArquivosDeMultiplosFormatosReaderReader")
                .resources(resourceList)
                .delegate(new ArquivoSegurosDelimitedMultipleParceiroReader(flatFileItemReader))
                .build();

    }

}
