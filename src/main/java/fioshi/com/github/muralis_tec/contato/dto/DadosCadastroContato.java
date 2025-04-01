package fioshi.com.github.muralis_tec.contato.dto;

import fioshi.com.github.muralis_tec.contato.domain.TipoContato;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroContato(
        @NotNull
        Long idCliente,

        @NotNull
        TipoContato tipoContato,

        @NotNull
        String valor,
        String observacao
) {
}
