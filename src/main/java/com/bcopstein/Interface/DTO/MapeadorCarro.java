/*
* Classe para tranformar informaçoes do front para o back
*
* @Author Miguel Zanela, Ismael Vargas, Rafael Mattone
*
* Version 1 dez, 2020
* 
*/

package com.bcopstein.Interface.DTO;

import com.bcopstein.Entidades.Dominio.Aluguel.CarroAlugado;
import org.springframework.stereotype.Component;

@Component
public class MapeadorCarro {

    public MapeadorCarro(){
    }

    public CarroAlugado CarroCustoToCarroAlugado(CarroCustoDTO carroDTO) {
        CarroAlugado carroAlugado = new CarroAlugado(carroDTO.getPlaca(), carroDTO.getTotalPagar());
        return carroAlugado;
    }
}
