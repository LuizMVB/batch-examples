package br.com.example.demo.batchexamples.reader;

import br.com.example.demo.batchexamples.domain.Parceiro;
import br.com.example.demo.batchexamples.domain.Seguro;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.*;

@RequiredArgsConstructor
public class ArquivoSegurosDelimitedMultipleParceiroReader implements ItemStreamReader<Seguro> {

    private Object objAtual;
    private ItemStreamReader<Object> delegate;

    public ArquivoSegurosDelimitedMultipleParceiroReader(ItemStreamReader<Object> delegate) {
        this.delegate = delegate;
    }

    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {
        delegate.open(executionContext);
    }

    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {
        delegate.update(executionContext);
    }

    @Override
    public void close() throws ItemStreamException {
        delegate.close();
    }

    @Override
    public Seguro read() throws Exception {
        if (objAtual == null)
            objAtual = delegate.read();

        Seguro seguro = (Seguro) objAtual;
        objAtual = null;

        if (seguro != null) {
            while (peek() instanceof Parceiro)
                seguro.addParceiro((Parceiro) objAtual);
        }
        return seguro;
    }

    private Object peek() throws Exception {
        objAtual = delegate.read();
        return objAtual;
    }

}
