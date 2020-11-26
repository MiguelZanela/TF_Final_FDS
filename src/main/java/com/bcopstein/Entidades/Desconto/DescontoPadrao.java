package com.bcopstein.Entidades.Desconto;

import com.bcopstein.Entidades.Dominio.Carro.Carro;

public class DescontoPadrao implements RegraDesconto {

	@Override
	public double calcular(Carro carro, Long diasLocacao) {		
		return 0.0;
	}	
    
}
