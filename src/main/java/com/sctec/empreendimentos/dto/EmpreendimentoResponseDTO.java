package com.sctec.empreendimentos.dto;

import com.sctec.empreendimentos.domain.Empreendimento;
import com.sctec.empreendimentos.domain.Segmento;

public record EmpreendimentoResponseDTO(Long id, String nome, String nomeEmpreendedor, String municipio, Segmento segmento, String emailContato,
        boolean ativo) {
    public static EmpreendimentoResponseDTO fromEntity(Empreendimento e) {
        return new EmpreendimentoResponseDTO(e.getId(), e.getNome(), e.getNomeEmpreendedor(), e.getMunicipio(), e.getSegmento(), e.getEmailContato(),
                e.isAtivo());
    }
}