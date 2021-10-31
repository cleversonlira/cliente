package com.cadastro.domain.model;

import javax.persistence.*;

//@Entity
public class Endereco {

  //  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String municipio;

    //@ManyToOne
    private Estado estado;

    public Endereco(String cep, String logradouro, String numero, String complemento, String municipio, Estado estado) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.municipio = municipio;
        this.estado = estado;
    }

    public Endereco() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getMunicipio() {
        return municipio;
    }

    public Estado getEstado() {
        return estado;
    }
}
