/*
* Classe contendo as informacoes necessarias para um carro alugado
*
* @Author Miguel Zanela, Ismael Vargas, Rafael Mattone
*
* Version 1 dez, 2020
* 
*/
package com.bcopstein.Entidades.Dominio.Aluguel;

public class CarroAlugado {
    private String placa;
    private double valorFinal;

    public CarroAlugado(String placa, double valorFinal){
        this.placa = placa;
        this.valorFinal = valorFinal;
    }

    public String getPlaca() {
        return placa;
    }

    public double getValorFinal() {
        return valorFinal;
    }
}
