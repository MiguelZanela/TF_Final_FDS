package com.bcopstein.CasosDeUso;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collection;

import com.bcopstein.CasosDeUso.FactorySeguroDesconto.ConfigRegraDesconto;
import com.bcopstein.CasosDeUso.FactorySeguroDesconto.ConfigRegraSeguro;
import com.bcopstein.Entidades.Dominio.Aluguel.Aluguel;
import com.bcopstein.Entidades.Dominio.Aluguel.CarroAlugado;
import com.bcopstein.Entidades.Dominio.Carro.Carro;
import com.bcopstein.Entidades.Dominio.Data.DataLocal;
import com.bcopstein.Entidades.Repositorio.Alugueis;
import com.bcopstein.Entidades.Repositorio.Carros;
import com.bcopstein.Entidades.Repositorio.Descontos;
import com.bcopstein.Entidades.Repositorio.Seguros;
import com.bcopstein.Entidades.Servicos.ServicosDeAluguel;
import com.bcopstein.Entidades.Servicos.ServicosDeCarros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ControleDeAluguel {
    private Carros carros;
    private Alugueis alugueis;
    private ServicosDeAluguel srvAluguel;
    private ServicosDeCarros srvCarros;
    private DataLocal dataLocal;
    private Descontos desconto;
    private Seguros seguro;


    @Autowired
    public ControleDeAluguel(Carros carros, ServicosDeAluguel srvAluguel, ServicosDeCarros srvCarros, Alugueis alugueis, DataLocal dataLocal, 
                                Descontos desconto, Seguros seguro){
        this.carros = carros;
        this.srvAluguel = srvAluguel;
        this.alugueis = alugueis;
        this.srvCarros = srvCarros;
        this.dataLocal = dataLocal;
        this.desconto = desconto;
        this.seguro = seguro;
    }

    public Collection<Carro> listaCarros() {
        return carros.todos();
    }

    public Carro getCarro(String chave) {
        return carros.recupera(chave);
    }

    public Collection<Aluguel> listaAlugueis() {
        return alugueis.todos();
    }

    public Aluguel getAluguel(Long chave) {
        return alugueis.recupera(chave);
    }

    public Collection<ConfigRegraDesconto> listaRegraDesconto() {
        return desconto.todos();
    }

    public ConfigRegraDesconto getDesconto(Integer chave) {
        return desconto.recupera(chave);
    }

    public Collection<ConfigRegraSeguro> listaRegraSeguro() {
        return seguro.todos();
    }

    public ConfigRegraSeguro getSeguro(Integer chave) {
        return seguro.recupera(chave);
    }

    //valida as datas recebidas do front
    public boolean validaDatas(DataLocal inicioLocacao, DataLocal fimLocacao){
		if(inicioLocacao.getDia() >= dataLocal.getDia() && inicioLocacao.getMes() >= dataLocal.getMes() && inicioLocacao.getAno() >= dataLocal.getAno() && 
            fimLocacao.getDia() >= inicioLocacao.getDia() && fimLocacao.getMes() >= inicioLocacao.getMes() && fimLocacao.getAno() >= inicioLocacao.getAno()){                
            return true;
        }
        return false;
    }

    //recebe duas datas e devolve o total de dias entre essas duas datas
    public long getDiasLocacao(DataLocal inicioLocacao,DataLocal fimLocacao){
        long dias = 0;
        String anoIni = inicioLocacao.getAno()+"-";
        String mesIni = inicioLocacao.getMes()+"-";
        String diaIni = inicioLocacao.getDia()+"";
        String anoFim = fimLocacao.getAno()+"-";
        String mesFim = fimLocacao.getMes()+"-";
        String diaFim = fimLocacao.getDia()+"";
        LocalDate iniLoc = LocalDate.parse(anoIni+mesIni+diaIni);
        LocalDate fimLoc = LocalDate.parse(anoFim+mesFim+diaFim);
        dias = ChronoUnit.DAYS.between(iniLoc, fimLoc);
        return dias;
    }

    //devolve o valor total da diaria do carro * o o total de dias da locacao
    public int getTotalDiarias (Carro carro, Long diasLocacao){
        return srvAluguel.calculaTotalDiarias(carro, diasLocacao);        
    }

    //devolve o valor total do desconto aplicado nessa locacao para esse carro
    public int getTotalDesconto (Carro carro, Long diasLocacao){
        return srvAluguel.calculaDesconto(carro, diasLocacao);        
    }

    //devolve o valor total do seguro aplicado nessa locacao para esse carro
    public int getTotalSeguro (Carro carro, Long diasLocacao){
        return srvAluguel.calculaSeguro(carro, diasLocacao);        
    }

    //devolve o valor total do aluguel
    public int getTotal (Carro carro, Long diasLocacao){
        return srvAluguel.calculaValorFinal(carro, diasLocacao);        
    }

    //cria o aluguel, salva as informacoes e salva o aluguel
    public boolean confirmaAluguel(CarroAlugado carroAlugado, DataLocal inicioLocacao, DataLocal fimLocacao){
        Aluguel aluguel = new Aluguel(false); // cria aluguel não finalizado
        aluguel.insereCarro(carroAlugado); //insere o carro no aluguel
        srvCarros.setCarroOcupado(carroAlugado.getPlaca()); //coloca o carro como ocupado
        Carro carro = getCarro(carroAlugado.getPlaca()); // cria um carro para passar por parametro
        Long diasLocacao = getDiasLocacao(inicioLocacao, fimLocacao); // calcula os dias de locacao total do aluguel para passar por parametro
        aluguel.fechaAluguel(getTotalDiarias(carro, diasLocacao), // salva o total das diarias
                             getTotalDesconto(carro, diasLocacao), // salva o total do desconto
                             getTotalSeguro(carro, diasLocacao), // salva o total do seguro
                             getTotal(carro, diasLocacao), // salva o total do aluguel
                             inicioLocacao, //salva a data de inicio da locacao
                             fimLocacao, //salva a data de fim da locacao
                             diasLocacao); //salva o total de dias do aluguel
        alugueis.cadastra(aluguel); //cadastra o aluguel
        return true;        
    }

    //recebe uma placa, verifica se o carro estava alugado, tira o carro de ocupado
    public boolean devolveCarro(String placa){
        for(Carro it: listaCarros()){ //passa na lista de carros
            if(it.getPlaca().toUpperCase().equals(placa.toUpperCase()) && it.getStatusCarro() == false){ //verifica se existe algum carro com a placa igual e se esta ocupado
                for(Aluguel alu: listaAlugueis()){//passa na lista de alugueis
                    if(alu.getCarroAlugado().getPlaca().toUpperCase().equals(placa.toUpperCase()) && alu.isCarroDevolvido() == false){//procura em algueis por uma placa igual e verifica se o carro ja foi devolvido para aquele aluguel
                        srvCarros.setCarroLivre(getCarro(placa).getPlaca());//coloca o carro como livre
                        alu.carroDevolvido(true);//coloca no aluguel que o carro foi devolvido
                        return true;                        
                    }
                }
            }
        }
        return false;        
    }

    //recebe um id e um numero do tipo de seguro a ser aplicado e salva
    public boolean cadastraSeguro(Integer nroseguro, Long regra){
        ConfigRegraSeguro c1 = new ConfigRegraSeguro(nroseguro, regra);// cria a configuracao da regra do seguro
        if(seguro.cadastra(c1)){// verifica se o cadastro do seguro foi efetuado
            return true;
        }
        return false;
    }

    //recebe um id e um numero do tipo de desconto a ser aplicado e salva
    public boolean cadastraDesconto(Integer nrodesc, Long regra){
        ConfigRegraDesconto d1 = new ConfigRegraDesconto(nrodesc, regra);// cria a configuracao da regra de desconto
        if(desconto.cadastra(d1)){// verifica se o cadastro do desconto foi efetuado
            return true;
        }
        return false;
    }
    
}
