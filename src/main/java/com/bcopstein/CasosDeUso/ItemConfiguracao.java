/*
* Classe contendo as informacoes necessarias para um item configuracao
*
* @Author Miguel Zanela, Ismael Vargas, Rafael Mattone
*
* Version 1 dez, 2020
* 
*/
package com.bcopstein.CasosDeUso;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ItemConfiguracao {
    @Id
    private String chave;
    private Long regra;

    // para uso do H2DB
    protected ItemConfiguracao() {
    }

    public ItemConfiguracao(String chave, Long regra) {
        this.chave = chave;
        this.regra = regra;
    }

    public Long getRegra(){
        return regra;
    }

    public String getChave(){
        return chave;
    }
}