package com.sctec.empreendimentos.domain;

import jakarta.persistence.*;

@Entity
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

    // Construtores
    public Empreendimento() {
    }

    private Empreendimento(Builder builder) {
        this.nome = builder.nome;
        this.nomeEmpreendedor = builder.nomeEmpreendedor;
        this.municipio = builder.municipio;
        this.segmento = builder.segmento;
        this.emailContato = builder.emailContato;
        this.ativo = builder.ativo;
    }

    public static Builder builder() {
        return new Builder();
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getNomeEmpreendedor() {
        return nomeEmpreendedor;
    }

    public String getMunicipio() {
        return municipio;
    }

    public Segmento getSegmento() {
        return segmento;
    }

    public String getEmailContato() {
        return emailContato;
    }

    public boolean isAtivo() {
        return ativo;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNomeEmpreendedor(String nomeEmpreendedor) {
        this.nomeEmpreendedor = nomeEmpreendedor;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public void setSegmento(Segmento segmento) {
        this.segmento = segmento;
    }

    public void setEmailContato(String emailContato) {
        this.emailContato = emailContato;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    // Builder
    public static class Builder {
        private String nome;
        private String nomeEmpreendedor;
        private String municipio;
        private Segmento segmento;
        private String emailContato;
        private boolean ativo;

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder nomeEmpreendedor(String nomeEmpreendedor) {
            this.nomeEmpreendedor = nomeEmpreendedor;
            return this;
        }

        public Builder municipio(String municipio) {
            this.municipio = municipio;
            return this;
        }

        public Builder segmento(Segmento segmento) {
            this.segmento = segmento;
            return this;
        }

        public Builder emailContato(String emailContato) {
            this.emailContato = emailContato;
            return this;
        }

        public Builder ativo(boolean ativo) {
            this.ativo = ativo;
            return this;
        }

        public Empreendimento build() {
            return new Empreendimento(this);
        }
    }
}