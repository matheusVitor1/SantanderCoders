package modulo03.ProjetoLocadora.Services.Contracts;

import modulo03.ProjetoLocadora.Entidades.Pessoas.Funcionario;
import modulo03.ProjetoLocadora.Entidades.Pessoas.Pessoa;
import modulo03.ProjetoLocadora.Entidades.Pessoas.PessoaFisica;
import modulo03.ProjetoLocadora.Entidades.Pessoas.PessoaJuridica;

public interface PessoaService{
    Pessoa buscarPessoa(String identidade);

    boolean adicionarPessoa(Pessoa pessoa);

    boolean removerPessoa(String identidade);

    boolean editarPessoa(String nome, String identidade, String endereco);





}

