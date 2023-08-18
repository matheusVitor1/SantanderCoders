package modulo02.aula04.Controller;

import modulo02.aula04.Entidades.Cliente;
import modulo02.aula04.Entidades.Pratos;
import modulo02.aula04.Entidades.Restaurante;
import modulo02.aula04.Entidades.Pedidos;
import modulo02.aula04.Repository.PedidosRepository;
import modulo02.aula04.Repository.ClienteRepository;


import modulo02.aula04.Services.PedidosService;
import modulo02.aula04.Services.RestauranteService;
import modulo02.aula04.Services.ClienteService;


import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
public class MainController {

    private RestauranteService restauranteService;

    private PedidosRepository pedidosRepository;
    private ClienteService clienteService;
    private PedidosService pedidosService;

    private Scanner scanner;

    public MainController() {

        pedidosRepository = new PedidosRepository(); // Inicialize o repositório de pedidos aqui
        restauranteService = new RestauranteService();
        clienteService = new ClienteService(new ClienteRepository());
        pedidosService = new PedidosService(pedidosRepository); // Inicialize o serviço de pedidos aqui
        scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("==== MENU ====");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Restaurante");
            System.out.println("3. Listar Restaurantes");
            System.out.println("4. Adicionar Prato a Restaurante");
            System.out.println("5. Listar Pratos de um Restaurante");
            System.out.println("6. Fazer Pedido");
            System.out.println("7. Listar Pedidos de um Restaurante");
            System.out.println("8. Ver Pedidos de um Cliente");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;

                case 2:
                    cadastrarRestaurante();
                    break;
                case 3:
                    listarRestaurantes();
                    break;
                case 4:
                    adicionarPratoARestaurante();
                    break;
                case 5:
                    listarPratosDeRestaurante();
                    break;
                case 6:
                    fazerPedido();
                    break;
                case 7:
                    listarPedidosPorRestaurante();
                    break;
                case 8:
                    listarPedidosPorCliente();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private void cadastrarCliente() {
        System.out.println("===== Cadastrar Cliente =====");
        System.out.print("Informe o CPF do cliente: ");
        String cpf = scanner.nextLine();
        System.out.print("Informe o nome do cliente: ");
        String nomeCliente = scanner.nextLine();

        clienteService.cadastrarCliente(cpf, nomeCliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private void cadastrarRestaurante() {
        System.out.println("===== Cadastrar Restaurante =====");
        System.out.print("Informe o CNPJ do restaurante: ");
        String cnpj = scanner.nextLine();
        System.out.print("Informe o nome do restaurante: ");
        String nomeRestaurante = scanner.nextLine();
        System.out.print("Informe o endereço do restaurante: ");
        String enderecoRestaurante = scanner.nextLine();

        restauranteService.cadastrarRestaurante(cnpj, nomeRestaurante, enderecoRestaurante);
    }



    private void listarRestaurantes() {
        System.out.println("===== Listar Restaurantes =====");
        List<Restaurante> restaurantes = restauranteService.listarRestaurantes();

        if (!restaurantes.isEmpty()) {
            System.out.println("Restaurantes cadastrados:");
            for (Restaurante restaurante : restaurantes) {
                System.out.println("CNPJ: " + restaurante.getCnpj() + " | Nome: " + restaurante.getNome());
            }
        } else {
            System.out.println("Nenhum restaurante cadastrado.");
        }
    }


    private void adicionarPratoARestaurante() {
        System.out.println("===== Adicionar Prato a Restaurante =====");
        System.out.print("Informe o CNPJ do restaurante: ");
        String cnpj = scanner.nextLine();

        Restaurante restaurante = restauranteService.buscarRestaurantePorCnpj(cnpj);
        if (restaurante != null) {
            System.out.print("Informe o ID do prato: ");
            String idPrato = scanner.nextLine();
            System.out.print("Informe o nome do prato: ");
            String nomePrato = scanner.nextLine();
            System.out.print("Informe o valor do prato: ");
            double valorPrato = scanner.nextDouble();
            scanner.nextLine(); // Limpar o buffer

            restauranteService.cadastrarPrato(cnpj, idPrato, nomePrato, valorPrato);
            System.out.println("Prato adicionado com sucesso ao restaurante!");
        } else {
            System.out.println("Restaurante não encontrado.");
        }
    }

    private void listarPratosDeRestaurante() {
        System.out.println("===== Listar Pratos de um Restaurante =====");
        System.out.print("Informe o CNPJ do restaurante: ");
        String cnpj = scanner.nextLine();

        Restaurante restaurante = restauranteService.buscarRestaurantePorCnpj(cnpj);
        if (restaurante != null) {
            List<Pratos> pratos = restaurante.getPratos();
            if (!pratos.isEmpty()) {
                System.out.println("Pratos disponíveis no restaurante " + restaurante.getNome() + ":");
                for (Pratos prato : pratos) {
                    System.out.println("ID: " + prato.getId() + " | Nome: " + prato.getNomePrato() + " | Valor: " + prato.getValor());
                }
            } else {
                System.out.println("Nenhum prato cadastrado para este restaurante.");
            }
        } else {
            System.out.println("Restaurante não encontrado.");
        }
    }

    private void fazerPedido() {
        System.out.println("===== Fazer Pedido =====");

        // Solicitar informações do Cliente
        System.out.print("Informe o CPF do cliente: ");
        String cpfCliente = scanner.nextLine();
        Cliente cliente = solicitarInfoCliente(cpfCliente);

        // Solicitar informações do Restaurante
        System.out.print("Informe o CNPJ do restaurante: ");
        String cnpjRestaurante = scanner.nextLine();
        Restaurante restaurante = solicitarInfoRestaurante(cnpjRestaurante);

        // Solicitar informações dos pratos
        List<Pratos> pratosSelecionados = solicitarInfoPratos(cnpjRestaurante);

        // Criar o pedido
        PedidosService pedidosService = new PedidosService(pedidosRepository);
        pedidosService.criarPedido(cliente, restaurante, pratosSelecionados);

        System.out.println("Pedido realizado com sucesso!");
    }

    private Restaurante solicitarInfoRestaurante(String cnpjRestaurante){

        Restaurante restaurante = restauranteService.buscarRestaurantePorCnpj(cnpjRestaurante);
        if (restaurante == null) {
            System.out.println("Restaurante não encontrado.");
            return null;
        }

        return restaurante;
    }

    private Cliente solicitarInfoCliente(String cpfCliente){

        Cliente cliente = clienteService.buscarClientePorCpf(cpfCliente);
        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return null;
        }
        return cliente;
    }
    private List<Pratos> solicitarInfoPratos(String cnpj) {
        // Solicitar informações dos pratos
        List<Pratos> pratosSelecionados = new ArrayList<>();
        System.out.println("Informe os IDs dos pratos desejados (separados por vírgula): ");
        String idsPratos = scanner.nextLine();
        String[] ids = idsPratos.split(",");
        for (String idPrato : ids) {
            List<Pratos> pratosEncontrados = restauranteService.buscarPratosPorId(cnpj, idPrato.trim());
            if (!pratosEncontrados.isEmpty()) {
                pratosSelecionados.addAll(pratosEncontrados);
            } else {
                System.out.println("Nenhum prato encontrado com o ID " + idPrato);
            }
        }
        return pratosSelecionados;
    }

    private void listarPedidosPorRestaurante() {
        System.out.println("===== Listar Pedidos de um Restaurante =====");
        System.out.print("Informe o CNPJ do restaurante: ");
        String cnpjRestaurante = scanner.nextLine();

        Restaurante restaurante = restauranteService.buscarRestaurantePorCnpj(cnpjRestaurante);
        if (restaurante != null) {
            List<Pedidos> pedidos = pedidosService.listarPedidosPorRestaurante(cnpjRestaurante);
            if (!pedidos.isEmpty()) {
                System.out.println("Pedidos do restaurante " + restaurante.getNome() + ":");
                for (Pedidos pedido : pedidos) {
                    double valorTotalPedido = calcularValorTotalPedido(pedido);
                    System.out.println("Número do Pedido: " + pedido.getNumeroPedido() + " | Cliente: " + pedido.getCliente().getNome() + " | Prato: " + pedido.getPratos() + " | Valor Total: " + valorTotalPedido);
                }
            } else {
                System.out.println("Nenhum pedido encontrado para este restaurante.");
            }
        } else {
            System.out.println("Restaurante não encontrado.");
        }
    }

    private void listarPedidosPorCliente() {
        System.out.println("===== Listar Pedidos de um Cliente =====");
        System.out.print("Informe o CPF do cliente: ");
        String cpfCliente = scanner.nextLine();

        Cliente cliente = clienteService.buscarClientePorCpf(cpfCliente);
        if (cliente != null) {
            List<Pedidos> pedidos = pedidosService.listarPedidosPorCliente(cpfCliente);
            if (!pedidos.isEmpty()) {
                System.out.println("Pedidos do cliente " + cliente.getNome() + ":");
                for (Pedidos pedido : pedidos) {
                    double valorTotalPedido = calcularValorTotalPedido(pedido);
                    System.out.println("Número do Pedido: " + pedido.getNumeroPedido() + " | Restaurante: " + pedido.getRestaurante().getNome() + " | Prato(s): " + pedido.getPratos() + " | Valor Total: " + valorTotalPedido);
                }
            } else {
                System.out.println("Nenhum pedido encontrado para este cliente.");
            }
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    public double calcularValorTotalPedido(Pedidos pedido) {
        List<Pratos> pratosDoPedido = pedido.getPratos();
        double valorTotal = 0;

        for (Pratos prato : pratosDoPedido) {
            valorTotal += prato.getValor();
        }

        return valorTotal;
    }



    public static void main(String[] args) {
        MainController controller = new MainController();
        controller.exibirMenu();
    }
}
