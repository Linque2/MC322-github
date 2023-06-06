import java.time.*;
import java.util.*;

public class ClientePJ extends Cliente {
    //Definindo os atributos da classe
    private final String cnpj;
    private LocalDate dataFundação;
    private ArrayList<Frota> listaFrota;
    private int qtdeFuncionarios;

    //Construtor
    public ClientePJ(String cnpj, String nome, String telefone, String endereco, String email, LocalDate dataFundação, int qtdeFuncionarios) {
        super(nome, telefone, endereco, email);
        this.cnpj = cnpj;
        this.dataFundação = dataFundação;
        this.listaFrota = new ArrayList<Frota>(5); 
        this.qtdeFuncionarios = qtdeFuncionarios;
    }

    /*Definição dos métodos da classe ClientePJ*/
    //getters e setters

    public String getCnpj() {
        return this.cnpj;
    }

    public LocalDate getDataFundação() {
        return this.dataFundação;
    }

    public void setDataFundação(LocalDate dataFundação) {
        this.dataFundação = dataFundação;
    }

    public ArrayList<Frota> getListaFrota() {
        return this.listaFrota;
    }

    public void setListaFrota(ArrayList<Frota> listaFrota) {
        this.listaFrota = listaFrota;
    }

    public int getQtdeFuncionarios() {
        return this.qtdeFuncionarios;
    }

    public void setQtdeFuncionarios(int qtdeFuncionarios) {
        this.qtdeFuncionarios = qtdeFuncionarios;
    }

    //Demais métodos
    public void listarFrotas() {
        for (int i = 0; i < getListaFrota().size(); i++)
        System.out.println("[" + i + "]" + getListaFrota().get(i).toString());
    }

    public boolean cadastrarFrota(Frota frota) {
        if (getListaFrota().contains(frota)){
            System.out.println("Frota já cadastrada!");
            return false;
        }

        getListaFrota().add(frota);
        return true;
    }

    public boolean cadastrarVeiculo() { //? Pensar se o setListaVeículo faz sentido
        Scanner input = new Scanner(System.in);
        Veículo veiculo = LerEntrada.lerVeiculo();
        int Indice;
        System.out.println("A qual frota o carro será adicionado?");
        listarFrotas();
        System.out.print("Índice: ");
        Indice = Integer.parseInt(input.nextLine());

        if(Indice >= getListaFrota().size()) {
            System.out.println("O índice inserido não corresponde a nenhuma frota.");
            return false;
        }

        if (getListaFrota().get(Indice).getListaVeiculos().contains(veiculo)) {
            System.out.println("O veículo já está cadastrado");
            return false;
        }
        getListaFrota().get(Indice).addVeiculo(veiculo);
        System.out.println("Veículo cadastrado com sucesso!");
        return true;
    }

    public void listarVeiculos() {
        listarFrotas();
    }

    public boolean removerVeiculo() {   
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o code da frota a qual o veículo pertence: ");
        listarFrotas();
        String code = input.nextLine();
        Frota frota = buscarFrota(code);

        System.out.print("Agora digite a placa do veículo em questão: ");
        String placa = input.nextLine();
        Veículo veiculo = frota.buscarVeiculo(placa);
        if (veiculo == null)
            System.out.println("O veículo não está na frota");
        return frota.getListaVeiculos().remove(veiculo);    
    }

    public boolean atualizarFrota(Frota frota) {    //! buscar em listaFrota, if frota == null -> return false
        Scanner input = new Scanner(System.in);
        final int sair = 0, remover = 1, adicionar = 2, apagarFrota = 3;
        int entrada = -1;
        Veículo veiculo;

        while (entrada != sair) {
            System.out.println("Insira a operação desejada: \n" +
                            "[0]Sair;\n" +
                            "[1]Remover veículo;\n" +
                            "[2]Adicionar veículo;\n" +
                            "[3]Excluir frota"); 
            entrada = Integer.parseInt(input.nextLine());
            switch(entrada){
                case sair:
                    break;
                case remover:
                    System.out.println("Qual veículo deseja remover? \n Placa: ");
                    veiculo = frota.buscarVeiculo(input.nextLine());
                    frota.removerVeiculo(null);
                    break;
                case adicionar:
                    veiculo = LerEntrada.lerVeiculo();
                    frota.addVeiculo(veiculo);
                    break;
                case apagarFrota:
                    getListaFrota().remove(frota);
                    break;
            }
        }

        return true;
    }

    public boolean getVeiculoPorFrota(Frota frota) {    //! melhorar a visualização; devolver false caso frota == null <- buscar frota na listaFrotas
        System.out.println(frota.listarVeiculos());
        return true;
    }

    @Override
    public SeguroPJ lerSeguro(Seguradora seguradora) {
        Scanner input = new Scanner(System.in);
        SeguroPJ seguro;
        LocalDate dataInicio;
        LocalDate dataFim;
        int valorMensal;
        Frota frota;

        System.out.println("Lendo SeguroPF: \n");

        System.out.println("Data de criação do seguro: ");
        dataInicio = LerEntrada.lerData();

        System.out.println("Data de término do seguro: ");
        dataFim = LerEntrada.lerData();

        valorMensal = 0;

        System.out.println("Qual frota deve ser vinculada ao seguro?");
        listarFrotas();
        System.out.println("Indice da frota: ");
        int indice = Integer.parseInt(input.nextLine());
        frota = getListaFrota().get(indice);


        seguro = new SeguroPJ(dataInicio, dataFim, seguradora, valorMensal, frota, this);
        return seguro;
    }

    public int anosPosFundacao() {
        int idade;
        idade = (Period.between(getDataFundação(), LocalDate.now())).getYears();
        return idade;
    }

    public Frota buscarFrota(String code) {
        for (Frota frota : getListaFrota())
            if (frota.getCode().equals(code))
                return frota;
        return null;
    }

    @Override
    public String toString() {
        String saida = "ClientePJ{nome: " + getNome() +
                        ", CNPJ: " + getCnpj() + 
                        ", Telefone: " + getTelefone() +
                        ", Endereço: " + getEndereco() +
                        ", Email: " + getEmail() + 
                        ", Data de fundação: " + getDataFundação() + "}\n";

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


