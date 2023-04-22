import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import javax.swing.text.DateFormatter;

public class ClientePF extends Cliente {
    //Declarando os atributos da classe
    private String CPF;
    private String genero;
    private LocalDate dataLicenca;
    private String educacao;
    private LocalDate dataNascimento;
    private String classeEconomica;

    //Construtor
    public ClientePF(String nome, String endereco,LinkedList<Veículo> listaVeiculos , LocalDate dataLicenca, String educacao, String genero, String classeEconomica, String CPF, LocalDate dataNascimento) {
        super(nome, endereco, listaVeiculos); //**
        this.CPF = CPF;
        this.genero = genero;
        this.dataLicenca = dataLicenca;
        this.educacao = educacao;
        this.dataNascimento = dataNascimento;
        this.classeEconomica = classeEconomica;
    }
    /*Declarando os métodos da classe ClientePF*/
    //getters and setters

    public String getCPF() {
        return this.CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDate getDataLicenca() {
        return this.dataLicenca;
    }

    public void setDataLicenca(LocalDate dataLicenca) {
        this.dataLicenca = dataLicenca;
    }

    public String getEducacao() {
        return this.educacao;
    }

    public void setEducacao(String educacao) {
        this.educacao = educacao;
    }

    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getClasseEconomica() {
        return this.classeEconomica;
    }

    public void setClasseEconomica(String classeEconomica) {
        this.classeEconomica = classeEconomica;
    }

    //demais métodos

    public boolean validarCPF(String cpf){
        String cpfNumérico;
        cpfNumérico = cpf.replaceAll("[^\\d]", "");             //Remove todos os caracteres não numéricos da string

        if (cpfNumérico.length() != 11)                         //Verifica se o cpf possui 11 caracteres numéricos
            return false;

        if (sequenciaDeAlgarismosIguais(cpfNumérico) == true)   //Verifica se todos os dígitos do cpf são iguais
            return false;

        if (Integer.parseInt(cpfNumérico.substring(9, 11)) != Integer.parseInt(calcularDigitosVerificadoresDoCPF(cpfNumérico)))
            return false;

        return true;
    }

    public boolean sequenciaDeAlgarismosIguais(String cpf) {
        boolean mesmo_algarismo = true;
        for (int i = 0; i < 10; i++){
            if (cpf.charAt(i) != cpf.charAt(i + 1))
                mesmo_algarismo = false;
        }
        return mesmo_algarismo;
    }

    public String calcularDigitosVerificadoresDoCPF(String cpf) {
        int digVer1 = 0, digVer2 = 0;
        String DV;
        for (int i = 0; i < 9; i++) {
            int alg = cpf.charAt(i) - 48;
            digVer1 += alg * (10 - i);
        }
        digVer1 = 11 - digVer1 % 11;
        if (digVer1 > 9)
            digVer1 = 0;

        for (int i = 1; i < 9; i++) {
            int alg = cpf.charAt(i) - 48;
            digVer2 +=  alg * (10 - (i - 1));
        }
        digVer2 += digVer1 * 2;
        digVer2 = 11 - digVer2 % 11;
        if (digVer2 > 9)
            digVer2 = 0;

        DV = Integer.toString(digVer1) + Integer.toString(digVer2);  
        return DV;
    }

    public void lerClientePF(ClientePF cliente) {
        Scanner input = new Scanner(System.in);
        System.out.print("Lendo ClientePF: \nNome: ");
        setNome(input.nextLine());
        
        boolean Inválido = false;
        do {
            if (Inválido == true)
                System.out.println("CPF inválido. Insira novamente: ");
            System.out.print("CPF: ");
            setCPF(input.nextLine());
            Inválido = true;
        }while(cliente.validarCPF(cliente.getCPF()) == false);

        System.out.print("Data licença: [dd/MM/yyyy]");
        String data_licença = input.nextLine();
        DateTimeFormatter formatador_de_data = DateTimeFormatter.ofPattern("dd/MM/yyy", new Locale("pt", "BR"));
        cliente.dataNascimento = LocalDate.parse(data_licença, formatador_de_data);

        System.out.print("Nível de educação: ");
        setEducacao(input.nextLine());

        System.out.print("Data de nascimento: [dd/MM/yyyy]");
        String data_de_nascimento = input.nextLine();
        cliente.dataNascimento = LocalDate.parse(data_de_nascimento, formatador_de_data);

        System.out.print("Endereço: ");
        setEndereco(input.nextLine());

        System.out.print("Classe econômica: ");
        setClasseEconomica(input.nextLine());
    }
}
