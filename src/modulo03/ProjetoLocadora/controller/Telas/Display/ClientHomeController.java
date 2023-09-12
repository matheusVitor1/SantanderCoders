package modulo03.ProjetoLocadora.controller.Telas.Display;
import modulo03.ProjetoLocadora.controller.Telas.MainController;
import modulo03.ProjetoLocadora.models.Locadora.RentalContract;
import modulo03.ProjetoLocadora.models.Pessoas.IndividualPerson;
import modulo03.ProjetoLocadora.models.Pessoas.LegalPerson;
import modulo03.ProjetoLocadora.models.Pessoas.Person;
import modulo03.ProjetoLocadora.models.Veiculos.Car;
import modulo03.ProjetoLocadora.models.Veiculos.Vehicle;

import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
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
                generateRent(pessoa);
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
        List<Car> carros = mainController.vehicleService.listCarsInAlphabeticalOrder();

        for (Car carro : carros) {
            System.out.println(carro);
        }
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

    private void generateRent(Person pessoa) {
        System.out.println("Digite a placa do carro que deseja alugar: ");
        String licensePlate = scanner.nextLine();
        Vehicle vehicle = mainController.vehicleService.findVehicleByLicense(licensePlate);

        if (vehicle != null && !vehicle.isRented()) {
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

            System.out.println("Em qual unidade deseja buscar e entregar o Veículo? 1. Unidade 01, 2. Unidade 02, 3. Unidade 03");
            int selectedOptionUnidade = scanner.nextInt();

            if (selectedOptionUnidade == 1) {
                returnAddress = "Unidade 01";
            } else if (selectedOptionUnidade == 2) {
                returnAddress = "Unidade 02";
            } else if (selectedOptionUnidade == 3) {
                returnAddress = "Unidade 03";
            }

            RentalContract contract = new RentalContract(vehicle, pessoa, rentalDate, returnDate, returnAddress, vehicle.getRentalPricePerDay());

            if (mainController.rentalContractService.add(contract)) {
                System.out.println("Contrato Criado");
            } else {
                System.out.println("Erro ao criar o contrato. Verifique se o veículo está disponível.");
            }
        } else {
            System.out.println("Veículo não encontrado ou já está alugado.");
        }
    }


    private void displayClientContracts(Person person) {
        List<RentalContract> contracts = mainController.rentalContractService.findRentalByCustomer(person.getIdentity());
        System.out.println("==== Seus Pedidos ====");
        if (contracts != null && !contracts.isEmpty()) {
            for (RentalContract contract : contracts) {
                System.out.println(contract);
            }
        } else {
            System.out.println("Nenhum contrato de aluguel encontrado para este cliente.");
        }
    }


    private void editClient(Person person) {
        System.out.println("Digite seu novo nome");
        String nome = scanner.nextLine();
        System.out.println("Digite seu novo endereço");
        String address = scanner.nextLine();

        if (person instanceof IndividualPerson) {
            IndividualPerson individualPerson = (IndividualPerson) person;
            individualPerson.setName(nome);
            individualPerson.setAddress(address);

        } else if (person instanceof LegalPerson) {
            LegalPerson legalPerson = (LegalPerson) person;
            legalPerson.setName(nome);
            legalPerson.setAddress(address);

        }
        mainController.personService.edit(person);
    }





}