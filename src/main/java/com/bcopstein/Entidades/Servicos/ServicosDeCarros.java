/*
* Classe com os servicos relacionados a carros
*
* @Author Miguel Zanela, Ismael Vargas, Rafael Mattone
*
* Version 1 dez, 2020
* 
*/
package com.bcopstein.Entidades.Servicos;

import com.bcopstein.Entidades.Repositorio.Carros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicosDeCarros {
    private Carros carros;

    @Autowired
    public ServicosDeCarros(Carros carros){
        this.carros = carros;
    }

    public void setCarroOcupado(String Placa){
        carros.recupera(Placa).setStatusCarro(false);
        carros.atualiza(carros.recupera(Placa));
    }

    public void setCarroLivre(String Placa){
        carros.recupera(Placa).setStatusCarro(true);
        carros.atualiza(carros.recupera(Placa));
    }

}
