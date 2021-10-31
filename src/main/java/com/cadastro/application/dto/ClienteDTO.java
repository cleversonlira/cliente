package com.cadastro.application.dto;

import com.cadastro.domain.model.Cliente;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class ClienteDTO {

    private Long id;
    private String nome;
    private String cpf;
    private String nacionalidade;
    private String naturalidade;
    private String sexo;
    private String dataNascimento;
    private String logradouro;
    private String numero;
    private String complemento;
    private String municipio;
    private String uf;
    private String cep;

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.nacionalidade = cliente.getNacionalidade();
        this.naturalidade = cliente.getNaturalidade();
        this.sexo = cliente.toString().replaceAll("_", " ").toLowerCase();
        this.dataNascimento = cliente.getDataNascimento().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.logradouro = cliente.getEndereco().getLogradouro();
        this.numero = cliente.getEndereco().getNumero();
        this.complemento = cliente.getEndereco().getComplemento();
        this.municipio = cliente.getEndereco().getMunicipio();
        this.uf = cliente.getEndereco().getEstado().getSigla();
        this.cep = cliente.getEndereco().getCep();
    }

    public static List<ClienteDTO> converterLista(List<Cliente> clientes) {
        return clientes.stream().map(ClienteDTO::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public String getSexo() {
        return sexo;
    }

    public String getDataNascimento() {
        return dataNascimento;
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

    public String getUf() {
        return uf;
    }

    public String getCep() {
        return cep;
    }
}