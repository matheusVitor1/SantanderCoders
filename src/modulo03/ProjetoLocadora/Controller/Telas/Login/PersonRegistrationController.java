package modulo03.ProjetoLocadora.Controller.Telas.Login;

import modulo03.ProjetoLocadora.Controller.Telas.MainController;
import modulo03.ProjetoLocadora.Entidades.Pessoas.Employee;
import modulo03.ProjetoLocadora.Entidades.Pessoas.IndividualPerson;
import modulo03.ProjetoLocadora.Entidades.Pessoas.LegalPerson;
import modulo03.ProjetoLocadora.Entidades.Pessoas.Person;

import java.util.Scanner;

public class PersonRegistrationController {
    private MainController mainController;
    private Scanner scanner;

    public PersonRegistrationController(MainController mainController) {
        this.mainController = mainController;
        this.scanner = new Scanner(System.in);
    }

    public void displayRegistration() {
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

    public void displayIndividualPersonRegistration(){
        System.out.println("Por favor, digite seu CPF: ");
        String cpf = scanner.nextLine();
        Person pessoa = mainController.personService.findPerson(cpf);
        if(pessoa == null){
            System.out.println("Qual o seu nome? ");
            String nome = scanner.nextLine();
            System.out.println("Por favor, digite seu endereço");
            String endereco = scanner.nextLine();
            System.out.println("Defina a sua senha de acesso");
            String senha = scanner.nextLine();
            pessoa = new IndividualPerson(nome, cpf,endereco,senha);
            mainController.personService.addPerson(pessoa);
            System.out.println("Usuário Cadastrado!");
            mainController.clientMenuController.showClientMenu(pessoa);
        }else{
            System.out.println("Cliente já cadastrado!");
        }

    }

    public void displayLegalPersonRegistration(){
        System.out.println("Por favor, digite seu CNPJ: ");
        String cpf = scanner.nextLine();
        Person pessoa = mainController.personService.findPerson(cpf);
        if(pessoa == null){
            System.out.println("Qual o seu nome? ");
            String nome = scanner.nextLine();
            System.out.println("Por favor, digite seu endereço");
            String endereco = scanner.nextLine();
            System.out.println("Defina a sua senha de acesso");
            String senha = scanner.nextLine();
            pessoa = new LegalPerson(nome, cpf,endereco,senha);
            mainController.personService.addPerson(pessoa);
            System.out.println("Usuário Cadastrado!");
            mainController.clientMenuController.showClientMenu(pessoa);
        }else{
            System.out.println("Cliente já cadastrado!");
        }

    }

    public void displayEmployeeRegistration(){
        System.out.println("Por favor, digite sua Identidade: ");
        String identidade = scanner.nextLine();
        Person pessoa = mainController.personService.findPerson(identidade);
        if(pessoa == null){
            System.out.println("Qual o seu nome? ");
            String nome = scanner.nextLine();
            System.out.println("Por favor, digite seu endereço");
            String endereco = scanner.nextLine();
            System.out.println("Defina a sua senha de acesso");
            String senha = scanner.nextLine();
            pessoa = new Employee(nome, identidade,endereco,senha);
            mainController.personService.addPerson(pessoa);
            System.out.println("Usuário Cadastrado!");
            //mainController.clientMenuController.showClientMenu(pessoa);
        }else{
            System.out.println("Cliente já cadastrado!");
        }

    }


}
