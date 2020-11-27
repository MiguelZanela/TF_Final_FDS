/*
* Classe para uso com o H2BD
*
* @Author Miguel Zanela, Ismael Vargas, Rafael Mattone
*
* Version 1 dez, 2020
* 
*/

package com.bcopstein.Interface.Persistencia.ItensConfiguracao;

import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.bcopstein.CasosDeUso.ItemConfiguracao;
import com.bcopstein.Entidades.Repositorio.ItensConfiguracao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemConfiguracaoH2BD_IMPL implements ItensConfiguracao {
    private ItemConfiguracaoH2BD_ITF configDB;

    @Autowired
    public ItemConfiguracaoH2BD_IMPL(ItemConfiguracaoH2BD_ITF configDB) {
        this.configDB = configDB;
    }

    @Override
    public boolean cadastraRegra(ItemConfiguracao config) {
        remove(config.getChave());
        configDB.save(config); 
        if(todos().size() > 0){
            return true;
        }
        return false;       
    }

    @Override
    public ItemConfiguracao recupera(String chave) {
        return configDB.findByChave(chave).get(0);
    }

    @Override
    public Collection<ItemConfiguracao> todos() {
        return configDB.findAll();
    }

    @Override
    public boolean existente(String chave) {
        return configDB.existsById(chave);
    }

    @Override
    public Collection<ItemConfiguracao> pesquisa(Predicate<ItemConfiguracao> pred) {
        return configDB.findAll()
                         .stream()
                         .filter(pred)
                         .collect(Collectors.toList());
    }
    
    @Override
    public void remove(String chave) {
        configDB.deleteById(chave);
    }

    @Override
    public void carrega() {
        // não é usado
    }

    @Override
    public void persiste() {
        // não é usado
    }

    @Override
    public void cadastra(ItemConfiguracao elemento) {
        //não é usado
    }

    @Override
    public void atualiza(ItemConfiguracao elemento) {
        // TODO Auto-generated method stub

    }

}
