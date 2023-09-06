package modulo03.ProjetoLocadora.Entidades.Pessoas;

public class Funcionario extends Pessoa{
    private String identidade;

    public Funcionario(String nome, String identidade, String endereco, String senha){
        super(nome, identidade, endereco, senha);

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
                ", endereco='" + getEndereco() + '\'' +
                ", cnpj/cpf='" + identidade + '\'' +
                '}';
    }
}
