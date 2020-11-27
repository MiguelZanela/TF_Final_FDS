/*
* Interface que extende repositorio, caso necessario pode conter metodos espeficios para essa classe
*
* @Author Miguel Zanela, Ismael Vargas, Rafael Mattone
*
* Version 1 dez, 2020
* 
*/
package com.bcopstein.Entidades.Repositorio;

import com.bcopstein.CasosDeUso.ItemConfiguracao;

public interface ItensConfiguracao extends Repositorio<ItemConfiguracao, String> {
    boolean cadastraRegra(ItemConfiguracao config);
}
