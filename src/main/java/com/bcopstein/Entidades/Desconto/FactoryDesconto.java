package com.bcopstein.Entidades.Desconto;

import com.bcopstein.CasosDeUso.FactorySeguroDesconto.ConfigRegraDesconto;
import com.bcopstein.Entidades.Repositorio.Descontos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FactoryDesconto {
    private Descontos desconto;

    @Autowired
    public FactoryDesconto(Descontos desconto){
        this.desconto = desconto;
    }

    public RegraDesconto getRegraDesconto(){
        for(ConfigRegraDesconto it: desconto.todos()){
            if(it.getRegra() == 1){
                return new DescontoDiasAlugados();
            }
        } 
        return new DescontoPadrao();     
    }
}
