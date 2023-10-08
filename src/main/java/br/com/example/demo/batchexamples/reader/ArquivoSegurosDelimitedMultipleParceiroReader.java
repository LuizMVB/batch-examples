package br.com.example.demo.batchexamples.reader;

import br.com.example.demo.batchexamples.domain.Parceiro;
import br.com.example.demo.batchexamples.domain.Seguro;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.*;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.ResourceAwareItemReaderItemStream;
import org.springframework.core.io.Resource;

@RequiredArgsConstructor
public class ArquivoSegurosDelimitedMultipleParceiroReader implements ItemStreamReader<Seguro>, ResourceAwareItemReaderItemStream<Seguro> {

    private Object objAtual;
    private FlatFileItemReader<Object> delegate;

    public ArquivoSegurosDelimitedMultipleParceiroReader(FlatFileItemReader<Object> delegate) {
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

    @Override
    public void setResource(Resource resource) {
        delegate.setResource(resource);
    }
}
