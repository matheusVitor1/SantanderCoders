package modulo03.ProjetoLocadora.Controller;

import java.util.Scanner;

public class ClientLoginController {

    private MainController mainController;
    private Scanner scanner;

    public ClientLoginController(MainController mainController) {
        this.mainController = mainController;
        this.scanner = new Scanner(System.in);
    }

    public void displayClientLogin() {
        int option;
        do {
            System.out.println("==== Bem Vindo ====");
            System.out.println("1. Entrar como Pessoa Física");
            System.out.println("2. Entrar como Pessoa Jurídica");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            handleClientLoginOption(option);
        } while (option != 0);
    }

    public void handleClientLoginOption(int option) {
        switch (option) {
            case 1:
                // Implemente a lógica de login de Pessoa Física aqui
                break;
            case 2:
                // Implemente a lógica de login de Pessoa Jurídica aqui
                break;
            case 0:
                mainController.start(); // Voltar ao menu principal
                break;
            default:
                System.out.println("Opção Inválida");
        }
    }
}

