package modulo04;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Atividade01 {
    public static void main(String[] args) {
        exercicio1();
        exercicio2();
        exercicio3();
    }

    // Exercício 1: Transformando Strings em Datas
    public static void exercicio1() {
        List<String> datasStrings = new ArrayList<>();
        datasStrings.add("2023-08-10");
        datasStrings.add("2022-05-20");
        datasStrings.add("2021-11-30");

        List<LocalDate> datas = new ArrayList<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (String dataString : datasStrings) {
            LocalDate data = LocalDate.parse(dataString, formatter);
            datas.add(data);
        }

        System.out.println("Exercício 1 - Datas formatadas:");
        for (LocalDate data : datas) {
            System.out.println(data);
        }
        System.out.println();
    }

    // Exercício 2: Formatar datas no formato "dd/MM/yyyy"
    public static void exercicio2() {
        List<LocalDate> datas = new ArrayList<>();
        datas.add(LocalDate.of(2023, 8, 10));
        datas.add(LocalDate.of(2022, 5, 20));
        datas.add(LocalDate.of(2021, 11, 30));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Exercício 2 - Datas formatadas:");
        for (LocalDate data : datas) {
            String dataFormatada = data.format(formatter);
            System.out.println(dataFormatada);
        }
        System.out.println();
    }

    // Exercício 3: Converter para fusos horários
    public static void exercicio3() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        ZonedDateTime newYorkTime = zonedDateTime.withZoneSameInstant(ZoneId.of("America/New_York"));
        ZonedDateTime parisTime = zonedDateTime.withZoneSameInstant(ZoneId.of("Europe/Paris"));
        ZonedDateTime tokyoTime = zonedDateTime.withZoneSameInstant(ZoneId.of("Asia/Tokyo"));

        System.out.println("Exercício 3 - Fusos horários:");
        System.out.println("Hora atual no fuso horário padrão: " + zonedDateTime);
        System.out.println("Hora atual em Nova York: " + newYorkTime);
        System.out.println("Hora atual em Paris: " + parisTime);
        System.out.println("Hora atual em Tóquio: " + tokyoTime);
    }

}
