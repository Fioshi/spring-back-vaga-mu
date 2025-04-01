package fioshi.com.github.muralis_tec.cliente.controller;

import fioshi.com.github.muralis_tec.cliente.dto.DadosCadastroCliente;
import fioshi.com.github.muralis_tec.cliente.dto.DadosEdicaoCliente;
import fioshi.com.github.muralis_tec.cliente.dto.DadosListagemCliente;
import fioshi.com.github.muralis_tec.cliente.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    private ResponseEntity<String> cadastrar(@RequestBody DadosCadastroCliente dtoCadastro){
        clienteService.cadastroCliente(dtoCadastro);
        return ResponseEntity.ok("Cadastrado com sucesso");
    }

    @PatchMapping("{id}")
    public ResponseEntity<String> atualizarCliente(@PathVariable Long id, @RequestBody DadosEdicaoCliente dtoEdicao) {
        System.out.println(id);
        clienteService.edicaoCliente(id ,dtoEdicao);
        return ResponseEntity.ok().body("Editado com sucesso");
    }

    @DeleteMapping("{id}")
    private ResponseEntity<String> deletar(@PathVariable Long id){
        clienteService.exclusaoCliente(id);
        return ResponseEntity.ok().body("Deletado com sucesso");
    }

    @GetMapping("{id}")
    private ResponseEntity<DadosListagemCliente> buscarUm(@PathVariable Long id){
        return ResponseEntity.ok().body(clienteService.buscaCliente(id));
    }

    @GetMapping
    private ResponseEntity<List<DadosListagemCliente>> listar(){
        return ResponseEntity.ok().body(clienteService.listagemCliente());
    }

    @GetMapping("/busca")
    public ResponseEntity<List<DadosListagemCliente>> buscarFiltrado(@RequestParam("keyword") String keyword) {
        var funcionarios = clienteService.buscaClienteFiltrada(keyword);
        return ResponseEntity.ok(funcionarios);
    }
}
