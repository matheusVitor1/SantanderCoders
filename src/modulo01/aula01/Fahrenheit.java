package aula01;

import java.util.Scanner;

public class Fahrenheit {
    /* Faça um Programa que peça a temperatura em graus aula01.Fahrenheit, transforme e mostre a temperatura em graus Celsius.
       C = 5 * ((F-32) / 9).

    */


    public static Double converteTemperatura(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a temperatura em graus aula01.Fahrenheit");
        double fahrenheit = sc.nextDouble();

        double celsius = 5 * ((fahrenheit - 32) / 9);
        sc.close();

        return celsius;
    }



    public static void main(String[] args) {

        double temperaturaCelsius = converteTemperatura();
        System.out.printf("A temperatura em graus Celsius é: %.2f%n", temperaturaCelsius);
    }
}