package modulo03.ProjetoLocadora.Controller.Telas.Display;
import modulo03.ProjetoLocadora.Controller.Telas.MainController;
import modulo03.ProjetoLocadora.Entidades.Pessoas.Person;

import java.util.Scanner;

public class ClientHomeController {
    private MainController mainController;
    private Scanner scanner;

    public ClientHomeController(MainController mainController) {
        this.mainController = mainController;
        this.scanner = new Scanner(System.in);
    }

    public void showClientMenu(Person pessoa){
        int selectedOption;
        do {
            System.out.println("Bem-vindo, " + pessoa.getName());
            selectedOption = scanner.nextInt();
        }while(selectedOption!=0);
    }
}
