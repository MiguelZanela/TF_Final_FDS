package com.bcopstein.TestSeguros;

import com.bcopstein.Entidades.Dominio.Carro.Carro;
import com.bcopstein.Entidades.Seguro.SeguroPromocao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SeguroPromocaoTest {

    SeguroPromocao s1 = null;
    Carro c1 = null;
    long diasLocacao = 10;

    @BeforeEach
    void setUp(){
        c1 = new Carro("EOD3472", "Ferrari", "VTW",500, true, true, true, true);
        s1 = new SeguroPromocao();
    }

    @Test
    public void testeSeguroPadrao(){
        double valorEsperado = 1000;
        Assertions.assertEquals(valorEsperado, s1.calcular(c1,diasLocacao));
    }

}
