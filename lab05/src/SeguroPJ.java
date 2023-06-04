import java.time.*;

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
    public String toString() {
        String saida = "SeguroPJ" + super.toString() + 
                        ", Frota: " + getFrota().toString() + 
                        ", Cliente: " + getCliente() + "}\n";
        return saida;
    }
}
