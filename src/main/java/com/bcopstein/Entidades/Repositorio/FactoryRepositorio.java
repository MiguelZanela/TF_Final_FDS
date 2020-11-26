package com.bcopstein.Entidades.Repositorio;

import java.util.Collection;
import java.util.function.Predicate;

public interface FactoryRepositorio<E, K> {
    boolean cadastra(E elemento);
    E recupera(K chave);
    Collection<E> todos();
    boolean existente(K chave);
    Collection<E> pesquisa(Predicate<E> pred);
    void remove();
}
