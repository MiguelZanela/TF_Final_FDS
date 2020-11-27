/*
* Classe com os servicos relacionados a alugueis
*
* @Author Miguel Zanela, Ismael Vargas, Rafael Mattone
*
* Version 1 dez, 2020
* 
*/
package com.bcopstein.Entidades.Servicos;

import com.bcopstein.Entidades.Desconto.FactoryDesconto;
import com.bcopstein.Entidades.Dominio.Carro.Carro;
import com.bcopstein.Entidades.Seguro.FactorySeguro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicosDeAluguel {
    private FactoryDesconto factoryDesconto;
    private FactorySeguro factorySeguro;

    @Autowired
    public ServicosDeAluguel(FactoryDesconto factoryDesconto, FactorySeguro factorySeguro){
        this.factoryDesconto = factoryDesconto;
        this.factorySeguro = factorySeguro;
    } 

    public Integer calculaTotalDiarias(Carro carro, Long diasLocacao) {
        return (int) (carro.getValordiaria()*diasLocacao);
    }

    public Integer calculaDesconto(Carro carro, Long diasLocacao) {
        return (int) factoryDesconto.getRegraDesconto().calcular(carro, diasLocacao);
    }

    public Integer calculaSeguro(Carro carro, Long diasLocacao) {
        return (int) factorySeguro.getRegraSeguro().calcular(carro, diasLocacao);
    }

    public Integer calculaValorFinal(Carro carro, Long diasLocacao) {
        return calculaTotalDiarias(carro, diasLocacao) + calculaSeguro(carro, diasLocacao) - calculaDesconto(carro, diasLocacao);
    }

    public Integer[] todosValores(Carro carro, Long diasLocacao) {
        Integer[] valores = new Integer[3];
        valores[0] = calculaTotalDiarias(carro, diasLocacao);
        valores[1] = calculaSeguro(carro, diasLocacao);
        valores[2] = calculaDesconto(carro, diasLocacao);
        valores[3] = calculaValorFinal(carro, diasLocacao);
        return valores;
    }
        
}
