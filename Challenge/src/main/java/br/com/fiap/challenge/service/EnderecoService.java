package br.com.fiap.challenge.service;

import br.com.fiap.challenge.dto.request.EnderecoRequest;
import br.com.fiap.challenge.dto.response.EnderecoResponse;
import br.com.fiap.challenge.entity.Endereco;
import br.com.fiap.challenge.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService implements ServiceDTO<Endereco, EnderecoRequest, EnderecoResponse> {

    @Autowired
    private EnderecoRepository repo;

    @Override
    public Endereco toEntity(EnderecoRequest r) {
        return Endereco.builder()
                .endereco(r.endereco())
                .cep(r.cep())
                .complemento(r.complemento())
                .build();
    }

    @Override
    public EnderecoResponse toResponse(Endereco e) {
        return EnderecoResponse.builder()
                .id(e.getId())
                .endereco(e.getEndereco())
                .cep(e.getCep())
                .complemento(e.getComplemento())
                .build();
    }

    @Override
    public List<Endereco> findAll() {
        return repo.findAll();
    }

    @Override
    public List<Endereco> findAll(Example<Endereco> example) {
        return repo.findAll(example);
    }

    @Override
    public Endereco findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Endereco save(Endereco e) {
        return repo.save(e);
    }
}
