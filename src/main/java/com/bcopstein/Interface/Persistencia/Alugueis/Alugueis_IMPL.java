package com.bcopstein.Interface.Persistencia.Alugueis;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.bcopstein.Entidades.Dominio.Aluguel.Aluguel;
import com.bcopstein.Entidades.Dominio.Exceptions.SistAlugueisException;
import com.bcopstein.Entidades.Repositorio.Alugueis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Alugueis_IMPL implements Alugueis {
    private static Long nroAluguel = 1L;
    private List<Aluguel> alugueis;

    @Autowired
    public Alugueis_IMPL() {
        this.alugueis = new LinkedList<>();
        carrega();
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
    public void cadastra(Aluguel aluguel) {
        if (aluguel.getCodigo() == -1L) {
            aluguel.setCodigo(nroAluguel);
            nroAluguel++;
        }
        alugueis.add(aluguel);
    }

    static SistAlugueisException makeSistAlugueisException() { 
        return new SistAlugueisException(SistAlugueisException.Causa.ALUGUEL_INEXISTENTE);
    }

    @Override
    public Aluguel recupera(Long chave) {
        return alugueis
          .stream()
          .filter(v->v.getCodigo() == chave)
          .findAny()
          .orElseThrow(Alugueis_IMPL::makeSistAlugueisException);
    }

    @Override
    public Collection<Aluguel> todos() {
        return alugueis;
    }

    @Override
    public boolean existente(Long chave) {
        return alugueis
        .stream()
        .anyMatch(v->v.getCodigo() == chave);
    }

    @Override
    public Collection<Aluguel> pesquisa(Predicate<Aluguel> pred) {
        return alugueis
        .stream()
        .filter(pred)
        .collect(Collectors.toList());
    }

    @Override
    public void atualiza(Aluguel aluguel) {
        // não esta sendo usada        
    }

    @Override
    public void remove(Long chave) {
        Aluguel aluguel = recupera(chave);
        alugueis.remove(aluguel);
    }
    
}
