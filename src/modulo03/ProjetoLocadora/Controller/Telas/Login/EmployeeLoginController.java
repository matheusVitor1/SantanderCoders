package modulo03.ProjetoLocadora.Controller.Telas.Login;

import modulo03.ProjetoLocadora.Controller.Telas.MainController;

import java.util.Scanner;

public class EmployeeLoginController {

    private MainController mainController;
    private Scanner scanner;

    public EmployeeLoginController(MainController mainController) {
        this.mainController = mainController;
        this.scanner = new Scanner(System.in);
    }

    public void displayEmployeeLogin() {
    }
}
