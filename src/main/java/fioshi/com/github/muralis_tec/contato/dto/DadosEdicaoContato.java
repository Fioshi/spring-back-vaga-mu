package fioshi.com.github.muralis_tec.contato.dto;

import fioshi.com.github.muralis_tec.contato.domain.TipoContato;

public record DadosEdicaoContato(
        Long id,
        TipoContato tipoContato,
        String valor,
        String observacao
) {
}
