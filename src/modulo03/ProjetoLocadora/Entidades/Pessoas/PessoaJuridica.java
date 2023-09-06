package modulo03.ProjetoLocadora.Entidades.Pessoas;

public class PessoaJuridica extends Pessoa{
    private String cnpj;

    public PessoaJuridica (String nome, String cnpj, String endereco, String senha){
        super(nome,cnpj, endereco, senha);
    }

    public String toString() {
        return "PessoaJuridica{" +
                "nome='" + getNome() + '\'' +
                ", endereco='" + getEndereco() + '\'' +
                ", cnpj='" + cnpj + '\'' +
                '}';
    }
}
