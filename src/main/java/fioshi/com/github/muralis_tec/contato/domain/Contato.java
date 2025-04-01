package fioshi.com.github.muralis_tec.contato.domain;

import fioshi.com.github.muralis_tec.cliente.domain.Cliente;
import fioshi.com.github.muralis_tec.contato.dto.DadosCadastroContato;
import fioshi.com.github.muralis_tec.contato.dto.DadosEdicaoContato;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "tb_contato")
@EqualsAndHashCode(of = "id")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false, length = 50)
    private TipoContato tipoContato;

    @Column(name = "valor", nullable = false, length = 100)
    private String valor;

    @Column(name = "observacao", length = 255)
    private String observacao;

    public Long getId() {
        return id;
    }

    public String getObservacao() {
        return observacao;
    }

    public String getValor() {
        return valor;
    }

    public TipoContato getTipoContato() {
        return tipoContato;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Contato() {
    }

    public Contato(DadosCadastroContato dtoCadastro, Cliente cliente) {
        this.cliente = cliente;
        this.tipoContato = dtoCadastro.tipoContato();
        this.valor = dtoCadastro.valor();
        this.observacao = dtoCadastro.observacao();
    }

    public void atualizar(DadosEdicaoContato dtoEdicao) {
        if (dtoEdicao.tipoContato() != null)
            this.tipoContato = dtoEdicao.tipoContato();
        if (dtoEdicao.valor() != null)
            this.valor = dtoEdicao.valor();
        if (dtoEdicao.observacao() != null)
            this.observacao = dtoEdicao.observacao();
    }
}
