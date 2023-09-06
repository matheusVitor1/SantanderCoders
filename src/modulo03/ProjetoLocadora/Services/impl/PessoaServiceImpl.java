package modulo03.ProjetoLocadora.Services.impl;

import modulo03.ProjetoLocadora.Entidades.Pessoas.Pessoa;
import modulo03.ProjetoLocadora.Repositories.PessoaRepository;
import modulo03.ProjetoLocadora.Services.Contracts.PessoaService;

public class PessoaServiceImpl implements PessoaService {
    private PessoaRepository pessoaRepository;

    public PessoaServiceImpl(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public Pessoa buscarPessoa(String identidade) {
        return pessoaRepository.buscarPessoaPorIdentidade(identidade);
    }

    @Override
    public boolean adicionarPessoa(Pessoa pessoa) {
        String identidade = pessoa.getIdentidade();
        if (buscarPessoa(identidade) == null) {
            pessoaRepository.salvarPessoa(pessoa);
            return true;
        }
        return false;
    }

    @Override
    public boolean removerPessoa(String identidade) {
        Pessoa pessoa = buscarPessoa(identidade);
        if (pessoa != null) {
            pessoaRepository.removerPessoa(pessoa);
            return true;
        }
        return false;
    }

    @Override
    public boolean editarPessoa(String nome, String identidade, String endereco) {
        Pessoa pessoa = buscarPessoa(identidade);
        if (pessoa != null) {
            pessoa.setNome(nome);
            pessoa.setEndereco(endereco);
            return true;
        }
        return false;
    }
}
