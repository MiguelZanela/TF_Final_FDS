package com.bcopstein.Entidades.Servicos;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.bcopstein.Entidades.Desconto.FactoryDesconto;
import com.bcopstein.Entidades.Dominio.Carro.Carro;
import com.bcopstein.Entidades.Dominio.Data.DataLocal;
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
    
    public long getDiasLocacao(DataLocal inicioLocacao, DataLocal fimLocacao){
        long dias = 0;
        String anoIni = inicioLocacao.getAno()+"-";
        String mesIni = inicioLocacao.getMes()+"-";
        String diaIni = inicioLocacao.getDia()+"";
        String anoFim = fimLocacao.getAno()+"-";
        String mesFim = fimLocacao.getMes()+"-";
        String diaFim = fimLocacao.getDia()+"";
        LocalDate iniLoc = LocalDate.parse(anoIni+mesIni+diaIni);
        LocalDate fimLoc = LocalDate.parse(anoFim+mesFim+diaFim);
        dias = ChronoUnit.DAYS.between(iniLoc, fimLoc);
        return dias;
    }

    public Integer calculaSubtotal(Carro carro, Long diasLocacao) {
        return (int) (carro.getValordiaria()*diasLocacao);
    }

    public Integer calculaDesconto(Carro carro, Long diasLocacao) {
        return (int) factoryDesconto.getRegraDesconto().calcular(carro, diasLocacao);
    }

    public Integer calculaSeguro(Carro carro, Long diasLocacao) {
        return (int) factorySeguro.getRegraSeguro().calcular(carro, diasLocacao);
    }

    public Integer calculaPrecoFinal(Carro carro, Long diasLocacao) {
        return calculaSubtotal(carro, diasLocacao) + calculaSeguro(carro, diasLocacao) - calculaDesconto(carro, diasLocacao);
    }

    public Integer[] todosValores(Carro carro, Long diasLocacao) {
        Integer[] valores = new Integer[3];
        valores[0] = calculaSubtotal(carro, diasLocacao);
        valores[1] = calculaDesconto(carro, diasLocacao);
        valores[2] = calculaSeguro(carro, diasLocacao);
        valores[3] = calculaPrecoFinal(carro, diasLocacao);
        return valores;
    }
}
