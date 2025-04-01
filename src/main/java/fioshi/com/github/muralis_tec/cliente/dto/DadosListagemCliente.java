package fioshi.com.github.muralis_tec.cliente.dto;

import fioshi.com.github.muralis_tec.cliente.domain.Cliente;

import java.time.LocalDate;

public record DadosListagemCliente(
        Long id,
        String nome,
        String cpf,
        LocalDate dataNasicmento,
        String endereco
) {
    public DadosListagemCliente(Cliente cliente){
        this(
                cliente.getId(),
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getDataNascimento(),
                cliente.getEndereco()
        );
    }
}
