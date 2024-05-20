package br.com.fiap.challenge.dto.response;

import lombok.Builder;

@Builder
public record CadastroResponse(
        Long id,
        String nome,
        String sobrenome,
        String sexo,
        String cpf,
        String celular,
        String dataNascimento,
        String email,
        EnderecoResponse endereco,
        LoginResponse login,
        FinanceiroResponse financeiro
) {
}
