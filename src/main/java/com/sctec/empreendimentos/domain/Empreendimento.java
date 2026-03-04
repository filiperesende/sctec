package com.sctec.empreendimentos.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "empreendimentos")
public class Empreendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(name = "nome_empreendedor", nullable = false, length = 120)
    private String nomeEmpreendedor;

    @Column(nullable = false, length = 100)
    private String municipio;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Segmento segmento;

    @Column(length = 150)
    private String emailContato;

    @Column(nullable = false)
    private boolean ativo;

}