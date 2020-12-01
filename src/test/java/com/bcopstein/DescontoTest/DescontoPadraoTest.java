package com.bcopstein.DescontoTest;

import com.bcopstein.Entidades.Dominio.Carro.Carro;
import com.bcopstein.Entidades.Desconto.DescontoPadrao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DescontoPadraoTest {
    Carro c1 = null;
    DescontoPadrao d = new DescontoPadrao();

    @BeforeEach
    void setUp(){
        c1 = new Carro("ACD1234", "VM", "saveiro",1, true, true, true, true);
    }

    @Test
    public void DescontoDiasAlugados() {
        Long dias = (long) 5;
        Double result = d.calcular(c1, dias);
        Double descontoEsperado = 0.0;
        Assertions.assertEquals(descontoEsperado, result);
    }

    @Test
    public void DescontoDiasAlugadosInvalido() {
        Long dias = (long) -5;
        Double result = d.calcular(c1, dias);
        Double descontoEsperado = 0.0;
        Assertions.assertEquals(descontoEsperado, result);
    }

}
