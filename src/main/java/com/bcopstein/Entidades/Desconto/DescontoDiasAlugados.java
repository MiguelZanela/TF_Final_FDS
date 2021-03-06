/*
* Classe contendo os calculos de um tipo de desconto
*
* @Author Miguel Zanela, Ismael Vargas, Rafael Mattone
*
* Version 1 dez, 2020
* 
*/
package com.bcopstein.Entidades.Desconto;

import com.bcopstein.Entidades.Dominio.Carro.Carro;

public class DescontoDiasAlugados implements RegraDesconto {

    @Override
    public double calcular(Carro carro, Long diasLocacao) {
        double aux = diasLocacao * carro.getValordiaria();

        if(diasLocacao >= 5 && diasLocacao <= 10){
            return aux*0.1;
        }
        else if (diasLocacao >= 11){
            return aux*0.2;
        }
        return 0;
    }
    
}
