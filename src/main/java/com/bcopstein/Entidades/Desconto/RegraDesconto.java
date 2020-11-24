package com.bcopstein.Entidades.Desconto;

import com.bcopstein.Entidades.Dominio.Carro.Carro;

public interface RegraDesconto {
    public double calcular(Carro carro, Long diasLocacao);
}
