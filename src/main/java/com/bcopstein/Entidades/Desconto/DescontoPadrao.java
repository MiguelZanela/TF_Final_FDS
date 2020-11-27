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

public class DescontoPadrao implements RegraDesconto {

	@Override
	public double calcular(Carro carro, Long diasLocacao) {		
		return 0.0;
	}	
    
}
