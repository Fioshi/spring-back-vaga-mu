package fioshi.com.github.muralis_tec.cliente.service;

import fioshi.com.github.muralis_tec.cliente.domain.Cliente;
import fioshi.com.github.muralis_tec.cliente.dto.DadosCadastroCliente;
import fioshi.com.github.muralis_tec.cliente.dto.DadosEdicaoCliente;
import fioshi.com.github.muralis_tec.cliente.dto.DadosListagemCliente;
import fioshi.com.github.muralis_tec.cliente.repository.ClienteRepository;
import fioshi.com.github.muralis_tec.contato.repository.ContatoRepository;
import fioshi.com.github.muralis_tec.contato.service.ContatoService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ClienteServiceImp implements ClienteService{

    private final ClienteRepository clienteRepository;
    private final ContatoRepository contatoRepository;

    public ClienteServiceImp(ClienteRepository clienteRepository, ContatoRepository contatoRepository, ContatoService contatoService) {
        this.clienteRepository = clienteRepository;
        this.contatoRepository = contatoRepository;
    }

    @Override
    public void cadastroCliente(DadosCadastroCliente dtoCadastro) {
        var cliente = new Cliente(dtoCadastro);
        clienteRepository.save(cliente);
    }

    @Override
    public void edicaoCliente(Long id ,DadosEdicaoCliente dtoEdicao) {
        if (!clienteRepository.existsById(id))
            throw new RuntimeException("Cliente não encontrado");
        var cliente = clienteRepository.getReferenceById(id);
        cliente.atualizar(dtoEdicao);
        clienteRepository.save(cliente);
    }

    @Override
    public void exclusaoCliente(Long id) {
        if (!clienteRepository.existsById(id))
            throw new RuntimeException("Cliente não encontrado");
        contatoRepository.deleteAllByCliente_Id(id);
        clienteRepository.deleteById(id);
    }

    @Override
    public List<DadosListagemCliente> listagemCliente() {
        return clienteRepository
                .findAll()
                .stream()
                .map(DadosListagemCliente::new)
                .toList();
    }

    @Override
    public List<DadosListagemCliente> buscaClienteFiltrada(String keyword) {
        return clienteRepository
                .searchByNomeOrCpf(keyword)
                .stream()
                .map(DadosListagemCliente::new)
                .toList();
    }

    @Override
    public DadosListagemCliente buscaCliente(Long id) {
        return new DadosListagemCliente(clienteRepository.getReferenceById(id));

    }
}
