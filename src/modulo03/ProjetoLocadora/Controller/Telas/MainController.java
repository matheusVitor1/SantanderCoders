package modulo03.ProjetoLocadora.Controller.Telas;

import modulo03.ProjetoLocadora.Controller.Telas.Display.ClientMenuController;
import modulo03.ProjetoLocadora.Controller.Telas.Login.EmployeeLoginController;
import modulo03.ProjetoLocadora.Controller.Telas.Login.PersonRegistrationController;
import modulo03.ProjetoLocadora.Controller.Telas.Login.ClientLoginController;
import modulo03.ProjetoLocadora.Repositories.PersonRepository;
import modulo03.ProjetoLocadora.Repositories.RentalContractRepository;
import modulo03.ProjetoLocadora.Repositories.VehicleRepository;
import modulo03.ProjetoLocadora.Services.impl.PersonServiceImpl;
import modulo03.ProjetoLocadora.Services.impl.RentalContractServiceImpl;
import modulo03.ProjetoLocadora.Services.impl.VehicleServiceImpl;


import java.util.Scanner;

public class MainController {

    public RentalContractServiceImpl rentalContractService;
    public PersonServiceImpl personService;
    public VehicleServiceImpl vehicleService;
    public ClientMenuController clientMenuController;
    private Scanner scanner;
    private PersonRegistrationController personRegistrationController;
    private ClientLoginController clientLoginController;
    private EmployeeLoginController employeeLoginController;



    public MainController() {
        this.rentalContractService = new RentalContractServiceImpl(new RentalContractRepository());
        this.personService = new PersonServiceImpl(new PersonRepository());
        this.vehicleService = new VehicleServiceImpl(new VehicleRepository());
        this.clientLoginController = new ClientLoginController(this);
        this.employeeLoginController = new EmployeeLoginController(this);
        this.clientMenuController = new ClientMenuController(this);
        this.personRegistrationController = new PersonRegistrationController(this);
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int selectedOption;
        do {
            System.out.println("==== Bem Vindo ====");
            System.out.println("1. Entrar como Cliente");
            System.out.println("2. Entrar como Funcionário");
            System.out.println("3. Cadastrar");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            selectedOption = scanner.nextInt();
            scanner.nextLine();
            handleMainMenuOption(selectedOption);
        } while (selectedOption != 0);
    }

    private void handleMainMenuOption(int option) {
        switch (option) {
            case 1:
                clientLoginController.displayClientLogin();
                break;
            case 2:
                employeeLoginController.displayEmployeeLogin();
                break;
            case 3:
                personRegistrationController.displayRegistration();
                break;
            case 0:
                System.out.println("Saindo do programa.");
                break;
            default:
                System.out.println("Opção Inválida");
        }
    }

}