package com.bcopstein.Entidades.Seguro;

import org.springframework.stereotype.Component;

@Component
public class FactorySeguro {
    public RegraSeguro getRegraSeguro(){
        return new SeguroBasico();        
    }
}
