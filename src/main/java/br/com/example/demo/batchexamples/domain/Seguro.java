package br.com.example.demo.batchexamples.domain;

import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Data
public class Seguro {

    private Long id;
    private String nome;
    private String tipo;

}
