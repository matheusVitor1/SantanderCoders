package modulo02.aula07;

public class Main {
    public static void main(String[] args) {
        Pilha pilha = new PilhaArrayList();

        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        System.out.println("Próximo a ser desempilhado: " + pilha.peek());
        System.out.println("Desempilhado: " + pilha.pop());

        System.out.println("Próximo a ser desempilhado: " + pilha.peek());
        System.out.println("Desempilhado: " + pilha.pop());
    }
}