/*
* interface para uso com o H2BD
*
* @Author Miguel Zanela, Ismael Vargas, Rafael Mattone
*
* Version 1 dez, 2020
* 
*/

package com.bcopstein.Interface.Persistencia.ItensConfiguracao;

import java.util.List;

import com.bcopstein.CasosDeUso.ItemConfiguracao;

import org.springframework.data.repository.CrudRepository;

public interface ItemConfiguracaoH2BD_ITF extends CrudRepository<ItemConfiguracao,String>{
    List<ItemConfiguracao> findByChave(String chave);
    List<ItemConfiguracao> findAll();
}
