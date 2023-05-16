import java.time.LocalDate;
import java.util.*;
import java.time.format.DateTimeFormatter;

public class ClientePJ extends Cliente {
    //Definindo os atributos da classe
    private String CNPJ;
    private LocalDate dataFundação;
    private int qtdeFuncionarios;

    //Construtor
    public ClientePJ(String nome, String endereco, LinkedList<Veículo> listaVeiculos, String CNPJ, LocalDate dataFundação, int qtdeFuncionarios, int quantidade_de_sinistros, String tipo) {
        super(nome, endereco, listaVeiculos, quantidade_de_sinistros, tipo);
        this.CNPJ = CNPJ;
        this.dataFundação = dataFundação;
        this.qtdeFuncionarios = qtdeFuncionarios;
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

    public int getQtdeFuncionarios() {
		return this.qtdeFuncionarios;
	}

	public void setQtdeFuncionarios(int qtdeFuncionarios) {
		this.qtdeFuncionarios = qtdeFuncionarios;
	}

    //Demais métodos

    public double calculaScore() {
        double score = CalcSeguro.VALOR_BASE.getFator() * (1 + (getQtdeFuncionarios()/100)) * quantidadeCarros();
        return score;
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
        }while(Validacao.validarCNPJ(cliente.getCNPJ()) == false);

        System.out.print("Data licença: [dd/MM/yyyy]");
        String data_fundação = input.nextLine();
        DateTimeFormatter formatador_de_data = DateTimeFormatter.ofPattern("dd/MM/yyy", new Locale("pt", "BR"));
        cliente.dataFundação = LocalDate.parse(data_fundação, formatador_de_data);

        System.out.print("Endereço: ");
        setEndereco(input.nextLine());
        System.out.print("Número de funcionarios: ");
        setQtdeFuncionarios(Integer.parseInt(input.nextLine()));
    }
}

// TODO: calculaScore()