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
