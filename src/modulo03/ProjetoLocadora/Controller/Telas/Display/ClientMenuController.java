package modulo03.ProjetoLocadora.Controller.Telas.Display;
import modulo03.ProjetoLocadora.Controller.Telas.MainController;
import modulo03.ProjetoLocadora.Entidades.Pessoas.Person;

import java.util.Scanner;

public class ClientMenuController {
    private MainController mainController;
    private Scanner scanner;

    public ClientMenuController(MainController mainController) {
        this.mainController = mainController;
        this.scanner = new Scanner(System.in);
    }

    public void showClientMenu(Person pessoa){
        System.out.println("teste");
    }
}
