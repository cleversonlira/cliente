package com.cadastro.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public enum Sexo {
    FEMININO,
    MASCULINO,
    NAO_BINARIO,
    PREFIRO_NAO_DECLARAR;

    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
