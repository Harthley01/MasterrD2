package br.com.fiap.challenge.dto.response;

import lombok.Builder;

@Builder
public record EnderecoResponse(
        Long id,
        String endereco,
        String cep,
        String complemento
) {}
