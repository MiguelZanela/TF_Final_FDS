/*
* Classe que devolve um tipo de seguro, de acordo com o tipo de seguro ativo no momento
* caso nao ache nenhum seguro ativo, aplica o padrao
*
* @Author Miguel Zanela, Ismael Vargas, Rafael Mattone
*
* Version 1 dez, 2020
* 
*/
package com.bcopstein.Entidades.Seguro;

import com.bcopstein.CasosDeUso.ItemConfiguracao;
import com.bcopstein.Entidades.Repositorio.ItensConfiguracao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FactorySeguro {
    private ItensConfiguracao itemConfig;

    @Autowired
    public FactorySeguro(ItensConfiguracao itemConfig) {
        this.itemConfig = itemConfig;
    }

    public RegraSeguro getRegraSeguro() {
        for (ItemConfiguracao it : itemConfig.todos()) {
            if(it.getChave().toUpperCase().equals("SEGURO")){
                if(it.getRegra() == 1){
                    return new SeguroPlus();
                } 
                else if (it.getRegra() == 2) { 
                    return new SeguroPremium();
                }
                else if(it.getRegra() == 3) {
                    return new SeguroPromocao();
                }
            }
        }
        return new SeguroPadrao();     
    }
}
