package com.bcopstein.CasosDeUso.FactorySeguroDesconto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ConfigRegraDesconto {
    @Id
    private int nrodesc;
    private Long regra;

    //para uso do H2DB
    protected ConfigRegraDesconto() {}

    public ConfigRegraDesconto(int nrodesc, Long regra) {
        this.nrodesc = nrodesc;
        this.regra = regra;
    }

    public Long getRegra(){
        return regra;
    }

    public int getNroDesc(){
        return nrodesc;
    }
}
