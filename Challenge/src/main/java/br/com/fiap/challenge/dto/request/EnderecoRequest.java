package br.com.fiap.challenge.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EnderecoRequest(
        @NotBlank(message = "O atributo endereco é obrigatório")
        @NotNull(message = "O atributo endereco é obrigatório")
        String endereco,

        @NotBlank(message = "O atributo cep é obrigatório")
        @NotNull(message = "O atributo cep é obrigatório")
        String cep,

        String complemento
) {}
