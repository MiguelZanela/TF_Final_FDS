/*
* interface contem as regras que todos os descontos devem seguir
*
* @Author Miguel Zanela, Ismael Vargas, Rafael Mattone
*
* Version 1 dez, 2020
* 
*/
package com.bcopstein.Entidades.Desconto;

import com.bcopstein.Entidades.Dominio.Carro.Carro;

public interface RegraDesconto {
    public double calcular(Carro carro, Long diasLocacao);
}
