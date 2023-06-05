import java.time.*;
import java.util.Scanner;

public class SeguroPF extends Seguro{

    /*Declaração dos atributos da classe SeguroPF */
    private Veículo veiculo;
    private ClientePF cliente;

    /*Definição dos métodos da classe SeguroPF*/
    //Construtor
    public SeguroPF(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora, int valorMensal, Veículo veiculo, ClientePF cliente) {
        super(dataInicio, dataFim, seguradora, valorMensal);
        this.veiculo = veiculo;
        this.cliente = cliente;
    }

    //getters e setter
    public Veículo getVeiculo() {
        return this.veiculo;
    }

    public void setVeiculo(Veículo veiculo) {
        this.veiculo = veiculo;
    }

    @Override
    public ClientePF getCliente() {
        return this.cliente;
    }

    public void setCliente(ClientePF cliente) {
        this.cliente = cliente;
    }

    //Demais métodos
    @Override
    public double calcularValor() {
        double valor = 0;
            valor = CalcSeguro.VALOR_BASE.getFator() * (1 + 1/(getCliente().getListaVeiculos().size() + 2)) *
                                                    (2 + getListaSinistros().size()/10) *
                                                    (5 + qtdeSinistrosCondutores()/10);
        setValorMensal(valor);
        return valor;
    }

    /* Método que itera sobre a lista de condutores de um seguro, fazendo a somatória de seus sinistros */
    public int qtdeSinistrosCondutores() {
        int qtde = 0;
        for (Condutor condutor : getListaCondutores())
            qtde += condutor.getListaSinistros().size();
        return qtde;
    }

    public double fatorIdade() {
        double fatorIdade = 0;
        if (getCliente().calcularIdade() >= 18 && getCliente().calcularIdade() <= 30)
            fatorIdade *= CalcSeguro.FATOR_18_30.getFator();
        else if (getCliente().calcularIdade() >= 30 && getCliente().calcularIdade() <= 60)
            fatorIdade *= CalcSeguro.FATOR_30_60.getFator();
        else if (getCliente().calcularIdade() >= 60 && getCliente().calcularIdade() <= 90)
            fatorIdade *= CalcSeguro.FATOR_60_90.getFator(); 
        return fatorIdade;
    }

    @Override
    public String toString() {
        String saida = "SeguroPF" + super.toString() + 
                        ", Veículo:\n " + getVeiculo() + 
                        ", Cliente:\n " + getCliente() + "}\n";
        return saida;
    }
}