package com.bcopstein.Entidades.Seguro;

import com.bcopstein.CasosDeUso.FactorySeguroDesconto.ConfigRegraSeguro;
import com.bcopstein.Entidades.Repositorio.Seguros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FactorySeguro {
    private Seguros seguro;

    @Autowired
    public FactorySeguro(Seguros seguro){
        this.seguro = seguro;
    }

    public RegraSeguro getRegraSeguro(){
        for(ConfigRegraSeguro it: seguro.todos()){
            if(it.getRegra() == 1){
                return new SeguroPlus();
            }
            else if(it.getRegra() == 2){
                return new SeguroPremium();
            }
            else if(it.getRegra() == 3){
                return new SeguroPromocao();
            }
        }
        return new SeguroPadrao();     
    }
}
