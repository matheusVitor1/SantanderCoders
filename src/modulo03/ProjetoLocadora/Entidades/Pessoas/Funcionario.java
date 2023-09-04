package modulo03.ProjetoLocadora.Entidades.Pessoas;

public class Funcionario extends Pessoa{
    private String identidade;

    public Funcionario(String nome, int idade, String identidade, String endereco, String senha){
        super(nome, idade, endereco, senha);
        this.identidade = identidade;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    public String toString() {
        return "Funcionario{" +
                "nome='" + getNome() + '\'' +
                ", idade=" + getIdade() +
                ", endereco='" + getEndereco() + '\'' +
                ", cnpj/cpf='" + identidade + '\'' +
                '}';
    }
}
