package modulo02.aula01;


public class Contato {
    private String nome;
    private String numero;

    public Contato(String nome, String numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public void ligar() {
        System.out.println("Ligando para " + nome + " - " + numero);
    }

    public void detalhar() {
        System.out.println("Detalhes do contato:\nNome: " + nome + "\nNúmero: " + numero);
    }

    public String verNumero() {
        return numero;
    }
    public String getNome() {
        return nome;
    }

}
