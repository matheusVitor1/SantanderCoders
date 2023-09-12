package modulo03.ProjetoLocadora.controller.Telas.Login;

import modulo03.ProjetoLocadora.controller.Telas.Login.Contracts.ValidateUser;
import modulo03.ProjetoLocadora.controller.Telas.MainController;
import modulo03.ProjetoLocadora.models.Pessoas.Person;

import java.util.Scanner;

public class ClientLoginController implements ValidateUser {

    private MainController mainController;
    private Scanner scanner;

    public ClientLoginController(MainController mainController) {
        this.mainController = mainController;
        this.scanner = new Scanner(System.in);
    }

    public void displayClientLogin() {
        int selectedOption;
        do {
            System.out.println("==== Entrar ====");
            System.out.println("1. Entrar como Pessoa Física");
            System.out.println("2. Entrar como Pessoa Jurídica");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            selectedOption = scanner.nextInt();
            scanner.nextLine();
            handleClientLoginOption(selectedOption);
        } while (selectedOption != 0);
    }

    private void handleClientLoginOption(int selectedOption) {
        switch (selectedOption) {
            case 1:
                individualPersonLogin();
                break;
            case 2:
                legalPersonLogin();
                break;
            case 0:
                mainController.start();
                break;
            default:
                System.out.println("Opção Inválida");
        }
    }

    private void individualPersonLogin(){
        System.out.println("==== Login ====");
        System.out.println("Digite seu cpf: ");
        String identidade = scanner.nextLine();
        System.out.println("Digite sua senha: ");
        String senha = scanner.nextLine();
        validateUser(identidade, senha);
    }
    private void legalPersonLogin(){
        System.out.println("==== Login ====");
        System.out.println("Digite seu Cnpj: ");
        String identidade = scanner.nextLine();
        System.out.println("Digite sua senha: ");
        String senha = scanner.nextLine();
        validateUser(identidade, senha);

    }

    public void validateUser(String identidade, String senha) {
        Person pessoa = mainController.personService.findPerson(identidade);
        if (pessoa != null) {
            if (pessoa.getPassword().equals(senha)) {
                mainController.clientHomeController.showClientMenu(pessoa);
            } else {
                System.out.println("Senha incorreta. Tente novamente.");
            }
        } else {
            System.out.println("Usuário não encontrado. Verifique a identidade fornecida.");
            displayClientLogin();
        }
    }


}

