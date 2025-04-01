package fioshi.com.github.muralis_tec.cliente.service;

import fioshi.com.github.muralis_tec.cliente.dto.DadosCadastroCliente;
import fioshi.com.github.muralis_tec.cliente.dto.DadosEdicaoCliente;
import fioshi.com.github.muralis_tec.cliente.dto.DadosListagemCliente;

import java.util.List;

public interface ClienteService {

    void cadastroCliente(DadosCadastroCliente dtoCadastro);
    void edicaoCliente(Long id ,DadosEdicaoCliente dtoEdicao);
    void exclusaoCliente(Long id);
    List<DadosListagemCliente> listagemCliente();
    List<DadosListagemCliente> buscaClienteFiltrada(String keyword);

    DadosListagemCliente buscaCliente(Long id);
}
