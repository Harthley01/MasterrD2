package br.com.fiap.challenge.resource;

import br.com.fiap.challenge.dto.request.CadastroRequest;
import br.com.fiap.challenge.dto.request.EnderecoRequest;
import br.com.fiap.challenge.dto.request.FinanceiroRequest;
import br.com.fiap.challenge.dto.request.LoginRequest;
import br.com.fiap.challenge.dto.response.CadastroResponse;
import br.com.fiap.challenge.dto.response.EnderecoResponse;
import br.com.fiap.challenge.dto.response.FinanceiroResponse;
import br.com.fiap.challenge.dto.response.LoginResponse;
import br.com.fiap.challenge.entity.Cadastro;
import br.com.fiap.challenge.entity.Endereco;
import br.com.fiap.challenge.entity.Financeiro;
import br.com.fiap.challenge.entity.Login;
import br.com.fiap.challenge.service.CadastroService;
import br.com.fiap.challenge.service.EnderecoService;
import br.com.fiap.challenge.service.FinanceiroService;
import br.com.fiap.challenge.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cadastro")
public class CadastroResource {

    @Autowired
    private CadastroService cadastroService;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private FinanceiroService financeiroService;

    @Autowired
    private LoginService loginService;

    @GetMapping
    public ResponseEntity<List<CadastroResponse>> findAllCadastros(
            @RequestParam(name = "nome", required = false) String nome) {
        Cadastro cadastro = Cadastro.builder().nome(nome).build();
        ExampleMatcher matcher = ExampleMatcher.matchingAll().withIgnoreNullValues().withIgnoreCase();
        Example<Cadastro> example = Example.of(cadastro, matcher);
        List<Cadastro> encontrados = cadastroService.findAll(example);
        if (encontrados.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<CadastroResponse> resposta = encontrados.stream().map(cadastroService::toResponse).toList();
        return ResponseEntity.ok(resposta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CadastroResponse> findCadastroById(@PathVariable Long id) {
        Cadastro encontrado = cadastroService.findById(id);
        if (encontrado == null) {
            return ResponseEntity.notFound().build();
        }
        CadastroResponse resposta = cadastroService.toResponse(encontrado);
        return ResponseEntity.ok(resposta);
    }

    @Transactional
    @PostMapping
    public ResponseEntity<CadastroResponse> saveCadastro(@RequestBody @Valid CadastroRequest r) {
        Cadastro entity = cadastroService.toEntity(r);
        Cadastro saved = cadastroService.save(entity);
        CadastroResponse resposta = cadastroService.toResponse(saved);
        var uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(saved.getId()).toUri();
        return ResponseEntity.created(uri).body(resposta);
    }

    @GetMapping("/enderecos")
    public ResponseEntity<List<EnderecoResponse>> findAllEnderecos() {
        List<Endereco> encontrados = enderecoService.findAll();
        if (encontrados.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<EnderecoResponse> resposta = encontrados.stream().map(enderecoService::toResponse).toList();
        return ResponseEntity.ok(resposta);
    }

    @GetMapping("/enderecos/{id}")
    public ResponseEntity<EnderecoResponse> findEnderecoById(@PathVariable Long id) {
        Endereco encontrado = enderecoService.findById(id);
        if (encontrado == null) {
            return ResponseEntity.notFound().build();
        }
        EnderecoResponse resposta = enderecoService.toResponse(encontrado);
        return ResponseEntity.ok(resposta);
    }

    @Transactional
    @PostMapping("/enderecos")
    public ResponseEntity<EnderecoResponse> saveEndereco(@RequestBody @Valid EnderecoRequest r) {
        Endereco entity = enderecoService.toEntity(r);
        Endereco saved = enderecoService.save(entity);
        EnderecoResponse resposta = enderecoService.toResponse(saved);
        var uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(saved.getId()).toUri();
        return ResponseEntity.created(uri).body(resposta);
    }

    @GetMapping("/financeiros")
    public ResponseEntity<List<FinanceiroResponse>> findAllFinanceiros() {
        List<Financeiro> encontrados = financeiroService.findAll();
        if (encontrados.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<FinanceiroResponse> resposta = encontrados.stream().map(financeiroService::toResponse).toList();
        return ResponseEntity.ok(resposta);
    }

    @GetMapping("/financeiros/{id}")
    public ResponseEntity<FinanceiroResponse> findFinanceiroById(@PathVariable Long id) {
        Financeiro encontrado = financeiroService.findById(id);
        if (encontrado == null) {
            return ResponseEntity.notFound().build();
        }
        FinanceiroResponse resposta = financeiroService.toResponse(encontrado);
        return ResponseEntity.ok(resposta);
    }

    @Transactional
    @PostMapping("/financeiros")
    public ResponseEntity<FinanceiroResponse> saveFinanceiro(@RequestBody @Valid FinanceiroRequest r) {
        Financeiro entity = financeiroService.toEntity(r);
        Financeiro saved = financeiroService.save(entity);
        FinanceiroResponse resposta = financeiroService.toResponse(saved);
        var uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(saved.getId()).toUri();
        return ResponseEntity.created(uri).body(resposta);
    }

    @Transactional
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> saveLogin(@RequestBody @Valid LoginRequest r) {
        Login entity = loginService.toEntity(r);
        Login saved = loginService.save(entity);
        LoginResponse resposta = loginService.toResponse(saved);
        var uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(saved.getId()).toUri();
        return ResponseEntity.created(uri).body(resposta);
    }
}
