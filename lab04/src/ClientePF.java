import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ClientePF extends Cliente {
    //Declarando os atributos da classe
    private String CPF;
    private String genero;
    private LocalDate dataLicenca;
    private String educacao;
    private LocalDate dataNascimento;
    private String classeEconomica;
    private int Idade;

    //Construtor
    public ClientePF(String nome, String endereco,LinkedList<Veículo> listaVeiculos , LocalDate dataLicenca, String educacao, String genero, String classeEconomica, String CPF, LocalDate dataNascimento, int quantidade_de_sinistros, String tipo) {
        super(nome, endereco, listaVeiculos, quantidade_de_sinistros, tipo); //**
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

    public void setIdade() {
        this.Idade = (Period.between(getDataNascimento(), LocalDate.now())).getYears();
    }

    public int getIdade() {
        setIdade();
        return this.Idade;
    }

    //demais métodos
    
    public double calculaScore() {
        double score = CalcSeguro.VALOR_BASE.getFator() * quantidadeCarros();
        if (getIdade() >= 18 && getIdade() <= 30)
            score *= CalcSeguro.FATOR_18_30.getFator();
        else if (getIdade() >= 30 && getIdade() <= 60)
            score *= CalcSeguro.FATOR_30_60.getFator();
        else if (getIdade() >= 60 && getIdade() <= 90)
            score *= CalcSeguro.FATOR_60_90.getFator(); 
        return score;
    }

    public void lerClientePF(ClientePF cliente) {
        Scanner input = new Scanner(System.in);
        System.out.print("Lendo ClientePF: \n ");

        boolean Inválido = false;
        do {
            if (Inválido == true)
                System.out.println("Nome inválido. Insira novamente: ");
            System.out.print("Nome: ");
            setNome(input.nextLine());
            Inválido = true;
        }while(Validacao.validarNome(cliente.getNome()) == false);
        
        Inválido = false;
        do {
            if (Inválido == true)
                System.out.println("CPF inválido. Insira novamente: ");
            System.out.print("CPF: ");
            setCPF(input.nextLine());
            Inválido = true;
        }while(Validacao.validarCPF(cliente.getCPF()) == false);

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
