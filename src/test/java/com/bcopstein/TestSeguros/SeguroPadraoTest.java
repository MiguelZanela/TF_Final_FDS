package com.bcopstein.TestSeguros;

import org.junit.jupiter.api.Assertions;
import com.bcopstein.Entidades.Seguro.*;
import com.bcopstein.Entidades.Dominio.Carro.Carro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SeguroPadraoTest {

    SeguroPadrao s1 = null;
    Carro c1 = null;
    long diasLocacao = 10;

    @BeforeEach
    void setUp(){
        c1 = new Carro("ACD1234", "VM", "saveiro",10, true, true, true, true);
        s1 = new SeguroPadrao();
    }

    @Test
    public void testeSeguroPadrao(){
        double valorEsperado = 33.333333333333336;
        Assertions.assertEquals(valorEsperado, s1.calcular(c1,diasLocacao));
    }

}
