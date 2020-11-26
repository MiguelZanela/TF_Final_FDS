package com.bcopstein.Entidades.Seguro;

import com.bcopstein.Entidades.Dominio.Carro.Carro;

public class SeguroPremium implements RegraSeguro {

    @Override
    public double calcular(Carro carro, Long diasLocacao) {
        double aux = carro.getValordiaria() / 1;
        return aux*diasLocacao;
    }
    
}
