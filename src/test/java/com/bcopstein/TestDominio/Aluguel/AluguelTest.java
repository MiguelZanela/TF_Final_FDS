package com.bcopstein.TestDominio.Aluguel;

import com.bcopstein.Entidades.Dominio.Aluguel.Aluguel;
import com.bcopstein.Entidades.Dominio.Carro.Carro;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AluguelTest {
    Aluguel a1 = null;
    Carro c1 = null;

    @BeforeEach
    void setUp(){
        a1 = new Aluguel();
        c1 = new Carro("ACD1234", "VM", "saveiro",1, true, true, true, true);
    }

    // testes com o aluguel cadastrado sem nenhum carro
    @Test
    public void testaGetCodigo(){
        Assertions.assertEquals(-1, a1.getCodigo());
    }

    @Test
    public void testaGetSubtotal(){
        Assertions.assertEquals(0.0, a1.getSubtotal());
    }

    @Test
    public void testaGetDesconto(){
        Assertions.assertEquals(0.0, a1.getdesconto());
    }

    @Test
    public void testaGetSeguro(){
        Assertions.assertEquals(0.0, a1.getSeguro());
    }

    @Test
    public void testaGetValorFinal(){
        Assertions.assertEquals(0.0, a1.getValorFinal());
    }

    @Test
    public void testaGetFechado(){
        Assertions.assertEquals(false, a1.isFechado());
    }

    // testes com o aluguel cadastrado alterando os valores    
    @Test
    public void testaGetCodigoModificado(){
        a1.setCodigo(100L);
        Assertions.assertEquals(100L, a1.getCodigo());
    }

    @Test
    public void testaGetSubtotalModificado(){
        a1.fechaAluguel(500.0, 100.0, 150.0, 550.0);
        Assertions.assertEquals(500.0, a1.getSubtotal());
    }

    @Test
    public void testaGetDescontoModificado(){
        a1.fechaAluguel(500.0, 100.0, 150.0, 550.0);
        Assertions.assertEquals(100.0, a1.getdesconto());
    }

    @Test
    public void testaGetSeguroModificado(){
        a1.fechaAluguel(500.0, 100.0, 150.0, 550.0);
        Assertions.assertEquals(150.0, a1.getSeguro());
    }

    @Test
    public void testaGetValorFinalModificado(){
        a1.fechaAluguel(500.0, 100.0, 150.0, 550.0);
        Assertions.assertEquals(550.0, a1.getValorFinal());
    }

    @Test
    public void testaGetFechadoModificado(){
        a1.fechaAluguel(500.0, 100.0, 150.0, 550.0);
        Assertions.assertEquals(true, a1.isFechado());
    }
}
