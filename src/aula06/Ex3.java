package aula06;

public class Ex3 {
    public enum Semana {
        DOMINGO("domingo", 1),
        SEGUNDA("segunda-feira", 2),
        TERCA("terça-feira", 3),
        QUARTA("quarta-feira", 4),
        QUINTA("quinta-feira", 5),
        SEXTA("sexta-feira", 6),
        SABADO("sábado", 7);

        final String nome;
        final int dia;

        Semana(String nome, int dia) {
            this.nome = nome;
            this.dia = dia;
        }

        public String getNome() {
            return nome;
        }

        public int getDia() {
            return dia;
        }

        public static Semana stringParaEnum(String nome) {
            for (Semana dia : Semana.values()) {
                if (dia.getNome().equalsIgnoreCase(nome)) {
                    return dia;
                }
            }

            throw new IllegalArgumentException(nome + " informado é inválido");
        }

        public static void main(String[] args) {
            String nomeDia = "terça-feira";
            Semana diaEnum = Semana.stringParaEnum(nomeDia);

            System.out.println("Dia: " + diaEnum.getNome());
            System.out.println("Número do Dia: " + diaEnum.getDia());
        }
    }




}

