package modulo02.ProjetoRestaurante.Entidades;

public class Pratos {

    private String nomePrato;
    private String id;
    private double valor;



    public Pratos (String id, String nomePrato, double valor){
        this.nomePrato = nomePrato;
        this.id = id;
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getNomePrato() {
        return nomePrato;
    }

    public void setNomePrato(String nomePrato) {
        this.nomePrato = nomePrato;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Pratos pratos = (Pratos) obj;
        return id.equals(pratos.id);
    }

    @Override
    public String toString() {
        return "Pratos{" +
                "id ='" + id + '\'' +
                ", nome ='" + nomePrato + '\'' +
                ", valor ='" + valor + '\'' +
                '}';
    }
}
