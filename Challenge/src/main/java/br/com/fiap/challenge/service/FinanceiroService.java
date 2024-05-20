package br.com.fiap.challenge.service;

import br.com.fiap.challenge.dto.request.FinanceiroRequest;
import br.com.fiap.challenge.dto.response.FinanceiroResponse;
import br.com.fiap.challenge.entity.Financeiro;
import br.com.fiap.challenge.repository.FinanceiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinanceiroService implements ServiceDTO<Financeiro, FinanceiroRequest, FinanceiroResponse> {

    @Autowired
    private FinanceiroRepository repo;

    @Override
    public Financeiro toEntity(FinanceiroRequest r) {
        return Financeiro.builder()
                .rendaMensal(r.rendaMensal())
                .fonteRenda(r.fonteRenda())
                .tipoEmprego(r.tipoEmprego())
                .infoContaBancaria(r.infoContaBancaria())
                .historicoEmprestimo(r.historicoEmprestimo())
                .historicoPagamento(r.historicoPagamento())
                .build();
    }

    @Override
    public FinanceiroResponse toResponse(Financeiro e) {
        return FinanceiroResponse.builder()
                .rendaMensal(e.getRendaMensal())
                .fonteRenda(e.getFonteRenda())
                .tipoEmprego(e.getTipoEmprego())
                .infoContaBancaria(e.getInfoContaBancaria())
                .historicoEmprestimo(e.getHistoricoEmprestimo())
                .historicoPagamento(e.getHistoricoPagamento())
                .build();
    }

    @Override
    public List<Financeiro> findAll() {
        return repo.findAll();
    }

    @Override
    public List<Financeiro> findAll(Example<Financeiro> example) {
        return repo.findAll(example);
    }

    @Override
    public Financeiro findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Financeiro save(Financeiro e) {
        return repo.save(e);
    }
}
