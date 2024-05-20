package br.com.fiap.challenge.service;

import br.com.fiap.challenge.dto.request.CadastroRequest;
import br.com.fiap.challenge.dto.response.CadastroResponse;
import br.com.fiap.challenge.entity.Cadastro;
import br.com.fiap.challenge.repository.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroService implements ServiceDTO<Cadastro, CadastroRequest, CadastroResponse> {

    @Autowired
    private CadastroRepository repo;

    @Override
    public Cadastro toEntity(CadastroRequest r) {
        return Cadastro.builder()
                .nome(r.nome())
                .sobrenome(r.sobrenome())
                .sexo(r.sexo())
                .cpf(r.cpf())
                .celular(r.celular())
                .dataNascimento(r.dataNascimento())
                .email(r.email())
                .build();
    }

    @Override
    public CadastroResponse toResponse(Cadastro e) {
        return CadastroResponse.builder()
                .id(e.getId())
                .nome(e.getNome())
                .sobrenome(e.getSobrenome())
                .sexo(e.getSexo())
                .cpf(e.getCpf())
                .celular(e.getCelular())
                .dataNascimento(e.getDataNascimento())
                .email(e.getEmail())
                .build();
    }

    @Override
    public List<Cadastro> findAll() {
        return repo.findAll();
    }

    @Override
    public List<Cadastro> findAll(Example<Cadastro> example) {
        return repo.findAll(example);
    }

    @Override
    public Cadastro findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Cadastro save(Cadastro cadastro) {
        return repo.save(cadastro);
    }
}
