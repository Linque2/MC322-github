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

    public boolean removerVeiculo(Veículo veiculo) {    //! Implementar um método de busca, ou localizar pelo indice
        if (veiculo == null)
            System.out.println("O veículo não está na lista");
        return getListaVeiculos().remove(veiculo);    //O método ArrayList.remove(object o) devolve um valor do tipo boolean por padrão, true caso "o" tenha sido removido da lista e false caso "o" não exista na lista, ou seja, não foi removido.
    }

    public Veículo buscarVeiculo(String placa) {
        for (Veículo veiculo : getListaVeiculos())
            if (veiculo.getPlaca().equals(placa))
                return veiculo;
        return null;
    }

    public void listarVeiculos() {
        for (int i = 0; i < getListaVeiculos().size(); i++)
            System.out.println("[" + i + "]" + getListaVeiculos().get(i).toString());
    }

    public int calcularIdade() {
        int idade;
        idade = (Period.between(getDataNasc(), LocalDate.now())).getYears();
        return idade;
    }

    @Override
    public SeguroPF lerSeguro(Seguradora seguradora) {
        Scanner input = new Scanner(System.in);
        SeguroPF seguro;
        LocalDate dataInicio;
        LocalDate dataFim;
        int valorMensal;
        Veículo veiculo;

        System.out.println("Lendo SeguroPF: \n");

        System.out.println("Data de criação do seguro: ");
        dataInicio = LerEntrada.lerData();

        System.out.println("Data de término do seguro: ");
        dataFim = LerEntrada.lerData();

        valorMensal = 0;

        System.out.println("Qual veículo deve ser vinculado ao seguro?");
        listarVeiculos();
        System.out.println("Indice do veículo: ");
        int indice = Integer.parseInt(input.nextLine());
        veiculo = getListaVeiculos().get(indice);

        seguro = new SeguroPF(dataInicio, dataFim, seguradora, valorMensal, veiculo, this);
        return seguro;
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

