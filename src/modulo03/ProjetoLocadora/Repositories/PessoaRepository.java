package modulo03.ProjetoLocadora.Repositories;

import modulo03.ProjetoLocadora.Entidades.Pessoas.Funcionario;
import modulo03.ProjetoLocadora.Entidades.Pessoas.Pessoa;
import modulo03.ProjetoLocadora.Entidades.Pessoas.PessoaFisica;
import modulo03.ProjetoLocadora.Entidades.Pessoas.PessoaJuridica;
import modulo03.ProjetoLocadora.Entidades.Veiculos.Carro;

import java.util.*;

import java.util.Iterator;

public class PessoaRepository {
    private List<Pessoa> pessoas;

    public PessoaRepository() {
        this.pessoas = new ArrayList<>();
    }

    public void salvarPessoa(Pessoa pessoa) {
        this.pessoas.add(pessoa);
    }

    public void removerPessoa(Pessoa pessoa) {
        this.pessoas.remove(pessoa);
    }

    public Pessoa buscarPessoaPorIdentidade(String identidade) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getIdentidade().equalsIgnoreCase(identidade)) {
                return pessoa;
            }
        }
        return null;
    }

    public boolean editarPessoa(String nome, String identidade, String endereco) {
        Pessoa pessoa = buscarPessoaPorIdentidade(identidade);
        if (pessoa != null) {
            pessoa.setNome(nome);
            pessoa.setEndereco(endereco);
            return true;
        }
        return false;
    }
}

