package lab02;

import java.util.Scanner;

public class Cliente {
    //Difinição dos atributos da classe Cliente
    private String nome;
    /* private String cpf; */
    /* private String dataNascimento; */
    /* private int idade; */
    private String endereco;

    //Construtor
    public Cliente(String nome, String cpf, String dataNascimento, int idade, String endereco) {
        this.nome = nome;
        /* this.cpf = cpf; */
        /* this.dataNascimento = dataNascimento; */
        /* this.idade = idade; */
        this.endereco = endereco;
    }

    //Definição dos métodos da classe Cliente
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

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
    public String toString(Cliente cliente) {
        String saída;
        saída = "As informações do cliente são:\n"
                + "ID: " + cliente.getNome() + ";\n"
                + "Data: " + cliente.getCpf() + ";\n"
                + "Endereço: " + cliente.getDataNascimento() + ";\n"
                + "Idade: " + cliente.getIdade() + ";\n"
                + "Endereço: " + cliente.getEndereco() + ";\n";
        return saída;
    }
    public void lerCliente(Cliente cliente) {
        Scanner input = new Scanner(System.in);
        System.out.print("Lendo Cliente: \nNome: ");
        setNome(input.nextLine());
        
        boolean Inválido = false;
        do {
            if (Inválido == true)
                System.out.println("CPF inválido. Insira novamente: ");
            System.out.print("CPF: ");
            setCpf(input.nextLine());
            Inválido = true;
        }while(cliente.validarCPF(cliente.getCpf()) == false);

        System.out.print("Data de nascimento: ");
        setDataNascimento(input.nextLine());
        System.out.print("Idade: ");
        setIdade(Integer.parseInt(input.nextLine()));
        System.out.print("Endereço: ");
        setEndereco(input.nextLine());

    }
}
