package com.bcopstein.CasosDeUso.FactorySeguroDesconto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ConfigRegraSeguro {
    @Id
    private int nroseg;
    private Long regra;

    //para uso do H2DB
    protected ConfigRegraSeguro(){}

    public ConfigRegraSeguro(int nroseg, Long regra){
        this.nroseg = nroseg;
        this.regra = regra;
    }

    public Long getRegra(){
        return regra;
    }

    public int getNroSeg(){
        return nroseg;
    }
}
