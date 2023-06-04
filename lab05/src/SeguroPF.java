import java.time.*;

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
    public String toString() {
        String saida = "SeguroPF" + super.toString() + 
                        ", Veículo: " + getVeiculo() + 
                        ", Cliente: " + getCliente() + "}\n";
        return saida;
    }
}