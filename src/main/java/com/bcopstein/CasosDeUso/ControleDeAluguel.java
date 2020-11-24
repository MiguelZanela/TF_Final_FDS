package com.bcopstein.CasosDeUso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.bcopstein.Entidades.Dominio.Carro.Carro;
import com.bcopstein.Entidades.Dominio.Data.DataLocal;
import com.bcopstein.Entidades.Repositorio.Carros;
import com.bcopstein.Entidades.Servicos.ServicosDeAluguel;
import com.bcopstein.Entidades.Servicos.ServicosDeCarros;
import com.bcopstein.Interface.DTO.CarroCustoDTO;
import com.bcopstein.Interface.DTO.FiltroDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ControleDeAluguel {
    private Carros carros;
    private DataLocal dataLocal;
    private ServicosDeAluguel srvAluguel;


    @Autowired
    public ControleDeAluguel(Carros carros, ServicosDeAluguel srvAluguel, ServicosDeCarros srvCarros, DataLocal dataLocal){
        this.carros = carros;
        this.srvAluguel = srvAluguel;
        this.dataLocal = dataLocal;
    }

    public Collection<Carro> listaCarros() {
        return carros.todos();
    }

    public boolean validaDatas(FiltroDTO filtro){
        DataLocal inicioLocacao = filtro.getInicioLocacao(); 
        DataLocal fimLocacao = filtro.getFimLocacao();
		if(inicioLocacao.getDia() >= dataLocal.getDia() && inicioLocacao.getMes() >= dataLocal.getMes() && inicioLocacao.getAno() >= dataLocal.getAno() && 
            fimLocacao.getDia() >= inicioLocacao.getDia() && fimLocacao.getMes() >= inicioLocacao.getMes() && fimLocacao.getAno() >= inicioLocacao.getAno()){
            return true;
        }
        return false;
    }

    private List<Carro> disponiveis(FiltroDTO filtro){
            List<Carro> disponiveis = listaCarros().stream()
            .filter(c->c.getStatusCarro() == true)
            .filter(c->c.isArcondicionado() == filtro.isArcondicionado())
            .filter(c->c.isDirecao() == filtro.isDirecao())
            .filter(c->c.isCambioautomatico() == filtro.isCambio())
            .collect(Collectors.toList());  
            return disponiveis;     
    }

    public List<CarroCustoDTO> getInformacoes(FiltroDTO filtro){
        List<CarroCustoDTO> informacoes = new ArrayList<>(disponiveis(filtro).size());
        long diasLocacao = srvAluguel.getDiasLocacao(filtro.getInicioLocacao(), filtro.getFimLocacao());
        disponiveis(filtro).forEach(c->{
            informacoes.add(new CarroCustoDTO(filtro.getInicioLocacao(),
                                              filtro.getFimLocacao(),
                                              c.getPlaca(),
                                              c.getMarca(),
                                              c.getModelo(),
                                              c.isArcondicionado(),
                                              c.isDirecao(),
                                              c.isCambioautomatico(),
                                              srvAluguel.calculaSubtotal(c, diasLocacao), // Total das diárias
                                              srvAluguel.calculaSeguro(c, diasLocacao),  // Custo do seguro
                                              srvAluguel.calculaDesconto(c, diasLocacao) ,   // Total do desconto
                                              srvAluguel.calculaPrecoFinal(c, diasLocacao))); // Valor a pagar
        });
        return informacoes;
    }

}
