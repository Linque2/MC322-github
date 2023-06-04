import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LerEntrada {

    static LocalDate lerData() {
        Scanner input = new Scanner(System.in);
        String data_string = input.nextLine();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy", new Locale("pt", "BR"));
        LocalDate data = LocalDate.parse(data_string, formato);
        return data;
    }

    static LocalDate lerData(String data_string) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy", new Locale("pt", "BR"));
        LocalDate data = LocalDate.parse(data_string, formato);
        return data;
    }

    static String lerCpf() {
        Scanner input = new Scanner(System.in);
        String cpf = input.nextLine();
        return cpf;
    }

    static String lerCnpj() {
        Scanner input = new Scanner(System.in);
        String cnpj = input.nextLine();
        return cnpj;
    }

    static int criaIdAleatorio() {
        Random gerador = new Random();
        int limite_superior = 1000000;
        int id = gerador.nextInt(limite_superior);
        return id;
    }

    static ClientePF lerClientePF() {
        Scanner input = new Scanner(System.in);
        boolean Inválido = false;
        ClientePF cliente;
        String cpf;
        String nome;
        String telefone;
        String endereco;
        String email;
        String genero;
        String educacao;
        LocalDate dataNasc;

        System.out.print("Lendo ClientePF: \n ");

        do {
            if (Inválido == true)
                System.out.println("CPF inválido. Insira novamente: ");
            System.out.print("CPF: ");
            cpf = input.nextLine();
            Inválido = true;
        }while(Validacao.validarCPF(cpf) == false);
        Inválido = false;

        do {
            if (Inválido == true)
                System.out.println("Nome inválido. Insira novamente: ");
            System.out.print("Nome: ");
            nome = (input.nextLine());
            Inválido = true;
        }while(Validacao.validarNome(nome) == false);

        System.out.println("Telefone: ");
        telefone = input.nextLine();

        System.out.println("Endereço: ");
        endereco = input.nextLine();

        System.out.println("Email: ");
        email = input.nextLine();

        System.out.println("Genero: ");
        genero = input.nextLine();

        System.out.print("Nível de educação: ");
        educacao = input.nextLine();

        System.out.print("Data de nascimento: [dd/MM/yyyy]");
        dataNasc = lerData();

        cliente = new ClientePF(cpf, nome, telefone, endereco, email, genero, educacao, dataNasc);
        return cliente;
    }

    static ClientePJ lerClientePJ() {
        Scanner input = new Scanner(System.in);
        boolean Inválido = false;
        ClientePJ cliente;
        String cnpj;
        String nome;
        String telefone;
        String endereco;
        String email;
        LocalDate dataFundação;

        System.out.print("Lendo ClientePJ: \n");
        do {
            if (Inválido == true)
                System.out.println("cnpj inválido. Insira novamente: ");
            System.out.print("cnpj: ");
            cnpj = input.nextLine();
            Inválido = true;
        }while(Validacao.validarCNPJ(cnpj) == false);
        Inválido = false;

        do {
            if (Inválido == true)
                System.out.println("Nome inválido. Insira novamente: ");
            System.out.print("Nome: ");
            nome = (input.nextLine());
            Inválido = true;
        }while(Validacao.validarNome(nome) == false);

        System.out.println("Telefone: ");
        telefone = input.nextLine();

        System.out.println("Endereço: ");
        endereco = input.nextLine();

        System.out.println("Email: ");
        email = input.nextLine();

        System.out.print("Data fundação: [dd/MM/yyyy]");
        dataFundação = lerData();

        cliente = new ClientePJ(cnpj, nome, telefone, endereco, email, dataFundação);
        return cliente;
    }

    static Seguro lerSeguro(Seguradora seguradora, Cliente cliente) {
        return null;
    }

    static SeguroPF lerSeguro(Seguradora seguradora, ClientePF cliente) {
        Scanner input = new Scanner(System.in);
        SeguroPF seguro;
        LocalDate dataInicio;
        LocalDate dataFim;
        int valorMensal;
        Veículo veiculo;

        System.out.println("Lendo SeguroPF: \n");

        System.out.println("Data de criação do seguro: ");
        dataInicio = lerData();

        System.out.println("Data de término do seguro: ");
        dataFim = lerData();

        valorMensal = 0;

        System.out.println("Qual veículo deve ser vinculado ao seguro?");
        cliente.listarVeiculos();
        System.out.println("Indice do veículo: ");
        int indice = Integer.parseInt(input.nextLine());
        veiculo = cliente.getListaVeiculos().get(indice);

        seguro = new SeguroPF(dataInicio, dataFim, seguradora, valorMensal, veiculo, cliente);
        return seguro;
    }

    static SeguroPJ lerSeguro(Seguradora seguradora, ClientePJ cliente) {
        Scanner input = new Scanner(System.in);
        SeguroPJ seguro;
        LocalDate dataInicio;
        LocalDate dataFim;
        int valorMensal;
        Frota frota;

        System.out.println("Lendo SeguroPF: \n");

        System.out.println("Data de criação do seguro: ");
        dataInicio = lerData();

        System.out.println("Data de término do seguro: ");
        dataFim = lerData();

        valorMensal = 0;

        System.out.println("Qual frota deve ser vinculada ao seguro?");
        cliente.listarFrotas();
        System.out.println("Indice da frota: ");
        int indice = Integer.parseInt(input.nextLine());
        frota = cliente.getListaFrota().get(indice);


        seguro = new SeguroPJ(dataInicio, dataFim, seguradora, valorMensal, frota, cliente);
        return seguro;
    }

    static Veículo lerVeiculo() {
        Scanner input = new Scanner(System.in);
        Veículo veiculo;
        String placa;
        String marca;
        String modelo;
        int anoFabricacao;

        System.out.println("Lendo veículo: \nPlaca: ");
        placa = input.nextLine();
        
        System.out.println("Marca: ");
        marca = input.nextLine();

        System.out.println("Modelo: ");
        modelo = input.nextLine();

        System.out.println("Ano de fabricação: ");
        anoFabricacao = Integer.parseInt(input.nextLine());

        veiculo = new Veículo(placa, marca, modelo, anoFabricacao);
        return veiculo;
    }
}
