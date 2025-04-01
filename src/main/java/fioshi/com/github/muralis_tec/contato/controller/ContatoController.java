package fioshi.com.github.muralis_tec.contato.controller;

import fioshi.com.github.muralis_tec.cliente.dto.DadosListagemCliente;
import fioshi.com.github.muralis_tec.contato.dto.DadosCadastroContato;
import fioshi.com.github.muralis_tec.contato.dto.DadosEdicaoContato;
import fioshi.com.github.muralis_tec.contato.dto.DadosListagemContato;
import fioshi.com.github.muralis_tec.contato.service.ContatoService;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/contato")
public class ContatoController {

    private final ContatoService contatoService;

    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @PostMapping
    public ResponseEntity<String> cadastrar(@RequestBody DadosCadastroContato dtoCadastro){
        contatoService.cadastroContato(dtoCadastro);
        return ResponseEntity.ok().body("Cadastrado com sucesso");
    }

    @PatchMapping
    private ResponseEntity<String> atualizar(@RequestBody DadosEdicaoContato dtoEdicao){
        contatoService.editarContato(dtoEdicao);
        return ResponseEntity.ok().body("Atualizado com sucesso");
    }

    @GetMapping("busca/{id}")
    private ResponseEntity<DadosListagemContato> buscarUm(@PathVariable Long id){
        return ResponseEntity.ok().body(contatoService.buscarContato(id));
    }

    @GetMapping("{id}")
    public ResponseEntity<List<DadosListagemContato>> listar(@PathVariable Long id){
        var contatos = contatoService.listagemContato(id);
        return ResponseEntity.ok().body(contatos);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletar (@PathVariable Long id){
        contatoService.exclusaoContato(id);
        return ResponseEntity.ok().body("Deletado com sucesso");
    }
}
