package com.bcopstein.Interface.Persistencia.FactorySeguroConfig;

import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.bcopstein.CasosDeUso.FactorySeguroDesconto.ConfigRegraSeguro;
import com.bcopstein.Entidades.Repositorio.Seguros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FactorySeguroH2BD_IMPL implements Seguros {
    private FactorySeguroH2BD_ITF regraSegDB;

    @Autowired
    public FactorySeguroH2BD_IMPL(FactorySeguroH2BD_ITF regraSegDB) {
        this.regraSegDB = regraSegDB;
    }

    @Override
    public boolean cadastra(ConfigRegraSeguro regraDesc) {
        remove();
        regraSegDB.save(regraDesc); 
        if(todos().size() > 0){
            return true;
        }
        return false;        
    }

    @Override
    public ConfigRegraSeguro recupera(Integer chave) {
        return regraSegDB.findBynroseg(chave).get(0);
    }

    @Override
    public Collection<ConfigRegraSeguro> todos() {
        return regraSegDB.findAll();
    }

    @Override
    public boolean existente(Integer chave) {
        return regraSegDB.existsById(chave);
    }

    @Override
    public Collection<ConfigRegraSeguro> pesquisa(Predicate<ConfigRegraSeguro> pred) {
        return regraSegDB.findAll()
                         .stream()
                         .filter(pred)
                         .collect(Collectors.toList());
    }

    @Override
    public void remove() {
        regraSegDB.deleteAll();
    }

}
