package modulo02.aula07;

class PilhaArrayList extends Pilha {
    @Override
    public void push(int valor) {
        elementos.add(valor);
    }

    @Override
    public int pop() {
        if (elementos.isEmpty()) {
            throw new IllegalStateException("Pilha vazia");
        }
        return elementos.remove(elementos.size() - 1);
    }

    @Override
    public int peek() {
        if (elementos.isEmpty()) {
            throw new IllegalStateException("Pilha vazia");
        }
        return elementos.get(elementos.size() - 1);
    }
}