package br.com.fiap.challenge.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "TB_CADASTRO")
public class Cadastro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CADASTRO")
    @SequenceGenerator(name = "SQ_CADASTRO", sequenceName = "SQ_CADASTRO", allocationSize = 1)
    @Column(name = "ID_CADASTRO")
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "SOBRENOME")
    private String sobrenome;

    @Column(name = "SEXO")
    private String sexo;

    @Column(name = "CPF")
    private String cpf;

    @Column(name = "CELULAR")
    private String celular;

    @Column(name = "DATA_NASCIMENTO")
    private String dataNascimento;

    @Column(name = "EMAIL")
    private String email;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_ENDERECO", referencedColumnName = "ID_ENDERECO")
    private Endereco endereco;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_LOGIN", referencedColumnName = "ID_LOGIN")
    private Login login;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_FINANCEIRO", referencedColumnName = "ID_FINANCEIRO")
    private Financeiro financeiro;

}
