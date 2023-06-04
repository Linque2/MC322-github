import java.time.*;
import java.util.*;

public class ClientePF extends Cliente {

    //Declarando os atributos da classe
    private final String cpf;
    private String genero;
    private String educacao;
    private LocalDate dataNasc;
    private ArrayList<Veículo> listaVeiculos;

    //Construtor
    public ClientePF(String cpf, String nome, String telefone, String endereco, String email, String genero, String educacao, LocalDate dataNasc) {
        super(nome, telefone, endereco, email);
        this.cpf = cpf;
        this.genero = genero;
        this.educacao = educacao;
        this.dataNasc = dataNasc;
        this.listaVeiculos = new ArrayList<Veículo>(10);
    }

    /*Declarando os métodos da classe ClientePF*/
    //getters and setters

    public String getCpf() {
        return this.cpf;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEducacao() {
        return this.educacao;
    }

    public void setEducacao(String educacao) {
        this.educacao = educacao;
    }

    public LocalDate getDataNasc() {
        return this.dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public ArrayList<Veículo> getListaVeiculos() {
        return this.listaVeiculos;
    }

    public void setListaVeiculos(ArrayList<Veículo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    //demais métodos
    public boolean cadastrarVeiculo() { //? Pensar se o setListaVeículo faz sentido
        Veículo veiculo = LerEntrada.lerVeiculo();
    
        if (getListaVeiculos().contains(veiculo)) {
            System.out.println("O veículo já está cadastrado");
            return false;
        }
        getListaVeiculos().add(veiculo);  //TODO Verificar se a placa do veículo já existe
        return true;
    }

    public boolean cadastrarVeiculo(Veículo veículo) { //? Pensar se o setListaVeículo faz sentido
        if (getListaVeiculos().contains(veículo)) {
            System.out.println("O veículo já está cadastrado");
            return false;
        }
        getListaVeiculos().add(veículo);  //TODO Verificar se a placa do veículo já existe
        return true;
    }

    public boolean removerVeiculo(Veículo veículo) {
       return getListaVeiculos().remove(veículo);    //O método ArrayList.remove(object o) devolve um valor do tipo boolean por padrão, true caso "o" tenha sido removido da lista e false caso "o" não exista na lista, ou seja, não foi removido.
    }

    public void listarVeiculos() {
        for (int i = 0; i < getListaVeiculos().size(); i++)
            System.out.println("[" + i + "]" + getListaVeiculos().get(i).toString());
    }

    @Override
    public String toString() {
        String saida = "ClientePF{nome: " + getNome() +
                        ", CPF: " + getCpf() + 
                        ", Telefone: " + getTelefone() +
                        ", Endereço: " + getEndereco() +
                        ", Email: " + getEmail() + 
                        ", Genero: " + getGenero() +
                        ", Educação: " + getEducacao() +
                        ", Data de nascimento: " + getDataNasc() + "}\n";

        return saida;
    }
}
    
    /* public double calculaScore() {
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

    public String toString() {
        String saida = "--Imprimindo Cliente" + getTipo() + "--\n" +
                       "Nome: " + getNome() + "\n" +
                       "CPF: " + getCPF() + "\n" +
                       "Endereco: " + getEndereco() + "\n" +
                       "Valor do seguro: " + getPreco_do_seguro();
        return saida;
    }*/

