package modulo02.aula07;

import java.util.ArrayList;

abstract class Pilha {
    protected ArrayList<Integer> elementos;

    public Pilha() {
        elementos = new ArrayList<>();
    }

    public abstract void push(int valor);

    public abstract int pop();

    public abstract int peek();
}