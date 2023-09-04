package modulo03.ProjetoLocadora.Entidades.Pessoas;

public class PessoaJuridica extends Pessoa{
    private String cnpj;

    public PessoaJuridica (String nome, int idade, String cnpj, String endereco, String senha){
        super(nome,idade,endereco, senha);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String toString() {
        return "PessoaJuridica{" +
                "nome='" + getNome() + '\'' +
                ", idade=" + getIdade() +
                ", endereco='" + getEndereco() + '\'' +
                ", cnpj='" + cnpj + '\'' +
                '}';
    }
}
