package com.bcopstein.TestDominio.Aluguel;

import com.bcopstein.Entidades.Dominio.Aluguel.Aluguel;
import com.bcopstein.Entidades.Dominio.Carro.Carro;
import com.bcopstein.Entidades.Dominio.Data.DataLocal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AluguelTest {
    Aluguel a1 = null;
    Carro c1 = null;
    DataLocal di = null;
    DataLocal df = null;

    @BeforeEach
    void setUp(){
        a1 = new Aluguel(false);
        c1 = new Carro("ACD1234", "VM", "saveiro",1, true, true, true, true);
        di = new DataLocal();
        df = new DataLocal();
        df.setMes(di.getMes()+1);
    }

    // testes com o aluguel cadastrado sem nenhum carro
    @Test
    public void testaGetCodigo(){
        Assertions.assertEquals(-1, a1.getCodigo());
    }

    @Test
    public void testaGetSubtotal(){
        Assertions.assertEquals(0.0, a1.getTotalDiarias());
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
        a1.fechaAluguel(500.0, 100.0, 150.0, 550.0, di, df, 30L);
        Assertions.assertEquals(500.0, a1.getTotalDiarias());
    }

    @Test
    public void testaGetDescontoModificado(){
        a1.fechaAluguel(500.0, 100.0, 150.0, 550.0, di, df, 30L);
        Assertions.assertEquals(100.0, a1.getdesconto());
    }

    @Test
    public void testaGetSeguroModificado(){
        a1.fechaAluguel(500.0, 100.0, 150.0, 550.0, di, df, 30L);
        Assertions.assertEquals(150.0, a1.getSeguro());
    }

    @Test
    public void testaGetValorFinalModificado(){
        a1.fechaAluguel(500.0, 100.0, 150.0, 550.0, di, df, 30L);
        Assertions.assertEquals(550.0, a1.getValorFinal());
    }

    @Test
    public void testaGetFechadoModificado(){
        a1.fechaAluguel(500.0, 100.0, 150.0, 550.0, di, df, 30L);
        Assertions.assertEquals(true, a1.isFechado());
    }
}
