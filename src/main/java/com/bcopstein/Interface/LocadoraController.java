package com.bcopstein.Interface;

import java.util.Collection;
import java.util.List;

import com.bcopstein.CasosDeUso.ControleDeAluguel;
import com.bcopstein.Entidades.Dominio.Carro.Carro;
import com.bcopstein.Interface.DTO.CarroCustoDTO;
import com.bcopstein.Interface.DTO.FiltroDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/locadora")
public class LocadoraController {
  private ControleDeAluguel ctrlAluguel;

  @Autowired
  public LocadoraController(ControleDeAluguel ctrlAluguel){
    this.ctrlAluguel = ctrlAluguel;
  }

  @GetMapping("/carrosDisponiveis")
  @CrossOrigin(origins = "*")
  public List<CarroCustoDTO> carrosDisponiveis(FiltroDTO filtro) {
    if(ctrlAluguel.validaDatas(filtro)){      
      return ctrlAluguel.getInformacoes(filtro);
    }
    return null;
  }

  @PostMapping("/confirmaLocacao")
  @CrossOrigin(origins = "*")
  public boolean confirmaLocacao(@RequestBody final CarroCustoDTO carro) {
    // Está confirmando qualquer coisa
    return true;
  }

  @PostMapping("/listaCarros")
  @CrossOrigin(origins = "*")
  public Collection<Carro> listaCarros() {    
    return ctrlAluguel.listaCarros();
  }

}
