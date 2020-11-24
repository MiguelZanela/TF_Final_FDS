package com.bcopstein.Entidades.Desconto;

import org.springframework.stereotype.Component;

@Component
public class FactoryDesconto {
    public RegraDesconto getRegraDesconto(){
        return new DescontoDiasAlugados();        
    }
}
