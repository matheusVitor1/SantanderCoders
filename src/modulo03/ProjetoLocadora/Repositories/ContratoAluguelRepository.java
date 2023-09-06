package modulo03.ProjetoLocadora.Repositories;

import modulo03.ProjetoLocadora.Entidades.Locadora.ContratoAluguel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContratoAluguelRepository {
    private List <ContratoAluguel> registroAluguelRepositoy;

    public ContratoAluguelRepository(){
        this.registroAluguelRepositoy = new ArrayList<>();
    }

    public void salvarAluguel(ContratoAluguel obj) {
        this.registroAluguelRepositoy.add(obj);
    }

    public void removerAluguel(ContratoAluguel obj) {
        this.registroAluguelRepositoy.remove(obj);
    }

    public List<ContratoAluguel> listarAlugueis() {

        return Collections.unmodifiableList(registroAluguelRepositoy);
    }

    public ContratoAluguel buscarAluguelPorData(LocalDateTime data) {
        for (ContratoAluguel registro : registroAluguelRepositoy) {
            if (registro.getDataLocacao().isEqual(data)) {
                return registro;
            }
        }
        return null;
    }

    public ContratoAluguel buscarAluguelPorIdentidade(String cpfCliente) {
        for (ContratoAluguel registro : registroAluguelRepositoy) {
            if (registro.getCliente().getIdentidade().equalsIgnoreCase(cpfCliente)) {
                return registro;
            }
        }
        return null;
    }

}
