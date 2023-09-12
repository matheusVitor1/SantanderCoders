package modulo03.ProjetoLocadora.controller.Telas.Display;
import modulo03.ProjetoLocadora.controller.Telas.MainController;
import modulo03.ProjetoLocadora.models.Locadora.RentalContract;
import modulo03.ProjetoLocadora.models.Pessoas.Person;
import modulo03.ProjetoLocadora.models.Veiculos.Vehicle;

import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.function.DoubleToIntFunction;

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
            System.out.println("4. Ver meus Aluguéis");
            System.out.println("5. Editar Meu cadastro");
            System.out.println("0. Voltar");
            selectedOption = scanner.nextInt();
            scanner.nextLine();
            handleClientMenuOption(selectedOption, pessoa);
        }while(selectedOption!=0);
    }

    private void handleClientMenuOption(int selectedOption, Person pessoa) {
        switch (selectedOption) {
            case 1:
                showListOfCars();
                break;
            case 2:
                searchCarByName();
                break;
            case 3:
                performRent(pessoa);
                break;
            case 4:
                displayClientContracts(pessoa);
                break;
            case 5:
                editClient(pessoa);
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

    private void performRent(Person pessoa){
        System.out.println("Digite a placa do carro que deseja alugar: ");
        String licensePlate = scanner.nextLine();
        Vehicle vehicle = mainController.vehicleService.findVehicleByLicense(licensePlate);

        if (vehicle != null) {
            LocalDateTime rentalDate = LocalDateTime.now();

            System.out.println("Qual tipo de contrato deseja? 1. Com data de devolução definida | 2. Com data de devolução indeterminada");
            int selectedOptionDate = scanner.nextInt();
            scanner.nextLine();

            LocalDateTime returnDate = null;

            if (selectedOptionDate == 1) {
                System.out.print("Digite a data e hora de retorno (dd-MM-yyyy HH:mm:ss): ");
                String inputDate = scanner.nextLine();

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                try {
                    returnDate = LocalDateTime.parse(inputDate, formatter);
                } catch (DateTimeParseException e) {
                    System.out.println("Formato de data e hora inválido. Certifique-se de usar o formato correto.");
                    return;
                }
            }

            String returnAddress = "";

            System.out.println("Em qual unidade deseja Buscar e entregar o Veículo? 1. Unidade 01, 2. Unidade 02, 3. Unidade 03");
            int selectedOptionUnidade = scanner.nextInt();

            if (selectedOptionUnidade == 1) {
                returnAddress = "Unidade 01";
            } else if (selectedOptionUnidade == 2) {
                returnAddress = "Unidade 02";
            } else if (selectedOptionUnidade == 3) {
                returnAddress = "Unidade 03";
            }

            if (mainController.rentalContractService.createRentalContract(vehicle, pessoa, rentalDate, returnDate, returnAddress)) {
                System.out.println("Contrato Criado");
            } else {
                System.out.println("Operação cancelada, voltando ao menu...");
                showClientMenu(pessoa);
            }
        } else {
            System.out.println("Veículo não encontrado");
        }
    }

    private void displayClientContracts(Person person){
        System.out.println(mainController.rentalContractService.findRentalByCustomer(person.getIdentity()));
    }

    private void editClient (Person person){
        System.out.println("Digite seu nome");
        String nome = scanner.nextLine();
        System.out.println("Digite seu endereço");
        String address = scanner.nextLine();
        mainController.personService.editPerson(nome, person.getIdentity(), address);
    }




}