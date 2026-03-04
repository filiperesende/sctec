package com.sctec.empreendimentos.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.sctec.empreendimentos.domain.Empreendimento;
import com.sctec.empreendimentos.dto.EmpreendimentoCreateDTO;
import com.sctec.empreendimentos.dto.EmpreendimentoResponseDTO;
import com.sctec.empreendimentos.repository.EmpreendimentoRepository;

@Service
@RequiredArgsConstructor
public class EmpreendimentoService {

    private final EmpreendimentoRepository repository;

    public EmpreendimentoResponseDTO criar(EmpreendimentoCreateDTO dto) {
        var empreendimento = Empreendimento.builder().nome(dto.nome()).nomeEmpreendedor(dto.nomeEmpreendedor()).municipio(dto.municipio())
                .segmento(dto.segmento()).emailContato(dto.emailContato()).ativo(true).build();

        empreendimento = repository.save(empreendimento);
        return EmpreendimentoResponseDTO.fromEntity(empreendimento);
    }

    public Page<EmpreendimentoResponseDTO> listar(Pageable pageable) {
        return repository.findAll(pageable).map(EmpreendimentoResponseDTO::fromEntity);
    }

    public EmpreendimentoResponseDTO buscarPorId(Long id) {
        return repository.findById(id).map(EmpreendimentoResponseDTO::fromEntity)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public EmpreendimentoResponseDTO atualizar(Long id, EmpreendimentoCreateDTO dto) {
        var empreendimento = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        empreendimento.setNome(dto.nome());
        empreendimento.setNomeEmpreendedor(dto.nomeEmpreendedor());
        empreendimento.setMunicipio(dto.municipio());
        empreendimento.setSegmento(dto.segmento());
        empreendimento.setEmailContato(dto.emailContato());

        empreendimento = repository.save(empreendimento);
        return EmpreendimentoResponseDTO.fromEntity(empreendimento);
    }

    public void excluir(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        repository.deleteById(id);
    }

    public void ativarInativar(Long id, boolean ativo) {
        var emp = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        emp.setAtivo(ativo);
        repository.save(emp);
    }
}