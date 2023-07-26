package aula06;

public class Ex3 {
    public enum Semana {
        DOMINGO,
        SEGUNDA,
        TERCA,
        QUARTA,
        QUINTA,
        SEXTA,
        SABADO;
        public static Semana fromString(String nomeDia) {
            if (nomeDia == null) {
                throw new IllegalArgumentException("O nome do dia não pode ser nulo.");
            }

            String nomeDiaFormatado = nomeDia.trim().toUpperCase().replace("-", "_");

            for (Semana diaEnum : Semana.values()) {
                if (diaEnum.name().equals(nomeDiaFormatado)) {
                    return diaEnum;
                }
            }

            throw new IllegalArgumentException("Nome de dia inválido: " + nomeDia);
        }

    }


    public static void main(String[] args) {
        String nomeDia = "terça-feira";
        Semana diaEnum = Semana.fromString(nomeDia);
        System.out.println("Enum correspondente ao dia: " + diaEnum);
    }



}

