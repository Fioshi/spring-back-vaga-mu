package fioshi.com.github.muralis_tec.cliente.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosCadastroCliente(
        @NotBlank
        String nome,
        @NotBlank
        String cpf,
        LocalDate dataNascimento,
        String endereco
) {
}
