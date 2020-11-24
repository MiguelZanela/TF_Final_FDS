package com.bcopstein.Entidades.Dominio.Aluguel;

import java.util.LinkedList;
import java.util.List;

public class Aluguel {
    private int nroCarro = 1;
    private long codigo;
    private List<CarroAlugado> carros;
    private double subtotal;
    private double desconto;
    private double seguro;
    private double valorFinal;
    private boolean fechado;

    public Aluguel(){
        this.codigo = -1;
        this.carros = new LinkedList<>();
        this.subtotal = 0.0;
        this.desconto = 0.0;
        this.valorFinal = 0.0;
        this.fechado = false;
    }

    public long getCodigo(){
        return this.codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public double getSubtotal() {
        return subtotal;
    }
    
    public double getdesconto() {
        return desconto;
    }

    public double getSeguro() {
        return seguro;
    }
    
    public double getValorFinal() {
        return valorFinal;
    }
    
    public boolean isFechado() {
        return fechado;
    }

    public boolean insereCarro(String placa, double valorDiaria) {
        if (!fechado && carros.size() <1) {
          carros.add(new CarroAlugado(nroCarro, placa, valorDiaria));
          nroCarro++;
          return true;
        } else {
          return false;
        }
    }

    public boolean addCarros(List<CarroAlugado> Carros) {
        if (!fechado && carros.size() <1) {
          carros.addAll(Carros);
        }
        return false;
    }

    public void fechaAluguel(double subtotal, double desconto, double seguro, double valorFinal) {
        fechado = true;
        this.subtotal = subtotal;
        this.desconto = desconto;
        this.seguro = seguro;
        this.valorFinal = valorFinal;
    }
}
