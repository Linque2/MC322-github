import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Seguro {
    
    /*Declaração dos atributos da classe Seguro*/
    private final int id;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Seguradora seguradora;
    private ArrayList<Sinistro> listaSinistros;
    private ArrayList<Condutor> listaCondutores;
    private int valorMensal;

    /*Declaração dos métodos da classe Seguro */
    //Construtor
    public Seguro(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora, int valorMensal) {
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

    public int getValorMensal() {
        return this.valorMensal;
    }

    public void setValorMensal(int valorMensal) {
        this.valorMensal = valorMensal;
    }

    public Cliente getCliente() {
        return null;
    }

    //demais métodos
    public void desautorizarCondutor(Condutor condutor) {
        condutor.setAutorizacao(false);
    }

    public void autorizarCondutor(Condutor condutor) {
        condutor.setAutorizacao(true);
    }

    public double calcularValor() {
        double valor = 0;
        //TODO
        return valor;
    }

    public void geraSinistro() {
        //TODO
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
            saida += "[" + i + "]" + getListaCondutores().get(i).toString();
        return saida;
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
