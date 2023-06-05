import java.time.*;
import java.util.Scanner;

public class SeguroPJ extends Seguro{

    /*Declaração dos atributos da classe SeguroPJ*/
    private Frota frota;
    private ClientePJ cliente;

    /*Declaração dos métodos da classe SeguroPJ*/
    //Construtor
    public SeguroPJ(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora, int valorMensal, Frota frota, ClientePJ cliente) {
        super(dataInicio, dataFim, seguradora, valorMensal);
        this.frota = frota;
        this.cliente = cliente;
    }

    //getters e setters
    public Frota getFrota() {
        return this.frota;
    }

    public void setFrota(Frota frota) {
        this.frota = frota;
    }

    @Override
    public ClientePJ getCliente() {
        return this.cliente;
    }

    public void setCliente(ClientePJ cliente) {
        this.cliente = cliente;
    }
    
    //Demais métodos
    @Override
    public double calcularValor() {
        double valor = 0;
            valor = CalcSeguro.VALOR_BASE.getFator() * (10 * (getCliente().getQtdeFuncionarios()/10)) *
                                                     (1 + 1/(qtdeVeiculos() + 2)) *
                                                     (1 + 1/(getCliente().anosPosFundacao() + 2)) *
                                                     (2 + getListaSinistros().size()/10) *
                                                     (5 + qtdeSinistrosCondutores()/10);
            setValorMensal(valor);
        return valor;
    }

    /* Método que calcula a quantidade total de veículos que um ClientePJ possui, consideranto todas as suas frotas */
    public int qtdeVeiculos() {
        int qtde = 0;
        for (Frota frota : getCliente().getListaFrota())
            qtde += frota.getListaVeiculos().size();    
        return qtde;
    }

    /* Método que itera sobre a lista de condutores de um seguro, fazendo a somatória de seus sinistros */
    public int qtdeSinistrosCondutores() {
        int qtde = 0;
        for (Condutor condutor : getListaCondutores())
            qtde += condutor.getListaSinistros().size();
        return qtde;
    }

    @Override
    public String toString() {
        String saida = "SeguroPJ" + super.toString() + 
                        ", Frota: " + getFrota().toString() + 
                        ", Cliente: " + getCliente() + "}\n";
        return saida;
    }
}
