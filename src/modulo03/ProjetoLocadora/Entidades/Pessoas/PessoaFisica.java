package modulo03.ProjetoLocadora.Entidades.Pessoas;

public class PessoaFisica extends Pessoa {
    private String cpf;

    public PessoaFisica(String nome, int idade, String cpf, String endereco, String senha){
        super(nome,idade,endereco,senha);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "PessoaFisica{" +
                "nome='" + getNome() + '\'' +
                ", idade=" + getIdade() +
                ", endereco='" + getEndereco() + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }

}
