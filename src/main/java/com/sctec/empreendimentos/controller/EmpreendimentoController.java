package com.sctec.empreendimentos.controller;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sctec.empreendimentos.dto.EmpreendimentoCreateDTO;
import com.sctec.empreendimentos.dto.EmpreendimentoResponseDTO;
import com.sctec.empreendimentos.service.EmpreendimentoService;

@RestController
@RequestMapping("/api/empreendimentos")
public class EmpreendimentoController {

    private final EmpreendimentoService service;

    public EmpreendimentoController(EmpreendimentoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<EmpreendimentoResponseDTO> criar(@RequestBody @Valid EmpreendimentoCreateDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dto));
    }

    @GetMapping
    public Page<EmpreendimentoResponseDTO> listar(Pageable pageable) {
        return service.listar(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpreendimentoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpreendimentoResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid EmpreendimentoCreateDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Void> alterarStatus(@PathVariable Long id, @RequestParam boolean ativo) {
        service.ativarInativar(id, ativo);
        return ResponseEntity.noContent().build();
    }
}