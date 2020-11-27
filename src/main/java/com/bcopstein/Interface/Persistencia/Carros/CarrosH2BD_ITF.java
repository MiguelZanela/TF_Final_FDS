/*
* interface para uso com o H2BD
*
* @Author Miguel Zanela, Ismael Vargas, Rafael Mattone
*
* Version 1 dez, 2020
* 
*/
package com.bcopstein.Interface.Persistencia.Carros;

import java.util.List;

import com.bcopstein.Entidades.Dominio.Carro.Carro;
import org.springframework.data.repository.CrudRepository;

public interface CarrosH2BD_ITF extends CrudRepository<Carro,String> {
    List<Carro> findByPlaca(String placa);
    List<Carro> findAll();
}
