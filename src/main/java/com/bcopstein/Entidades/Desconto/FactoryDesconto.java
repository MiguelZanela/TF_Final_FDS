/*
* Classe que devolve um tipo de desconto, de acordo com o tipo de desconto ativo no momento
* caso nao ache nenhum desconto ativo, aplica o padrao
*
* @Author Miguel Zanela, Ismael Vargas, Rafael Mattone
*
* Version 1 dez, 2020
* 
*/
package com.bcopstein.Entidades.Desconto;

import com.bcopstein.CasosDeUso.ItemConfiguracao;
import com.bcopstein.Entidades.Repositorio.ItensConfiguracao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FactoryDesconto {
    private ItensConfiguracao itemConfig;

    @Autowired
    public FactoryDesconto(ItensConfiguracao itemConfig) {
        this.itemConfig = itemConfig;
    }

    public RegraDesconto getRegraDesconto() {
        for (ItemConfiguracao it : itemConfig.todos()) {
            if(it.getChave().toUpperCase().equals("DESCONTO")){
                if(it.getRegra() == 1){
                    return new DescontoDiasAlugados();
                }
            }
        }
        return new DescontoPadrao();     
    }
}
