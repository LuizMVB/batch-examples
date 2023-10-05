package br.com.example.demo.batchexamples.proccessor;

import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImparOuParProccessorConfiguration {

    @Bean
    public FunctionItemProcessor<Integer, String> imparOuParProccessor() {
        return new FunctionItemProcessor<>(this::processar);
    }

    private String processar(Integer item) {
        if(item % 2 == 0) {
            return "Par, o mundo é belo e o número é " + item;
        }

        return "Impar, o mundo é cruel e o número é " + item;
    }

}
