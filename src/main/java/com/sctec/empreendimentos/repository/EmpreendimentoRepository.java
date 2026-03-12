package com.sctec.empreendimentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sctec.empreendimentos.domain.Empreendimento;

@Repository
public interface EmpreendimentoRepository extends JpaRepository<Empreendimento, Long> {
}
