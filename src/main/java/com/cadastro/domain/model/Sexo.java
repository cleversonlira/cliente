package com.cadastro.domain.model;

public enum Sexo {
    FEMININO{
        @Override
        public int obterId() {
            return 1;
        }
    },
    MASCULINO{
        @Override
        public int obterId() {
            return 2;
        }
    },
    NAO_BINARIO{
        @Override
        public int obterId() {
            return 3;
        }
    },
    PREFIRO_NAO_DECLARAR{
        @Override
        public int obterId() {
            return 4;
        }
    };
    public abstract int obterId();
}
