package com.bcopstein.TestDominio.Carro;

import com.bcopstein.Entidades.Dominio.Carro.Carro;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarroTest {
    Carro c1 = null;

    @BeforeEach
    void setUp(){
        c1 = new Carro("ACD1234", "VM", "saveiro",1 , true, true, true, true);
    }

    @Test
    public void testaGetStatusCarroInicial(){
        Assertions.assertEquals(true, c1.getStatusCarro());
    }

    @Test
    public void testaGetStatusCarroModificado(){
        c1.setStatusCarro(false);
        Assertions.assertEquals(false, c1.getStatusCarro());
    }
}
