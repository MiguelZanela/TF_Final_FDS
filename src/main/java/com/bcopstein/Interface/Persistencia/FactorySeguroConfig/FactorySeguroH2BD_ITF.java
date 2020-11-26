package com.bcopstein.Interface.Persistencia.FactorySeguroConfig;

import java.util.List;

import com.bcopstein.CasosDeUso.FactorySeguroDesconto.ConfigRegraSeguro;

import org.springframework.data.repository.CrudRepository;

public interface FactorySeguroH2BD_ITF extends CrudRepository<ConfigRegraSeguro,Integer> {
    List<ConfigRegraSeguro> findBynroseg(Integer nroseg);
    List<ConfigRegraSeguro> findAll();
}

