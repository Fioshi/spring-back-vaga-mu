package fioshi.com.github.muralis_tec.contato.dto;

import fioshi.com.github.muralis_tec.cliente.domain.Cliente;
import fioshi.com.github.muralis_tec.cliente.dto.DadosListagemCliente;
import fioshi.com.github.muralis_tec.contato.domain.Contato;
import fioshi.com.github.muralis_tec.contato.domain.TipoContato;

public record DadosListagemContato(
        Long id,
        String cliente,
        TipoContato tipoContato,
        String valor,
        String observacao
) {
    public DadosListagemContato(Contato contato){
        this(
                contato.getId(),
                contato.getCliente().getNome(),
                contato.getTipoContato(),
                contato.getValor(),
                contato.getObservacao()
        );
    }
}
