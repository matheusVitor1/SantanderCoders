package modulo03.ProjetoLocadora.Repositories;

import modulo03.ProjetoLocadora.Entidades.Pessoas.Funcionario;
import modulo03.ProjetoLocadora.Entidades.Pessoas.PessoaFisica;
import modulo03.ProjetoLocadora.Entidades.Pessoas.PessoaJuridica;
import modulo03.ProjetoLocadora.Entidades.Veiculos.Carro;

import java.util.*;

import java.util.Iterator;

public class PessoaRepository {
    private List<PessoaJuridica> pessoaJuridica;
    private List<PessoaFisica> pessoaFisica;
    private List<Funcionario> funcionarios;

    public PessoaRepository (){
        this.pessoaJuridica = new ArrayList<>();
        this.pessoaFisica = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
    }

    public void cadastrarPJ(PessoaJuridica pessoaJuridica){
        this.pessoaJuridica.add(pessoaJuridica);
    }
    public void cadastrarPF(PessoaFisica pessoaFisica){
        this.pessoaFisica.add(pessoaFisica);
    }

    public void cadastrarFuncionario(Funcionario funcionario){
        this.funcionarios.add(funcionario);
    }

    public void removerPJ(PessoaJuridica pessoaJuridica) {
        Iterator<PessoaJuridica> iterator = this.pessoaJuridica.iterator();
        while (iterator.hasNext()) {
            PessoaJuridica atual = iterator.next();
            if (atual.getNome().equalsIgnoreCase(pessoaJuridica.getNome())) {
                iterator.remove();
                return;
            }
        }
    }

    public void removerPF(PessoaFisica pessoaFisica) {
        Iterator<PessoaFisica> iterator = this.pessoaFisica.iterator();
        while (iterator.hasNext()) {
            PessoaFisica atual = iterator.next();
            if (atual.getNome().equalsIgnoreCase(pessoaFisica.getNome())) {
                iterator.remove();
                return;
            }
        }
    }
    public void removerFuncionario(Funcionario funcionario) {
        Iterator<Funcionario> iterator = this.funcionarios.iterator();
        while (iterator.hasNext()) {
            Funcionario atual = iterator.next();
            if (atual.getNome().equalsIgnoreCase(funcionario.getNome())) {
                iterator.remove();
                return;
            }
        }
    }

    public List<PessoaJuridica> listarPJ() {
        return Collections.unmodifiableList(pessoaJuridica);
    }
    public List<PessoaFisica> listarPF() {
        return Collections.unmodifiableList(pessoaFisica);
    }

    public List<Funcionario> listarFuncionarips() {
        return Collections.unmodifiableList(funcionarios);
    }

    public PessoaJuridica buscarPJ(String cnpj) {
        for (PessoaJuridica pj : pessoaJuridica) {
            if (pj.getCnpj().equalsIgnoreCase(cnpj)) {
                return pj;
            }
        }
        return null;
    }

    public PessoaFisica buscarPF(String cpf) {
        for (PessoaFisica pf : pessoaFisica) {
            if (pf.getCpf().equalsIgnoreCase(cpf)) {
                return pf;
            }
        }
        return null;
    }

    public Funcionario buscarFuncionario(String identidade) {
        for (Funcionario func : funcionarios) {
            if (func.getIdentidade().equalsIgnoreCase(identidade)) {
                return func;
            }
        }
        return null;
    }
}
