package com.cadastro.application.dto;

import com.cadastro.domain.model.Cliente;
import com.cadastro.domain.model.Endereco;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class ClienteDTO {

    private long id;
    private String nome;
    private String cpf;
    private String nacionalidade;
    private String naturalidade;
    private String sexo;
    private String dataNascimento;
    private Endereco endereco;

    public ClienteDTO() {}

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.nacionalidade = cliente.getNacionalidade();
        this.naturalidade = cliente.getNaturalidade();
        this.sexo = cliente.getSexo().toString().replaceAll("_", " ").toLowerCase();
        this.dataNascimento = cliente.getDataNascimento().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.endereco = cliente.getEndereco();
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

    public Endereco getEndereco() {
        return endereco;
    }
}