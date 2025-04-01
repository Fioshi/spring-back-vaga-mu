package fioshi.com.github.muralis_tec.cliente.domain;

import fioshi.com.github.muralis_tec.cliente.dto.DadosCadastroCliente;
import fioshi.com.github.muralis_tec.cliente.dto.DadosEdicaoCliente;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Entity
@Table(name = "tb_cliente")
@EqualsAndHashCode(of = "id")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "cpf", nullable = false, length = 14, unique = true)
    private String cpf;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "endereco", length = 255)
    private String endereco;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public Cliente() {
    }

    public Cliente(DadosCadastroCliente dtoCadastro) {
        this.nome = dtoCadastro.nome();
        this.cpf = dtoCadastro.cpf();
        this.dataNascimento = dtoCadastro.dataNascimento();
        this.endereco = dtoCadastro.endereco();
    }

    public void atualizar(DadosEdicaoCliente dtoEdicao) {
        if (dtoEdicao.nome() != null)
            this.nome = dtoEdicao.nome();
        if (dtoEdicao.cpf() != null)
            this.cpf = dtoEdicao.cpf();
        if (dtoEdicao.dataNascimento() != null)
            this.dataNascimento = dtoEdicao.dataNascimento();
        if (dtoEdicao.endereco() != null)
            this.endereco = dtoEdicao.endereco();
    }
}
