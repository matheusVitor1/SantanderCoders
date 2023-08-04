package modulo02.aula01;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class Agenda {
    private List<Contato> contatos;

    public Agenda() {
        contatos = new ArrayList<>();
    }

    public void adicionar(Contato contato) {
        contatos.add(contato);
    }

    public void deletar(Contato contato) {
        contatos.remove(contato);
    }

    public Contato buscar(String nome) {
        for (Contato contato : contatos) {
            if (contato.getNome().equals(nome)) {
                return contato;
            }
        }
        return null;
    }
}
