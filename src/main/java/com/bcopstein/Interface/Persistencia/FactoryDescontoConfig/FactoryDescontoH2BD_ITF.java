package com.bcopstein.Interface.Persistencia.FactoryDescontoConfig;

import java.util.List;

import com.bcopstein.CasosDeUso.FactorySeguroDesconto.ConfigRegraDesconto;

import org.springframework.data.repository.CrudRepository;

public interface FactoryDescontoH2BD_ITF extends CrudRepository<ConfigRegraDesconto,Integer> {
    List<ConfigRegraDesconto> findBynrodesc(Integer nrodesc);
    List<ConfigRegraDesconto> findAll();
}

