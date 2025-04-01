package fioshi.com.github.muralis_tec.contato.service;

import fioshi.com.github.muralis_tec.contato.dto.DadosCadastroContato;
import fioshi.com.github.muralis_tec.contato.dto.DadosEdicaoContato;
import fioshi.com.github.muralis_tec.contato.dto.DadosListagemContato;

import java.util.List;

public interface ContatoService {

    void cadastroContato(DadosCadastroContato dtoCadastro);
    void editarContato(DadosEdicaoContato dtoEdicao);
    void exclusaoContato(Long id);
    List<DadosListagemContato> listagemContato(Long id);

    DadosListagemContato buscarContato(Long id);
}
