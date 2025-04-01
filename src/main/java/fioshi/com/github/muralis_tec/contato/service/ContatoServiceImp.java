package fioshi.com.github.muralis_tec.contato.service;

import fioshi.com.github.muralis_tec.cliente.repository.ClienteRepository;
import fioshi.com.github.muralis_tec.contato.domain.Contato;
import fioshi.com.github.muralis_tec.contato.domain.TipoContato;
import fioshi.com.github.muralis_tec.contato.dto.DadosCadastroContato;
import fioshi.com.github.muralis_tec.contato.dto.DadosEdicaoContato;
import fioshi.com.github.muralis_tec.contato.dto.DadosListagemContato;
import fioshi.com.github.muralis_tec.contato.repository.ContatoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ContatoServiceImp implements ContatoService{

    private final ContatoRepository contatoRepository;
    private final ClienteRepository clienteRepository;

    public ContatoServiceImp(ContatoRepository contatoRepository, ClienteRepository clienteRepository) {
        this.contatoRepository = contatoRepository;
        this.clienteRepository = clienteRepository;
    }

    @Override
    public void cadastroContato(DadosCadastroContato dtoCadastro) {
        if (dtoCadastro.tipoContato() == TipoContato.EMAIL) {
            if (!dtoCadastro.valor().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
                throw new RuntimeException("O tipo de contato não condiz com o valor enviado " + dtoCadastro.tipoContato());
            }
        }
        if (dtoCadastro.tipoContato() == TipoContato.TELEFONE) {
            if (!dtoCadastro.valor().matches("^\\+55\\s\\d{2}\\s\\d{5}-\\d{4}$"))
                throw new RuntimeException("O tipo de contato não condiz com o valor enviado " + dtoCadastro.tipoContato());{
            }
        }

        var cliente = clienteRepository.getReferenceById(dtoCadastro.idCliente());
        var contato = new Contato(dtoCadastro, cliente);
        contatoRepository.save(contato);
    }

    @Override
    public void editarContato(DadosEdicaoContato dtoEdicao) {
        if (!contatoRepository.existsById(dtoEdicao.id()))
            throw new RuntimeException("Contato não encontrado");
        var contato = contatoRepository.getReferenceById(dtoEdicao.id());
        contato.atualizar(dtoEdicao);
    }

    @Override
    public void exclusaoContato(Long id) {
        if (!contatoRepository.existsById(id))
            throw new RuntimeException("Contato não encontrado");
        contatoRepository.deleteById(id);
    }

    @Override
    public List<DadosListagemContato> listagemContato(Long id) {
        System.out.println("" + id);
        if (!clienteRepository.existsById(id))
            throw new RuntimeException("Cliente não encontrado");
        return contatoRepository
                .findAllByCliente_Id(id)
                .stream()
                .map(DadosListagemContato::new)
                .toList();
    }

    @Override
    public DadosListagemContato buscarContato(Long id) {
        return new DadosListagemContato(contatoRepository.getReferenceById(id));
    }

}