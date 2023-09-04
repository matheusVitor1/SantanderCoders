package modulo02.ProjetoRestaurante.Entidades;

import java.util.List;
import java.util.ArrayList;

public class Restaurante {

    private String cnpj;
    private String nome;
    private String endereco;
    private List<Pratos> pratos;

    public Restaurante (String cnpj, String nome, String endereco){
        this.cnpj = cnpj;
        this.nome = nome;
        this.endereco = endereco;
        this.pratos = new ArrayList<>();
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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

    public List<Pratos> getPratos() {
        return pratos;
    }

    public void setPratos(List<Pratos> pratos) {
        this.pratos = pratos;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Restaurante rest = (Restaurante) obj;
        return cnpj.equals(rest.cnpj);
    }

    @Override
    public String toString() {
        return "Restaurante{" +
                "cnpj ='" + cnpj + '\'' +
                ", nome ='" + nome + '\'' +
                ", endereco ='" + endereco + '\'' +
                ", pratos = '" + pratos + '\'';
    }

    public void adicionarPrato(Pratos prato) {
        pratos.add(prato);
    }

}
