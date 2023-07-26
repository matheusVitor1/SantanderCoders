package aula07;

public class Ex01 {
    public enum Semana {
        DOMINGO(new String[]{"domingo", "dom"}, 1),
        SEGUNDA(new String[]{"segunda-feira","seg"}, 2),
        TERCA(new String[]{"terça-feira","ter"}, 3),
        QUARTA(new String[]{"quarta-feira", "qua"}, 4),
        QUINTA(new String[]{"quinta-feira", "qui"}, 5),
        SEXTA(new String[]{"sexta-feira", "sex"}, 6),
        SABADO(new String[]{"sábado", "sab"}, 7);

        final String[] nome;
        final int dia;

        Semana(String[] nome, int dia) {
            this.nome = nome;
            this.dia = dia;
        }

        public String[] getNome() {
            return nome;
        }

        public int getDia() {
            return dia;
        }

        public static Semana stringParaEnum(String nome) {
            for (Semana dia : Semana.values()) {
                for (String n : dia.getNome()) {
                    if (n.equalsIgnoreCase(nome)) {
                        return dia;
                    }
                }
            }

            throw new IllegalArgumentException(nome + " informado é inválido");
        }

        public static void main(String[] args) {
            String nomeDia = "sex";
            Semana diaEnum = Semana.stringParaEnum(nomeDia);

            System.out.println("Dia: " + diaEnum.getNome()[0]);
            System.out.println("Número do Dia: " + diaEnum.getDia());
        }
    }
}
