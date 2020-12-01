package com.bcopstein.DescontoTest;

import com.bcopstein.Entidades.Dominio.Carro.Carro;
import com.bcopstein.Entidades.Desconto.DescontoDiasAlugados;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DescontoDiasAlugadosTest {
    Carro c1 = null;
    DescontoDiasAlugados d = new DescontoDiasAlugados();

    @BeforeEach
    void setUp(){
        c1 = new Carro("ACD1234", "VM", "saveiro",1, true, true, true, true);
    }

    @Test
    public void Menor5() {
        Long dias = (long) 4;
        Double result = d.calcular(c1, dias);
        Double descontoEsperado = 0.0;
        Assertions.assertEquals(descontoEsperado, result);
    }

    @Test
    public void Maior5() {
        Long dias = (long) 5;
        Double result = d.calcular(c1, dias);
        Double descontoEsperado = 0.5;
        Assertions.assertEquals(descontoEsperado, result);
    }

    @Test
    public void Maior10() {
        Long dias = (long) 11;
        Double result = d.calcular(c1, dias);
        Double descontoEsperado = 2.2;
        Assertions.assertEquals(descontoEsperado, result);
    }

    @Test
    public void DiaInvalido() {
        Long dias = (long) -1;
        Double result = d.calcular(c1, dias);
        Double descontoEsperado = 0.0;
        Assertions.assertEquals(descontoEsperado, result);
    }

}
