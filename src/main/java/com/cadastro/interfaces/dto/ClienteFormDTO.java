package com.cadastro.interfaces.dto;

import com.cadastro.domain.model.Cliente;
import com.cadastro.domain.model.Endereco;
import com.cadastro.domain.model.Estado;
import com.cadastro.domain.model.Sexo;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ClienteFormDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;
    @CPF(message = "CPF inválido")
    private String cpf;
    @NotBlank(message = "Nacionalidade é obrigatório")
    private String nacionalidade;
    @NotBlank(message = "Naturalidade é obrigatório")
    private String naturalidade;
    @NotBlank(message = "Sexo é obrigatório")
    private String sexo;
    @NotBlank(message = "Data de nascimento é obrigatório")
    private String dataNascimento;
    private Endereco endereco;
//    @NotBlank(message = "Nome é obrigatório")
//    private String logradouro;
//    @NotBlank(message = "Nome é obrigatório")
//    private Integer numero;
//
//    private String complemento;
//    @NotBlank(message = "Nome é obrigatório")
//    private String municipio;
//    @NotBlank(message = "Nome é obrigatório") @Max(2)
//    private String uf;
//
//    @NotBlank
//    private String cep;

    public void atualizar(Cliente cliente) {
        preencher(cliente);
    }

    public Cliente converter() {
        return preencher(new Cliente());
    }

    private Cliente preencher(Cliente cliente) {
        cliente.setNome(this.nome);
        cliente.setCpf(this.cpf);
        cliente.setNacionalidade(this.nacionalidade);
        cliente.setNaturalidade(this.naturalidade);
        cliente.setDataNascimento(LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        int sexo = Sexo.valueOf(this.sexo.replace(" ", "_").toUpperCase()).obterId();
        cliente.setSexoId(sexo);
        cliente.setEndereco(this.endereco);
//        cliente.setEndereco(new Endereco(cep, logradouro, numero, complemento, municipio, new Estado(uf)));
        return cliente;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

//    public void setLogradouro(String logradouro) {
//        this.logradouro = logradouro;
//    }
//
//    public void setNumero(Integer numero) {
//        this.numero = numero;
//    }
//
//    public void setComplemento(String complemento) {
//        this.complemento = complemento;
//    }
//
//    public void setMunicipio(String municipio) {
//        this.municipio = municipio;
//    }
//
//    public void setUf(String uf) {
//        this.uf = uf;
//    }
//
//    public void setCep(String cep) {
//        this.cep = cep;
//    }
}
