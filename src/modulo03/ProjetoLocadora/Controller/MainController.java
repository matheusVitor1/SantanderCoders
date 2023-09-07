package modulo03.ProjetoLocadora.Controller;

import modulo03.ProjetoLocadora.Repositories.ContratoAluguelRepository;
import modulo03.ProjetoLocadora.Repositories.PessoaRepository;
import modulo03.ProjetoLocadora.Repositories.VeiculoRepository;
import modulo03.ProjetoLocadora.Services.impl.ContratoAluguelServiceImpl;
import modulo03.ProjetoLocadora.Services.impl.PessoaServiceImpl;
import modulo03.ProjetoLocadora.Services.impl.VeiculoServiceImpl;

import java.util.Scanner;

public class MainController {

    private ContratoAluguelServiceImpl contratoAluguelService;
    private PessoaServiceImpl pessoaService;
    private VeiculoServiceImpl veiculoService;
    private Scanner scanner;

    private ClientLoginController clientLoginController;
    private EmployeeLoginController employeeLoginController;

    public MainController() {
        this.contratoAluguelService = new ContratoAluguelServiceImpl(new ContratoAluguelRepository());
        this.pessoaService = new PessoaServiceImpl(new PessoaRepository());
        this.veiculoService = new VeiculoServiceImpl(new VeiculoRepository());
        this.clientLoginController = new ClientLoginController(this);
        this.employeeLoginController = new EmployeeLoginController(this);
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int option;
        do {
            System.out.println("==== Bem Vindo ====");
            System.out.println("1. Entrar como Cliente");
            System.out.println("2. Entrar como Funcionário");
            System.out.println("3. Cadastrar");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            handleMainMenuOption(option);
        } while (option != 0);
    }

    public void handleMainMenuOption(int option) {
        switch (option) {
            case 1:
                clientLoginController.displayClientLogin();
                break;
            case 2:
                employeeLoginController.displayEmployeeLogin();
                break;
            case 3:
                // Implemente a lógica de cadastro aqui
                break;
            case 0:
                System.out.println("Saindo do programa.");
                break;
            default:
                System.out.println("Opção Inválida");
        }
    }

}