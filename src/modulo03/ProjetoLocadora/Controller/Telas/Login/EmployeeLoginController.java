package modulo03.ProjetoLocadora.Controller.Telas.Login;

import modulo03.ProjetoLocadora.Controller.Telas.MainController;
import modulo03.ProjetoLocadora.Entidades.Pessoas.Person;

import java.util.Scanner;

public class EmployeeLoginController {

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
            validateEmployee(identidade, senha);

    }

    private void validateEmployee(String identidade, String senha) {
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
