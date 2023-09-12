package modulo03.ProjetoLocadora.controller.Telas.Display;

import modulo03.ProjetoLocadora.controller.Telas.MainController;
import modulo03.ProjetoLocadora.models.Pessoas.Employee;
import modulo03.ProjetoLocadora.models.Pessoas.IndividualPerson;
import modulo03.ProjetoLocadora.models.Pessoas.LegalPerson;
import modulo03.ProjetoLocadora.models.Pessoas.Person;

import java.util.Scanner;

public class UserRegistrationController {
    private final MainController mainController;
    private final Scanner scanner;

    public UserRegistrationController(MainController mainController) {
        this.mainController = mainController;
        this.scanner = new Scanner(System.in);
    }

    public void displayUserRegistration() {
        int selectedOption;
        do {
            System.out.println("==== Cadastre-se ====");
            System.out.println("1. Cadastro como Pessoa Física");
            System.out.println("2. Cadastro como Pessoa Jurídica");
            System.out.println("3. Cadastro como Funcionário");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            selectedOption = scanner.nextInt();
            scanner.nextLine();
            handleRegistrationOption(selectedOption);
        } while (selectedOption != 0);


    }

    private void handleRegistrationOption(int selectedOption) {
        switch (selectedOption) {
            case 1:
                displayIndividualPersonRegistration();
                break;
            case 2:
                displayLegalPersonRegistration();
                break;
            case 3:
                displayEmployeeRegistration();
                break;
            case 0:
                mainController.start();
                break;
            default:
                System.out.println("Opção Inválida");
        }
    }

    public void displayIndividualPersonRegistration() {
        System.out.println("Por favor, digite seu CPF: ");
        String cpf = scanner.nextLine();


        System.out.println("Qual o seu nome? ");
        String nome = scanner.nextLine();
        System.out.println("Por favor, digite seu endereço");
        String endereco = scanner.nextLine();
        System.out.println("Defina a sua senha de acesso");
        String senha = scanner.nextLine();
        Person pessoa = new IndividualPerson(nome, cpf, endereco, senha);


        if (mainController.personService.addPerson(pessoa)) {
            System.out.println("Usuário Cadastrado com Sucesso!");
            mainController.clientHomeController.showClientMenu(pessoa);
        } else {
            System.out.println("Usuario já Existente!");
        }

    }

    public void displayLegalPersonRegistration() {
        System.out.println("Por favor, digite seu CNPJ: ");
        String cpf = scanner.nextLine();

        System.out.println("Qual o seu nome? ");
        String nome = scanner.nextLine();
        System.out.println("Por favor, digite seu endereço");
        String endereco = scanner.nextLine();
        System.out.println("Defina a sua senha de acesso");
        String senha = scanner.nextLine();
        Person pessoa = new LegalPerson(nome, cpf, endereco, senha);

        if (mainController.personService.addPerson(pessoa)) {
            System.out.println("Usuário Cadastrado com Sucesso!");
            mainController.clientHomeController.showClientMenu(pessoa);
        } else {
            System.out.println("Usuario já Existente!!");
        }

    }

    public void displayEmployeeRegistration() {
        System.out.println("Por favor, digite sua Identidade: ");
        String identidade = scanner.nextLine();

        System.out.println("Qual o seu nome? ");
        String nome = scanner.nextLine();
        System.out.println("Por favor, digite seu endereço");
        String endereco = scanner.nextLine();
        System.out.println("Defina a sua senha de acesso");
        String senha = scanner.nextLine();
        Person pessoa = new Employee(nome, identidade, endereco, senha);

        if (mainController.personService.addPerson(pessoa)) {
            System.out.println("Usuário Cadastrado com Sucesso!");
            mainController.employeeHomeController.showEmployeeMenu(pessoa);
        } else {
            System.out.println("Usuario já Existente!");
        }

    }


}
