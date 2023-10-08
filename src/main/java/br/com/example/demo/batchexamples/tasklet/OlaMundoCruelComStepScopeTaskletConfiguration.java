package br.com.example.demo.batchexamples.tasklet;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OlaMundoCruelComStepScopeTaskletConfiguration {

    /**
     * Para que o nome seja recebido como parâmetro externo, este parâmetro
     * deve ser seta como CLI Argument ao rodar o programa
     *
     * @param nome O nome recebido via CLI Argumento
     * @return A tasklet responsável por exibir a mensagem
     * personalizada de "Olá, mundo crue! Meu nome é {nome} e eu sou dev."
     */
    @Bean
    @StepScope
    public Tasklet olaMundoCruelComStepScopeTasklet(
            @Value("#{jobParameters['nome']}") String nome) {
        return (stepContribution, chunkContext) -> {
            System.out.format("Olá, mundo cruel! Meu nome é %s e eu sou dev!\n", nome);
            return RepeatStatus.FINISHED;
        };
    }

}
