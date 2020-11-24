package com.bcopstein.Interface.Persistencia.Carros;

import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.bcopstein.Entidades.Dominio.Carro.Carro;
import com.bcopstein.Entidades.Repositorio.Carros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarrosH2BD_IMPL implements Carros {
    private CarrosH2BD_ITF carrosDB;

    @Autowired
    public CarrosH2BD_IMPL(CarrosH2BD_ITF carrosDB){
        this.carrosDB = carrosDB;
    }

    @Override
    public void carrega() {
        // nao é usado
    }

    @Override
    public void persiste() {
        // nao é usado
    }

    @Override
    public void cadastra(Carro carro) {
        carrosDB.save(carro);
    }

    @Override
    public Carro recupera(String chave) {
        return carrosDB.findByPlaca(chave).get(0);
    }

    @Override
    public Collection<Carro> todos() {        
        return carrosDB.findAll();
    }

    @Override
    public boolean existente(String chave) {
        return carrosDB.existsById(chave);
    }

    @Override
    public Collection<Carro> pesquisa(Predicate<Carro> pred) {
        return carrosDB.findAll()
                         .stream()
                         .filter(pred)
                         .collect(Collectors.toList());
    }

    @Override
    public void atualiza(Carro carro) {
        carrosDB.save(carro);
    }

    @Override
    public void remove(String chave) {
        carrosDB.deleteById(chave);
    }
}
