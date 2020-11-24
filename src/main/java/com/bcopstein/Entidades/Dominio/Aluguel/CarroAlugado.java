package com.bcopstein.Entidades.Dominio.Aluguel;

import com.bcopstein.Entidades.Dominio.Data.DataLocal;

public class CarroAlugado {
    private int nro;
    private String placa;
    private double valorFinal;
    private DataLocal inicioLocacao;
    private DataLocal fimLocacao;

    public CarroAlugado(int nroCarro, String placa, double valorFinal){
        this.nro = nroCarro;
        this.placa = placa;
        this.valorFinal = valorFinal;
    }

    public int getNro() {
        return nro;
    }

    public String getPlaca() {
        return placa;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public DataLocal getDataInicioLocacao() {
        return inicioLocacao;
    }

    public DataLocal getDataFimLocacao() {
        return fimLocacao;
    }
}
