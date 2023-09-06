package modulo03.ProjetoLocadora.Entidades.Pessoas;

public class PessoaFisica extends Pessoa {

    public PessoaFisica(String nome, String cpf, String endereco, String senha){
        super(nome,cpf, endereco,senha);
    }

    @Override
    public String toString() {
        return "PessoaFisica{" +
                "nome='" + getNome() + '\'' +
                ", endereco='" + getEndereco() + '\'' +
                ", cpf='" + getIdentidade() + '\'' +
                '}';
    }

}
