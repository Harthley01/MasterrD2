package br.com.fiap.challenge.dto.response;

import lombok.Builder;

@Builder
public record FinanceiroResponse(
        Long id,
        double rendaMensal,
        String fonteRenda,
        String tipoEmprego,
        String infoContaBancaria,
        String historicoEmprestimo,
        String historicoPagamento
) {}
