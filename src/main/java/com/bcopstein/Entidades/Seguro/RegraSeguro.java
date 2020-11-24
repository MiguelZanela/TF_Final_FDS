package com.bcopstein.Entidades.Seguro;

import com.bcopstein.Entidades.Dominio.Carro.Carro;

public interface RegraSeguro {
    public double calcular(Carro carro, Long diasLocacao);
    
}
