package br.com.fiap.challenge.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FinanceiroRequest(
        @NotNull(message = "O atributo rendaMensal é obrigatório")
        double rendaMensal,

        @NotBlank(message = "O atributo fonteRenda é obrigatório")
        @NotNull(message = "O atributo fonteRenda é obrigatório")
        String fonteRenda,

        @NotBlank(message = "O atributo tipoEmprego é obrigatório")
        @NotNull(message = "O atributo tipoEmprego é obrigatório")
        String tipoEmprego,

        String infoContaBancaria,
        String historicoEmprestimo,
        String historicoPagamento
) {}
