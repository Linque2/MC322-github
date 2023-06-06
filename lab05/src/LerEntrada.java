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
        int qtdeFuncionarios;

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

        System.out.print("Quantidade de funcionários: ");
        qtdeFuncionarios = Integer.parseInt(input.nextLine());

        cliente = new ClientePJ(cnpj, nome, telefone, endereco, email, dataFundação, qtdeFuncionarios);
        return cliente;
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

    static Condutor lerCondutor() {
        Scanner input = new Scanner(System.in);
        Condutor condutor;
        String cpf, nome, telefone, endereco, email;
        LocalDate dataNasc;
        boolean autorizacao = true, Inválido = false;

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

        System.out.print("Data de nascimento: [dd/MM/yyyy]");
        dataNasc = lerData();

        System.out.print("Autorização[S/N]: ");
        String opcao = input.nextLine();
        do {
            Inválido = false;
            if (opcao.equals("S") || opcao.equals("s") || opcao.equals("Sim") || opcao.equals("SIM") || opcao.equals("sim"))
                autorizacao = true;
            else if (opcao.equals("N") || opcao.equals("n") || opcao.equals("Não") || opcao.equals("NÃO") || opcao.equals("não"))
                autorizacao = false;
            else {
                System.out.println("Resposta inválida. Insira[S/N]: ");
                Inválido = true;
            }
        } while(Inválido == true);

        condutor = new Condutor(cpf, nome, telefone, endereco, email, dataNasc, autorizacao);
        return condutor;
    }

    static Frota lerFrota(){
        Scanner input = new Scanner(System.in);
        Frota frota;
        String code;

        System.out.println("Lendo frota: \nCode: ");
        code = input.nextLine();
        
        frota = new Frota(code);
        return frota;
    }
}
