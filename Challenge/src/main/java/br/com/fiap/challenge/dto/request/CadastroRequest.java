package br.com.fiap.challenge.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastroRequest(
        @NotBlank(message = "O atributo nome é obrigatório")
        @NotNull(message = "O atributo nome é obrigatório")
        String nome,

        @NotBlank(message = "O atributo sobrenome é obrigatório")
        @NotNull(message = "O atributo sobrenome é obrigatório")
        String sobrenome,

        @NotBlank(message = "O atributo sexo é obrigatório")
        @NotNull(message = "O atributo sexo é obrigatório")
        String sexo,

        @NotBlank(message = "O atributo cpf é obrigatório")
        @NotNull(message = "O atributo cpf é obrigatório")
        String cpf,

        @NotBlank(message = "O atributo celular é obrigatório")
        @NotNull(message = "O atributo celular é obrigatório")
        String celular,

        @NotBlank(message = "O atributo data de nascimento é obrigatório")
        @NotNull(message = "O atributo data de nascimento é obrigatório")
        String dataNascimento,

        @Email(message = "O atributo email deve ser um endereço de e-mail válido")
        @NotBlank(message = "O atributo email é obrigatório")
        @NotNull(message = "O atributo email é obrigatório")
        String email
) {}
