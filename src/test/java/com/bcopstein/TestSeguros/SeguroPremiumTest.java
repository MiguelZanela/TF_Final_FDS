package com.bcopstein.TestSeguros;

import com.bcopstein.Entidades.Dominio.Carro.Carro;
import com.bcopstein.Entidades.Seguro.SeguroPremium;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SeguroPremiumTest {

    SeguroPremium s1 = null;
    Carro c1 = null;
    long diasLocacao = 10;

    @BeforeEach
    void setUp(){
        c1 = new Carro("ASW5634", "BMW", "Suv",50, true, true, true, true);
        s1 = new SeguroPremium();
    }

    @Test
    public void testeSeguroPadrao(){
        double valorEsperado = 500;
        Assertions.assertEquals(valorEsperado, s1.calcular(c1,diasLocacao));
    }

}
