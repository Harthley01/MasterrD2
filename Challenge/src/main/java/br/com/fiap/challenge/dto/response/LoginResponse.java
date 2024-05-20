package br.com.fiap.challenge.dto.response;

import lombok.Builder;

@Builder
public record LoginResponse(
        Long id, String email
) {}
