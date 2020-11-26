package com.bcopstein.Interface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.bcopstein.CasosDeUso.ControleDeAluguel;
import com.bcopstein.Entidades.Dominio.Aluguel.Aluguel;
import com.bcopstein.Entidades.Dominio.Aluguel.CarroAlugado;
import com.bcopstein.Entidades.Dominio.Carro.Carro;
import com.bcopstein.Interface.DTO.CarroCustoDTO;
import com.bcopstein.Interface.DTO.FiltroDTO;
import com.bcopstein.Interface.DTO.MapeadorCarro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/locadora")
public class LocadoraController {
  private ControleDeAluguel ctrlAluguel;
  private MapeadorCarro mapeadorCarro;

  @Autowired
  public LocadoraController(ControleDeAluguel ctrlAluguel, MapeadorCarro mapeadorCarro){
    this.ctrlAluguel = ctrlAluguel;
    this.mapeadorCarro = mapeadorCarro;
  }

  @GetMapping("/carrosDisponiveis")
  @CrossOrigin(origins = "*")
  public List<CarroCustoDTO> carrosDisponiveis(FiltroDTO filtro) {
    // Está selecionando pelos equipamentos e se esta disponivel ou nao
    // Não está verificando se o carro está livre naquelas datas
    if(ctrlAluguel.validaDatas(filtro.getInicioLocacao(), filtro.getFimLocacao())){
      List<Carro> disponiveis = ctrlAluguel.listaCarros().stream()
      .filter(c->c.getStatusCarro() == true)
      .filter(c->c.isArcondicionado() == filtro.isArcondicionado())
      .filter(c->c.isDirecao() == filtro.isDirecao())
      .filter(c->c.isCambioautomatico() == filtro.isCambio())
      .collect(Collectors.toList());
    List<CarroCustoDTO> informacoes = new ArrayList<>(disponiveis.size());
    long diasLocacao = ctrlAluguel.getDiasLocacao(filtro.getInicioLocacao(), filtro.getFimLocacao());
    disponiveis.forEach(c->{
          informacoes.add(new CarroCustoDTO(filtro.getInicioLocacao(),
                                            filtro.getFimLocacao(),
                                            c.getPlaca(),
                                            c.getMarca(),
                                            c.getModelo(),
                                            c.isArcondicionado(),
                                            c.isDirecao(),
                                            c.isCambioautomatico(),
                                            ctrlAluguel.getTotalDiarias(c, diasLocacao), // Total das diárias
                                            ctrlAluguel.getTotalSeguro(c, diasLocacao),  // Custo do seguro
                                            ctrlAluguel.getTotalDesconto(c, diasLocacao),   // Total do desconto aplicado apenas sobre o total das diarias
                                            ctrlAluguel.getTotal(c, diasLocacao))); // Valor a pagar
      });
      return informacoes;
    }
    return null;
  }

  @PostMapping("/confirmaLocacao")
  @CrossOrigin(origins = "*")
  public boolean confirmaLocacao(@RequestBody final CarroCustoDTO carroDTO) {
    CarroAlugado carroAlugado = mapeadorCarro.CarroCustoToCarroAlugado(carroDTO);
    return ctrlAluguel.confirmaAluguel(carroAlugado, carroDTO.getInicioLocacao(), carroDTO.getFimLocacao());
  }

  @PostMapping("/devolveCarro")
  @CrossOrigin(origins = "*")
  public boolean confirmaLocacao(@RequestParam final String placa) {    
    return ctrlAluguel.devolveCarro(placa);
  }

  @PostMapping("/mudaSeguro")
  @CrossOrigin(origins = "*")
  public boolean mudaSeguro(@RequestParam final Integer nroseg, Long regra) {    
    return ctrlAluguel.cadastraSeguro(nroseg, regra);
  }

  @PostMapping("/mudaDesconto")
  @CrossOrigin(origins = "*")
  public boolean mudaDesconto(@RequestParam final Integer nrodesc, Long regra) {    
    return ctrlAluguel.cadastraDesconto(nrodesc, regra);
  }

  @PostMapping("/listaCarros")
  @CrossOrigin(origins = "*")
  public Collection<Carro> listaCarros() {    
    return ctrlAluguel.listaCarros();
  }

  @PostMapping("/listaAlugueis")
  @CrossOrigin(origins = "*")
  public Collection<Aluguel> listaAlugueis() {    
    return ctrlAluguel.listaAlugueis();
  }

}
