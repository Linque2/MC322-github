import java.time.LocalDate;
import java.util.*;
import java.time.format.DateTimeFormatter;

public class ClientePJ extends Cliente {
    //Definindo os atributos da classe
    private String CNPJ;
    private LocalDate dataFundação;

    //Construtor
    public ClientePJ(String nome, String endereco, LinkedList<Veículo> listaVeiculos, String CNPJ, LocalDate dataFundação) {
        super(nome, endereco, listaVeiculos);
        this.CNPJ = CNPJ;
        this.dataFundação = dataFundação;
    }

    /*Definição dos métodos da classe ClientePJ*/
    //getters e setters

    public String getCNPJ() {
        return this.CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public LocalDate getDataFundaçãO() {
        return this.dataFundação;
    }

    public void setDataFundaçãO(LocalDate dataFundação) {
        this.dataFundação = dataFundação;
    }

    //Demais métodos

    public boolean validarCNPJ(String cpf){
        String cnpjNumérico;
        cnpjNumérico = cpf.replaceAll("[^\\d]", "");             //Remove todos os caracteres não numéricos da string

        if (cnpjNumérico.length() != 14)                         //Verifica se o cpf possui 11 caracteres numéricos
            return false;

        if (sequenciaDeAlgarismosIguais(cnpjNumérico) == true)   //Verifica se todos os dígitos do cpf são iguais
            return false;

        if (Integer.parseInt(cnpjNumérico.substring(12, 14)) != Integer.parseInt(calcularDigitosVerificadoresDoCNPJ(cnpjNumérico)))
            return false;

        return true;
    }

    public boolean sequenciaDeAlgarismosIguais(String cnpj) {
        boolean mesmo_algarismo = true;
        for (int i = 0; i < 12; i++){
            if (cnpj.charAt(i) != cnpj.charAt(i + 1))
                mesmo_algarismo = false;
        }
        return mesmo_algarismo;
    }

    public String calcularDigitosVerificadoresDoCNPJ(String cpf) {
        int digVer1 = 0, digVer2 = 0;
        String DV;
        for (int i = 0; i < 12; i++) {
            int alg = cpf.charAt(i) - 48;
            if (i < 4)
                digVer1 += alg * (5 - i);
            else
                digVer1 += alg * (13 - i);
        }
        digVer1 = 11 - digVer1 % 11;
        if (digVer1 > 9)
            digVer1 = 0;

        for (int i = 0; i < 13; i++) {
            int alg = cpf.charAt(i) - 48;
            if (i < 5)
                digVer2 += alg * (6 - i);
            else
                digVer2 += alg * (14 - i);
        }
        digVer2 = 11 - digVer2 % 11;
        if (digVer2 > 9)
            digVer2 = 0;

        DV = Integer.toString(digVer1) + Integer.toString(digVer2);  
        return DV;
    }

    public void lerClientePJ(ClientePJ cliente) {
        Scanner input = new Scanner(System.in);
        System.out.print("Lendo ClientePJ: \nNome: ");
        setNome(input.nextLine());
        
        boolean Inválido = false;
        do {
            if (Inválido == true)
                System.out.println("CNPJ inválido. Insira novamente: ");
            System.out.print("CNPJ: ");
            setCNPJ(input.nextLine());
            Inválido = true;
        }while(cliente.validarCNPJ(cliente.getCNPJ()) == false);

        System.out.print("Data licença: [dd/MM/yyyy]");
        String data_fundação = input.nextLine();
        DateTimeFormatter formatador_de_data = DateTimeFormatter.ofPattern("dd/MM/yyy", new Locale("pt", "BR"));
        cliente.dataFundação = LocalDate.parse(data_fundação, formatador_de_data);

        System.out.print("Endereço: ");
        setEndereco(input.nextLine());
    }
}