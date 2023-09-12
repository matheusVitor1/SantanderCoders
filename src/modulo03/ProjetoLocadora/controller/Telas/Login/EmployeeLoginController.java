package modulo03.ProjetoLocadora.controller.Telas.Login;

import modulo03.ProjetoLocadora.controller.Telas.Login.Contracts.ValidateUser;
import modulo03.ProjetoLocadora.controller.Telas.MainController;
import modulo03.ProjetoLocadora.models.Pessoas.Person;

import java.util.Scanner;

public class EmployeeLoginController implements ValidateUser {

    private MainController mainController;
    private Scanner scanner;

    public EmployeeLoginController(MainController mainController) {
        this.mainController = mainController;
        this.scanner = new Scanner(System.in);
    }

    public void displayEmployeeLogin() {

        System.out.println("==== Login ====");
        System.out.println("Digite seu cpf: ");
        String identidade = scanner.nextLine();
        System.out.println("Digite sua senha: ");
        String senha = scanner.nextLine();
        validateUser(identidade, senha);

    }

    public void validateUser(String identidade, String senha) {
        Person pessoa = mainController.personService.findPerson(identidade);
        if (pessoa != null) {
            if (pessoa.getPassword().equals(senha)) {
                mainController.employeeHomeController.showEmployeeMenu(pessoa);
            } else {
                System.out.println("Senha incorreta. Tente novamente.");
            }
        } else {
            System.out.println("Usuário não encontrado. Verifique a identidade fornecida.");
            mainController.start();
        }
    }
}