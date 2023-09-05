package modulo03.ProjetoLocadora.Entidades.Pessoas;

public abstract class Pessoa {

    private int idade;
    private String nome;
    private String endereco;
    private String senha;
    public Pessoa(String nome, int idade, String endereco, String senha){
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
        this.senha = senha;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "idade=" + idade +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}
