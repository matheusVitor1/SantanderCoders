package modulo03.ProjetoLocadora.controller.Telas.Display;

import modulo03.ProjetoLocadora.controller.Telas.MainController;
import modulo03.ProjetoLocadora.models.Locadora.RentalContract;
import modulo03.ProjetoLocadora.models.Pessoas.Person;
import modulo03.ProjetoLocadora.models.Veiculos.Car;
import modulo03.ProjetoLocadora.models.Veiculos.Vehicle;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class EmployeeHomeController {
    private final MainController mainController;
    private final Scanner scanner;

    public EmployeeHomeController(MainController mainController) {
        this.mainController = mainController;
        this.scanner = new Scanner(System.in);
    }

    public void showEmployeeMenu(Person pessoa) {
        int selectedOption;
        do {
            System.out.println("Bem-vindo, Funcionário: " + pessoa.getName());
            System.out.println("1. Cadastrar Veículo");
            System.out.println("2. Editar um Veículo Cadastrado");
            System.out.println("3. Registrar Devolução de Veículo");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            selectedOption = scanner.nextInt();
            scanner.nextLine();
            handleEmployeeMenuOption(selectedOption);
        } while (selectedOption != 0);
    }

    private void handleEmployeeMenuOption(int selectedOption) {
        switch (selectedOption) {
            case 1:
                addVehicle();

                break;
            case 2:

                break;
            case 3:
                registerVehicleReturn();
                break;
            case 0:
                System.out.println("Saindo do programa.");
                break;
            default:
                System.out.println("Opção Inválida");
        }
    }

    private void addVehicle() {
        System.out.println("==== Cadastro de Veículos ====");
        System.out.println("1. Cadastrar Carro");
        System.out.println("2. Cadastrar Moto");
        int handleOption = scanner.nextInt();
        scanner.nextLine();
        if (handleOption == 1) {
            addCar();
        } else {
            System.out.println("Ainda em desenvolvimento");
        }
    }

    private void addCar() {
        System.out.println("Por favor, digite a placa do veículo");
        String licensePlate = scanner.nextLine();

        System.out.println("Qual a marca do Carro?");
        String marca = scanner.nextLine();

        System.out.println("Qual o modelo do Carro");
        String model = scanner.nextLine();

        System.out.println("Qual o porte do carro ? 1-Pequeno, 2-Medio, 3-SUV");
        int handleSizeOption = scanner.nextInt();
        String sizeOption = (handleSizeOption == 1) ? "pequeno" : ((handleSizeOption == 2) ? "medio" : ((handleSizeOption == 3) ? "SUV" : "grande"));

        BigDecimal rentalPrice = mainController.vehicleService.setDailyRentalPriceForCar(sizeOption);
        Vehicle  vehicle = new Car(marca, model, licensePlate, rentalPrice, sizeOption, false);

        if(mainController.vehicleService.addVehicle(vehicle)){
            System.out.println("Veiculo adicionado com sucesso");
        } else {
            System.out.println("Veiculo já cadastrado");
        }

    }

    private void registerVehicleReturn(){
        System.out.println("Digite o número da Ordem de Serviço");
        int orderNumber = scanner.nextInt();
        scanner.nextLine();
        RentalContract contract = mainController.rentalContractService.findRentalByProtocol(orderNumber);
        if(contract == null){
            System.out.println("Nenhum contrato encontrado");
        } else {
            System.out.print("Digite a data e hora de retorno (dd-MM-yyyy HH:mm:ss): ");
            String inputDate = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

            try {
               LocalDateTime returnDate = LocalDateTime.parse(inputDate, formatter);
               mainController.rentalContractService.returnVehicleForIndefiniteContract(contract,returnDate);
                System.out.println("Contrato atualizado");
            } catch (DateTimeParseException e) {
                System.out.println("Formato de data e hora inválido. Certifique-se de usar o formato correto.");
            }
        }

    }

}