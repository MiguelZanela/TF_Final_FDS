package com.bcopstein.Entidades.Dominio.Aluguel;

import com.bcopstein.Entidades.Dominio.Data.DataLocal;

public class Aluguel {
    private Long codigo;
    private CarroAlugado carro;
    private Long totalDiasAlugado;
    private double totalDiarias;
    private double desconto;
    private double seguro;
    private double valorFinal;
    private DataLocal inicioLocacao;
    private DataLocal fimLocacao;
    private boolean fechado;
    private boolean carroDevolvido;

    protected Aluguel(){}

    public Aluguel(boolean fechado){
        this.codigo = -1L;
        this.carro = null;
        this.totalDiarias = 0.0;
        this.desconto = 0.0;
        this.valorFinal = 0.0;
        this.totalDiasAlugado = 0L;
        this.fechado = fechado;
        this.carroDevolvido = false;
    }

    public long getCodigo(){
        return this.codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public double getTotalDiarias() {
        return totalDiarias;
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

    public Long getTotalDiasAlugado() {
        return totalDiasAlugado;
    }
    
    public boolean isFechado() {
        return fechado;
    }

    public boolean isCarroDevolvido(){
        return carroDevolvido;
    }    

    public void carroDevolvido(Boolean carroDevolvido){
        this.carroDevolvido = carroDevolvido;
    }

    public DataLocal getDataInicioLocacao() {
        return inicioLocacao;
    }

    public DataLocal getDataFimLocacao() {
        return fimLocacao;
    }

    public CarroAlugado getCarroAlugado() {
        return carro;
    }

    public boolean insereCarro(CarroAlugado carroAlugado) {
        if (!fechado) {
            this.carro = carroAlugado;
            return true;
        } else {
            return false;
        }
    }

    public void fechaAluguel(double totalDiarias, double desconto, double seguro, double valorFinal, DataLocal inicoLocacao, DataLocal fimLocacao, Long totalDiasAlugado) {
        fechado = true;
        this.totalDiarias = totalDiarias;
        this.desconto = desconto;
        this.seguro = seguro;
        this.valorFinal = valorFinal;
        this.inicioLocacao = inicoLocacao;
        this.fimLocacao = fimLocacao;
        this.totalDiasAlugado = totalDiasAlugado;
    }
}
