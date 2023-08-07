package modulo02.aula02;

public class Cliente {

    String nome;
    String cpf;
    String email;

    public Cliente (String nome, String cpf, String email){
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Cliente cliente = (Cliente) obj;
        return cpf.equals(cliente.cpf);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


}
