package com.sctec.empreendimentos.dto;

import com.sctec.empreendimentos.domain.Segmento;

import jakarta.validation.constraints.*;

public record EmpreendimentoCreateDTO(

        @NotBlank(message = "Nome do empreendimento é obrigatório") @Size(max = 150) String nome,

        @NotBlank(message = "Nome do empreendedor é obrigatório") @Size(max = 120) String nomeEmpreendedor,

        @NotBlank(message = "Município é obrigatório") @Size(max = 100) String municipio,

        @NotNull(message = "Segmento é obrigatório") Segmento segmento,

        @Email(message = "E-mail inválido") @Size(max = 150) String emailContato

) {
}