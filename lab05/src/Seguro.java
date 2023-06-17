import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Seguro {
    
    /*Declaração dos atributos da classe Seguro*/
    private final int id;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Seguradora seguradora;
    private ArrayList<Sinistro> listaSinistros;
    private ArrayList<Condutor> listaCondutores;
    private double valorMensal;

    /*Declaração dos métodos da classe Seguro */
    //Construtor
    public Seguro(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora, double valorMensal) {
        this.id = LerEntrada.criaIdAleatorio();
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.seguradora = seguradora;
        this.listaSinistros = new ArrayList<Sinistro>();
        this.listaCondutores = new ArrayList<Condutor>();
        this.valorMensal = valorMensal;
    }

    //getters e setters
    public int getId() {
        return this.id;
    }

    public LocalDate getDataInicio() {
        return this.dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return this.dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public Seguradora getSeguradora() {
        return this.seguradora;
    }

    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }

    public ArrayList<Sinistro> getListaSinistros() {
        return this.listaSinistros;
    }

    public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
        this.listaSinistros = listaSinistros;
    }

    public ArrayList<Condutor> getListaCondutores() {
        return this.listaCondutores;
    }

    public void setListaCondutores(ArrayList<Condutor> listaCondutores) {
        this.listaCondutores = listaCondutores;
    }

    public double getValorMensal() {
        return this.valorMensal;
    }

    public void setValorMensal(double valorMensal) {
        this.valorMensal = valorMensal;
    }

    public Cliente getCliente() {
        return null;
    }

    //demais métodos
    public boolean autorizarCondutor() {
        Condutor condutor = LerEntrada.lerCondutor();
        getListaCondutores().add(condutor);
        return true;
    }

    public boolean desautorizarCondutor() {
        Scanner input = new Scanner(System.in);
        int Indice;
        Condutor condutor;
        System.out.println("Insira o indice do condutor associado: ");
        listarCondutores();
        System.out.println("Indice: ");
        Indice = Integer.parseInt(input.nextLine());
        condutor = getListaCondutores().get(Indice);
        getListaCondutores().remove(condutor);
        return true;
    }

    public double calcularValor() {
        double valor = 0;
        return valor;
    }


    public boolean gerarSinistro(Sinistro sinistro) {
        getListaSinistros().add(sinistro);
        return true;
    }

    public boolean gerarSinistro() {
        Scanner input = new  Scanner(System.in);
        int Indice;
        Sinistro sinistro;
        LocalDate data;
        String endereco;
        Condutor condutor;
        Seguro seguro;

        System.out.println("Lendo Sinistro: \nData: ");
        data = LerEntrada.lerData();

        System.out.println("Endereço: ");
        endereco = input.nextLine();

        System.out.println("Insira o indice do condutor associado: ");
        System.out.println(listarCondutores());
        System.out.println("Indice: ");
        Indice = Integer.parseInt(input.nextLine());
        if (Indice >= getListaCondutores().size()) {
            System.out.println("O índice inserido não contém nenhum condutor");
            return false;
        }
        condutor = getListaCondutores().get(Indice);

        seguro = this;

        sinistro = new Sinistro(data, endereco, condutor, seguro);
        condutor.adicionarSinistro(sinistro);
        getListaSinistros().add(sinistro);

        return true;    
    }

    public boolean removerSinistro(Sinistro sinistro) {
        if (sinistro == null) {
            System.out.println("O sinistro digitado não existe");
            return false;
        }
        getListaSinistros().remove(sinistro);
        sinistro.getCondutor().getListaSinistros().remove(sinistro);
        System.out.println("Sinistro removido com sucesso!");
        return true;
    }

    public String listarSinistros() {
        String saida = "";
        for (int i = 0; i < getListaSinistros().size(); i++)
            saida += "[" + i + "]" + getListaSinistros().get(i).toString();
        return saida;
    }

    public String listarCondutores() {
        String saida = "";
        for (int i = 0; i < getListaCondutores().size(); i++)
            saida += "[" + i + "] " + getListaCondutores().get(i).toString() + "\n";
        return saida;
    }

    public Sinistro buscaSinistro(int ID) {
        for (Sinistro sinistro : getListaSinistros())
            if (sinistro.getId() == ID)
                return sinistro;
        return null;
    }

    public String toString() {
        String saida = "{ID: " + getId() +
                        ", Data de inicio: " + getDataInicio() +
                        ", Data de Fim: " + getDataFim() + 
                        ", Seguradora: " +  getSeguradora().toString() + 
                        ", Sinistros: " + listarSinistros() +
                        ", Condutores: " + listarCondutores() + 
                        ", Valor mensal: " + getValorMensal();
        return saida;
    }
}
