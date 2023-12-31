package modulo03.ProjetoLocadora.controller.Telas;

import modulo03.ProjetoLocadora.controller.Telas.Display.ClientHomeController;
import modulo03.ProjetoLocadora.controller.Telas.Display.EmployeeHomeController;
import modulo03.ProjetoLocadora.controller.Telas.Login.EmployeeLoginController;
import modulo03.ProjetoLocadora.controller.Telas.Login.ClientLoginController;
import modulo03.ProjetoLocadora.repositories.PersonRepository;
import modulo03.ProjetoLocadora.repositories.RentalContractRepository;
import modulo03.ProjetoLocadora.repositories.VehicleRepository;
import modulo03.ProjetoLocadora.services.impl.PersonServiceImpl;
import modulo03.ProjetoLocadora.services.impl.RentalContractServiceImpl;
import modulo03.ProjetoLocadora.services.impl.VehicleServiceImpl;
import modulo03.ProjetoLocadora.controller.Telas.Display.UserRegistrationController;


import java.util.Scanner;

public class MainController {

    public RentalContractServiceImpl rentalContractService;
    public PersonServiceImpl personService;
    public VehicleServiceImpl vehicleService;
    public ClientHomeController clientHomeController;
    public EmployeeHomeController employeeHomeController;
    private Scanner scanner;
    private UserRegistrationController userRegistrationController;
    private ClientLoginController clientLoginController;
    private EmployeeLoginController employeeLoginController;



    public MainController() {
        this.rentalContractService = new RentalContractServiceImpl(new RentalContractRepository(), new VehicleRepository());
        this.personService = new PersonServiceImpl(new PersonRepository());
        this.vehicleService = new VehicleServiceImpl(new VehicleRepository());
        this.clientLoginController = new ClientLoginController(this);
        this.employeeLoginController = new EmployeeLoginController(this);
        this.clientHomeController = new ClientHomeController(this);
        this.userRegistrationController = new UserRegistrationController(this);
        this.employeeLoginController = new EmployeeLoginController(this);
        this.employeeHomeController = new EmployeeHomeController(this);
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

    private void handleMainMenuOption(int selectedOption) {
        switch (selectedOption) {
            case 1:
                clientLoginController.displayClientLogin();
                break;
            case 2:
                employeeLoginController.displayEmployeeLogin();
                break;
            case 3:
                userRegistrationController.displayUserRegistration();
                break;
            case 0:
                System.out.println("Saindo do programa.");
                break;
            default:
                System.out.println("Opção Inválida");
        }
    }

}