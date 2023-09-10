package modulo03.ProjetoLocadora.Controller.Telas.Display;
import modulo03.ProjetoLocadora.Controller.Telas.MainController;
import modulo03.ProjetoLocadora.Entidades.Pessoas.Employee;
import modulo03.ProjetoLocadora.Entidades.Pessoas.IndividualPerson;
import modulo03.ProjetoLocadora.Entidades.Pessoas.LegalPerson;
import modulo03.ProjetoLocadora.Entidades.Pessoas.Person;

import java.sql.SQLOutput;
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
            System.out.println("1. Catálogo de Carros");
            System.out.println("2. Buscar Carros");
            System.out.println("3. Alugar Carro");
            System.out.println("0. Voltar");
            selectedOption = scanner.nextInt();
            scanner.nextLine();
            handleClientMenuOption(selectedOption);
        }while(selectedOption!=0);
    }

    private void handleClientMenuOption(int selectedOption) {
        switch (selectedOption) {
            case 1:
                showListOfCars();
                break;
            case 2:
                searchCarByName();
                break;
            case 3:

                break;
            case 0:
                System.out.println("Saindo do programa.");
                break;
            default:
                System.out.println("Opção Inválida");
        }
    }

    private void showListOfCars(){
        System.out.println(mainController.vehicleService.listCarsInAlphabeticalOrder());
    }

    private void searchCarByName(){
        System.out.println("Qual carro esta procurando hoje?");
        String car = scanner.nextLine();
        if (mainController.vehicleService.findVehicleByName(car) != null){
            System.out.println(mainController.vehicleService.findVehicleByName(car));
        } else {
            System.out.println("Ops! Não encontramos nenhum carro com esse nome");
        }

    }



}
