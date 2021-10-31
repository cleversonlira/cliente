package com.cadastro.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estado {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String sigla;
    private String nome;

    public Estado(String sigla) {
        this.sigla = sigla;
    }

    public Estado() {

    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String uf) {
        this.sigla = uf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}