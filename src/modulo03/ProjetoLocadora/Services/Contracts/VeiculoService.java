package modulo03.ProjetoLocadora.Services.Contracts;

import modulo03.ProjetoLocadora.Entidades.Veiculos.Carro;
import modulo03.ProjetoLocadora.Entidades.Veiculos.Veiculo;


import java.math.BigDecimal;
import java.util.List;

public interface VeiculoService {
    Veiculo buscarVeiculoPorNome(String nome);

    Veiculo buscarVeiculoPorPlaca(String placa);
    boolean adicionarVeiculo(Veiculo veiculo);
    boolean removerVeiculo(String placa);
    boolean editarVeiculo(String nome, String modelo, String placa, BigDecimal precoAluguel, String porte);
    BigDecimal definirPrecoDiariaCarro(String placa);
    List<Carro> listarCarrosEmOrdemAlfabetica();

}
