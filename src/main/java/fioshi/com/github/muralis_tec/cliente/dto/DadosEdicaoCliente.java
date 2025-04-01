package fioshi.com.github.muralis_tec.cliente.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Date;

public record DadosEdicaoCliente(
        Long id,
        String nome,
        String cpf,
        LocalDate dataNascimento,
        String endereco
) {
}
