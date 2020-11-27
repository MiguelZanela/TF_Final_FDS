/*
* Classe com os edpoints da configuracao de seguro e desconto
*
* @Author Miguel Zanela, Ismael Vargas, Rafael Mattone
*
* Version 1 dez, 2020
* 
*/
package com.bcopstein.Interface;

import java.util.Collection;

import com.bcopstein.CasosDeUso.ControleDeAluguel;
import com.bcopstein.CasosDeUso.ItemConfiguracao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Configuracao")
public class ConfiguracaoEndPoints {
  private ControleDeAluguel ctrlAluguel;

  @Autowired
  public ConfiguracaoEndPoints(ControleDeAluguel ctrlAluguel) {
    this.ctrlAluguel = ctrlAluguel;
  }  

  //muda configuracao, por hora do seguro ou desconto
  @PostMapping("/mudaConfig")
  @CrossOrigin(origins = "*")
  public boolean mudaConfig(@RequestParam final String chave, Long regra) {    
    return ctrlAluguel.cadastraItemConfiguracao(chave, regra);
  }

  //envia a lista de carros da locadora
  @PostMapping("/listaConfiguracoes")
  @CrossOrigin(origins = "*")
  public Collection<ItemConfiguracao> listaConfiguracao() {    
    return ctrlAluguel.listaConfiguracao();
  }

}
