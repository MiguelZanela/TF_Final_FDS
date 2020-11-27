/*
* interface contem as regras que todos os seguros devem seguir
*
* @Author Miguel Zanela, Ismael Vargas, Rafael Mattone
*
* Version 1 dez, 2020
* 
*/
package com.bcopstein.Entidades.Seguro;

import com.bcopstein.Entidades.Dominio.Carro.Carro;

public interface RegraSeguro {
    public double calcular(Carro carro, Long diasLocacao);
    
}
