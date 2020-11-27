/*
* Classe contendo os calculos de um tipo de seguro
*
* @Author Miguel Zanela, Ismael Vargas, Rafael Mattone
*
* Version 1 dez, 2020
* 
*/
package com.bcopstein.Entidades.Seguro;

import com.bcopstein.Entidades.Dominio.Carro.Carro;

public class SeguroPlus implements RegraSeguro {

    @Override
    public double calcular(Carro carro, Long diasLocacao) {
        double aux = carro.getValordiaria() / 2;
        return aux*diasLocacao;
    }
    
}
