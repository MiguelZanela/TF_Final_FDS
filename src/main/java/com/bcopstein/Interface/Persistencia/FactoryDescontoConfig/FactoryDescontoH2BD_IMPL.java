package com.bcopstein.Interface.Persistencia.FactoryDescontoConfig;

import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.bcopstein.CasosDeUso.FactorySeguroDesconto.ConfigRegraDesconto;
import com.bcopstein.Entidades.Repositorio.Descontos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FactoryDescontoH2BD_IMPL implements Descontos {
    private FactoryDescontoH2BD_ITF regraDescDB;

    @Autowired
    public FactoryDescontoH2BD_IMPL(FactoryDescontoH2BD_ITF regraDescDB) {
        this.regraDescDB = regraDescDB;
    }

    @Override
    public boolean cadastra(ConfigRegraDesconto regraDesc) {
        remove();
        regraDescDB.save(regraDesc); 
        if(todos().size() > 0){
            return true;
        }
        return false;       
    }

    @Override
    public ConfigRegraDesconto recupera(Integer chave) {
        return regraDescDB.findBynrodesc(chave).get(0);
    }

    @Override
    public Collection<ConfigRegraDesconto> todos() {
        return regraDescDB.findAll();
    }

    @Override
    public boolean existente(Integer chave) {
        return regraDescDB.existsById(chave);
    }

    @Override
    public Collection<ConfigRegraDesconto> pesquisa(Predicate<ConfigRegraDesconto> pred) {
        return regraDescDB.findAll()
                         .stream()
                         .filter(pred)
                         .collect(Collectors.toList());
    }

    @Override
    public void remove() {
        regraDescDB.deleteAll();
    }

}
