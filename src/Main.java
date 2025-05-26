import java.util.*;
import java.time.LocalDate;

/*
Guilherme Henrique Ceribelli de Jesus: 325100648
Pedro Luiz Pereira Preto: 325100636
Leandro da Veiga Soares: 325102514
David Gama Sassi: 325101353
Arthur Barros Venancio: 325100414
Ian Lima de Almeida: 3251022220
*/

public class Main {
    private static List<Veiculo> veiculos = new ArrayList<>();
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Venda> vendas = new ArrayList<>();

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = -1;
        while (opcao != 11) {
            try {
                mostrarMenu();
                opcao = Integer.parseInt(sc.nextLine());
                switch (opcao) {
                    case 1 -> cadastrarVeiculo();
                    case 2 -> cadastrarCliente();
                    case 3 -> editarVeiculo();
                    case 4 -> editarCliente();
                    case 5 -> deletarVeiculo();
                    case 6 -> deletarCliente();
                    case 7 -> listarVeiculos();
                    case 8 -> listarClientes();
                    case 9 -> realizarVenda();
                    case 10 -> listarVendas();
                    case 11 -> System.out.println("Saindo...");
                    default -> System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
            System.out.println();
        }
        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println("1 - Cadastrar Veículo");
        System.out.println("2 - Cadastrar Cliente (Pessoa Física / Jurídica)");
        System.out.println("3 - Editar Veículo");
        System.out.println("4 - Editar Cliente");
        System.out.println("5 - Deletar Veículo");
        System.out.println("6 - Deletar Cliente");
        System.out.println("7 - Listar Veículos");
        System.out.println("8 - Listar Clientes");
        System.out.println("9 - Realizar Venda");
        System.out.println("10 - Ver Histórico de Vendas");
        System.out.println("11 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarVeiculo() throws Exception {
        System.out.print("Tipo do veículo (Carro, Moto, Utilitário): ");
        String tipo = sc.nextLine().trim();
        System.out.print("Modelo: ");
        String modelo = sc.nextLine();
        System.out.print("Fabricante: ");
        String fabricante = sc.nextLine();
        System.out.print("Ano de fabricação: ");
        int ano = Integer.parseInt(sc.nextLine());

        Veiculo v;
        switch (tipo.toLowerCase()) {
            case "carro" -> v = new Carro(modelo, fabricante, ano);
            case "moto" -> v = new Moto(modelo, fabricante, ano);
            case "utilitário", "utilitario" -> v = new Utilitario(modelo, fabricante, ano);
            default -> throw new Exception("Tipo de veículo inválido!");
        }
        veiculos.add(v);
        System.out.println("Veículo cadastrado com sucesso!");
    }

    private static void cadastrarCliente() throws Exception {
        System.out.print("Tipo do cliente (F - Pessoa Física, J - Pessoa Jurídica): ");
        String tipo = sc.nextLine().trim().toUpperCase();
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("CPF/CNPJ (apenas números): ");
        String cpf = sc.nextLine();
        System.out.print("Contato: ");
        String contato = sc.nextLine();

        Cliente c;
        if (tipo.equals("F")) {
            c = new PessoaFisica(nome, cpf, contato);
        } else if (tipo.equals("J")) {
            c = new PessoaJuridica(nome, cpf, contato);
        } else {
            throw new Exception("Tipo de cliente inválido!");
        }
        clientes.add(c);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private static void listarVeiculos() {
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
            return;
        }
        for (int i = 0; i < veiculos.size(); i++) {
            System.out.println((i + 1) + " - " + veiculos.get(i));
        }
    }

    private static void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + " - " + clientes.get(i));
        }
    }

    private static void realizarVenda() throws Exception {
        if (veiculos.isEmpty() || clientes.isEmpty()) {
            System.out.println("Cadastre veículos e clientes antes de realizar vendas.");
            return;
        }
        listarVeiculos();
        System.out.print("Escolha o número do veículo para venda: ");
        int numVeiculo = Integer.parseInt(sc.nextLine()) - 1;
        if (numVeiculo < 0 || numVeiculo >= veiculos.size()) throw new Exception("Veículo não existe!");
        Veiculo veiculo = veiculos.get(numVeiculo);
        if (veiculo.getStatus().equalsIgnoreCase("vendido")) {
            System.out.println("Veículo já vendido.");
            return;
        }

        listarClientes();
        System.out.print("Escolha o número do cliente comprador: ");
        int numCliente = Integer.parseInt(sc.nextLine()) - 1;
        if (numCliente < 0 || numCliente >= clientes.size()) throw new Exception("Cliente não existe!");
        Cliente cliente = clientes.get(numCliente);

        veiculo.setStatus("vendido");
        Venda venda = new Venda(veiculo, cliente);
        vendas.add(venda);
        System.out.println("Venda registrada com sucesso!");
    }

    private static void listarVendas() {
        if (vendas.isEmpty()) {
            System.out.println("Nenhuma venda registrada.");
            return;
        }
        for (Venda v : vendas) {
            System.out.println(v);
        }
    }

    private static void editarVeiculo() throws Exception {
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
            return;
        }
        listarVeiculos();
        System.out.print("Escolha o número do veículo para editar: ");
        int idx = Integer.parseInt(sc.nextLine()) - 1;
        if (idx < 0 || idx >= veiculos.size()) throw new Exception("Veículo não existe!");

        Veiculo v = veiculos.get(idx);
        System.out.println("Editando veículo: " + v.getModelo());

        System.out.print("Novo modelo (" + v.getModelo() + "): ");
        String modelo = sc.nextLine();
        if (!modelo.isBlank()) v.setModelo(modelo);

        System.out.print("Novo fabricante (" + v.getFabricante() + "): ");
        String fabricante = sc.nextLine();
        if (!fabricante.isBlank()) v.setFabricante(fabricante);

        System.out.print("Novo ano de fabricação (" + v.getAnoFabricacao() + "): ");
        String anoStr = sc.nextLine();
        if (!anoStr.isBlank()) {
            int ano = Integer.parseInt(anoStr);
            v.setAnoFabricacao(ano);
        }
        System.out.println("Veículo atualizado!");
    }

    private static void editarCliente() throws Exception {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        listarClientes();
        System.out.print("Escolha o número do cliente para editar: ");
        int idx = Integer.parseInt(sc.nextLine()) - 1;
        if (idx < 0 || idx >= clientes.size()) throw new Exception("Cliente não existe!");

        Cliente c = clientes.get(idx);
        System.out.println("Editando cliente: " + c.getNome());

        System.out.print("Novo nome (" + c.getNome() + "): ");
        String nome = sc.nextLine();
        if (!nome.isBlank()) c.setNome(nome);

        System.out.print("Novo CPF/CNPJ (" + c.getCpf() + "): ");
        String cpf = sc.nextLine();
        if (!cpf.isBlank()) c.setCpf(cpf);

        System.out.print("Novo contato (" + c.getContato() + "): ");
        String contato = sc.nextLine();
        if (!contato.isBlank()) c.setContato(contato);

        System.out.println("Cliente atualizado!");
    }

    private static void deletarVeiculo() throws Exception {
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
            return;
        }
        listarVeiculos();
        System.out.print("Escolha o número do veículo para deletar: ");
        int idx = Integer.parseInt(sc.nextLine()) - 1;
        if (idx < 0 || idx >= veiculos.size()) throw new Exception("Veículo não existe!");

        Veiculo v = veiculos.get(idx);
        if (v.getStatus().equalsIgnoreCase("vendido")) {
            System.out.println("Não é possível deletar veículo vendido.");
            return;
        }

        veiculos.remove(idx);
        System.out.println("Veículo deletado.");
    }

    private static void deletarCliente() throws Exception {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        listarClientes();
        System.out.print("Escolha o número do cliente para deletar: ");
        int idx = Integer.parseInt(sc.nextLine()) - 1;
        if (idx < 0 || idx >= clientes.size()) throw new Exception("Cliente não existe!");

        clientes.remove(idx);
        System.out.println("Cliente deletado.");
    }
}