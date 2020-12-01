package com.bcopstein.TestSeguros;

import org.junit.jupiter.api.Assertions;
import com.bcopstein.Entidades.Seguro.*;
import com.bcopstein.Entidades.Dominio.Carro.Carro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SeguroPlusTest {

    SeguroPlus s1 = null;
    Carro c1 = null;
    long diasLocacao = 10;

    @BeforeEach
    void setUp(){
        c1 = new Carro("ACD1234", "VM", "saveiro",10, true, true, true, true);
        s1 = new SeguroPlus();
    }

    @Test
    public void testeSeguroPlus(){
        double valorEsperado = 50;
        Assertions.assertEquals(valorEsperado, s1.calcular(c1,diasLocacao));
    }

}
