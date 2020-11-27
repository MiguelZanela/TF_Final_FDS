/*
* Classe que mantem as exceptions da aplicacao
*
* @Author Miguel Zanela, Ismael Vargas, Rafael Mattone
*
* Version 1 dez, 2020
* 
*/
package com.bcopstein.Entidades.Dominio.Exceptions;

public class SistAlugueisException extends IllegalArgumentException {
    private static final long serialVersionUID = 1L;

    public enum Causa {
        ALUGUEL_INEXISTENTE,
        NRODESC_DUPLICADO,
        NROSEG_DUPLICADO
    };
    private Causa causa;

    public SistAlugueisException(Causa causa){
        super(causa.toString());
        this.causa = causa;
    }

    public Causa getCausa(){
        return causa;
    }
}
