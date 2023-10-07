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
    private List<Parceiro> parceiros = new ArrayList<>();

    public void addParceiro(Parceiro parceiro) {
        if(CollectionUtils.isEmpty(parceiros))
            parceiros = new ArrayList<>();
        parceiros.add(parceiro);
    }

}
