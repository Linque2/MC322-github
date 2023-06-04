import java.time.LocalDate;
import java.util.*;

public class ClientePJ extends Cliente {
    //Definindo os atributos da classe
    private final String cnpj;
    private LocalDate dataFundação;
    private ArrayList<Frota> listaFrota;

    //Construtor
    public ClientePJ(String cnpj, String nome, String telefone, String endereco, String email, LocalDate dataFundação) {
        super(nome, telefone, endereco, email);
        this.cnpj = cnpj;
        this.dataFundação = dataFundação;
        this.listaFrota = new ArrayList<Frota>(5); 
    }

    /*Definição dos métodos da classe ClientePJ*/
    //getters e setters

    public String getCnpj() {
        return this.cnpj;
    }

    public LocalDate getDataFundaçãO() {
        return this.dataFundação;
    }

    public void setDataFundaçãO(LocalDate dataFundação) {
        this.dataFundação = dataFundação;
    }

    public ArrayList<Frota> getListaFrota() {
        return this.listaFrota;
    }

    public void setListaFrota(ArrayList<Frota> listaFrota) {
        this.listaFrota = listaFrota;
    }

    //Demais métodos
    public void listarFrotas() {
        for (int i = 0; i < getListaFrota().size(); i++)
        System.out.println("[" + i + "]" + getListaFrota().get(i).toString());
    }

    @Override
    public String toString() {
        String saida = "ClientePJ{nome: " + getNome() +
                        ", CNPJ: " + getCnpj() + 
                        ", Telefone: " + getTelefone() +
                        ", Endereço: " + getEndereco() +
                        ", Email: " + getEmail() + 
                        ", Data de fundação: " + getDataFundaçãO() + "}\n";

        return saida;
    }
    
}
    /* public double calculaScore() {
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
                System.out.println("cnpj inválido. Insira novamente: ");
            System.out.print("cnpj: ");
            setcnpj(input.nextLine());
            Inválido = true;
        }while(Validacao.validarcnpj(cliente.getcnpj()) == false);

        System.out.print("Data licença: [dd/MM/yyyy]");
        String data_fundação = input.nextLine();
        DateTimeFormatter formatador_de_data = DateTimeFormatter.ofPattern("dd/MM/yyy", new Locale("pt", "BR"));
        cliente.dataFundação = LocalDate.parse(data_fundação, formatador_de_data);

        System.out.print("Endereço: ");
        setEndereco(input.nextLine());
        System.out.print("Número de funcionarios: ");
        setQtdeFuncionarios(Integer.parseInt(input.nextLine()));
    }

    public String toString() {
        String saida = "--Imprimindo Cliente" + getTipo() + "--\n" +
                           "Nome: " + getNome() + "\n" +
                           "cnpj: " + getcnpj() + "\n" +
                           "Endereco: " + getEndereco() + "\n" +
                           "Valor do seguro: " + getPreco_do_seguro() ;
        return saida;
    } */


