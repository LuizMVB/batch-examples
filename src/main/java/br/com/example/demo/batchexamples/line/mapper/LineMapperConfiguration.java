package br.com.example.demo.batchexamples.line.mapper;

import br.com.example.demo.batchexamples.domain.Parceiro;
import br.com.example.demo.batchexamples.domain.Seguro;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.mapping.PatternMatchingCompositeLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class LineMapperConfiguration {

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Bean
    public PatternMatchingCompositeLineMapper lineMapper() {
        var lineMapper = new PatternMatchingCompositeLineMapper();
        lineMapper.setTokenizers(getTokenizers());
        lineMapper.setFieldSetMappers(getFieldSetMappers());
        return lineMapper;
    }

    private Map<String, LineTokenizer> getTokenizers() {
        var tokenizers = new HashMap<String, LineTokenizer>();
        tokenizers.put("0*", getSeguroTokenizer());
        tokenizers.put("1*", getParceiroTokenizer());
        return tokenizers;
    }

    private LineTokenizer getSeguroTokenizer() {
        var lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setNames("id", "nome", "tipo");
        lineTokenizer.setIncludedFields(1, 2, 3);
        return lineTokenizer;
    }

    private LineTokenizer getParceiroTokenizer() {
        var lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setNames("id", "nome");
        lineTokenizer.setIncludedFields(1, 2);
        return lineTokenizer;
    }

    @SuppressWarnings("rawtypes")
    private Map<String, FieldSetMapper> getFieldSetMappers() {
        var fieldSetMappers = new HashMap<String, FieldSetMapper>();
        fieldSetMappers.put("0*", getFieldSetMapper(Seguro.class));
        fieldSetMappers.put("1*", getFieldSetMapper(Parceiro.class));
        return fieldSetMappers;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private FieldSetMapper getFieldSetMapper(Class clazz) {
        var fieldSetMapper = new BeanWrapperFieldSetMapper();
        fieldSetMapper.setTargetType(clazz);
        return fieldSetMapper;
    }

}
