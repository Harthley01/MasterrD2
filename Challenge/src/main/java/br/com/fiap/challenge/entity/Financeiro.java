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
@Table(name = "TB_FINANCEIRO")
public class Financeiro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_FINANCEIRO")
    @SequenceGenerator(name = "SQ_FINANCEIRO", sequenceName = "SQ_FINANCEIRO", allocationSize = 1)
    @Column(name = "ID_FINANCEIRO")
    private Long id;

    @Column(name = "RENDA_MENSAL")
    private double rendaMensal;

    @Column(name = "FONTE_RENDA")
    private String fonteRenda;

    @Column(name = "TIPO_EMPREGO")
    private String tipoEmprego;

    @Column(name = "INFO_CONTA_BANCARIA")
    private String infoContaBancaria;

    @Column(name = "HISTORICO_EMPRESTIMO")
    private String historicoEmprestimo;

    @Column(name = "HISTORICO_PAGAMENTO")
    private String historicoPagamento;

}
