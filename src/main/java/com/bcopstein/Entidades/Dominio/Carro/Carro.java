/*
* Classe contendo as informacoes necessarias para um carro
*
* @Author Miguel Zanela, Ismael Vargas, Rafael Mattone
*
* Version 1 dez, 2020
* 
*/
package com.bcopstein.Entidades.Dominio.Carro;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Carro {
    @Id
    private String placa;
    private String marca;
    private String modelo;
    private double valordiaria;
    private boolean arcondicionado;
    private boolean direcao;
    private boolean cambioautomatico;
    private boolean carrodisponivel;

    protected Carro(){}

    public Carro(String placa, String marca, String modelo, double valordiaria, boolean arcondicionado, boolean direcao, boolean cambioautomatico, boolean carrodisponivel) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.valordiaria = valordiaria;
        this.arcondicionado = arcondicionado;
        this.direcao = direcao;
        this.cambioautomatico = cambioautomatico;
        this.carrodisponivel = carrodisponivel;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public boolean isArcondicionado() {
        return arcondicionado;
    }

    public boolean isDirecao() {
        return direcao;
    }

    public boolean isCambioautomatico() {
        return cambioautomatico;
    }

    public double getValordiaria() {
        return valordiaria;
    }

    public boolean getStatusCarro() {
        return carrodisponivel;
    }

    public void setStatusCarro(boolean carrodisponivel) {
        this.carrodisponivel = carrodisponivel;
    }

    @Override
    public String toString() {
        return "Carro [arcondicionado=" + arcondicionado + ", cambioautomatico=" + cambioautomatico + ", direcao="
                + direcao + ", marca=" + marca + ", modelo=" + modelo + ", placa=" + placa + "]";
    } 
}
