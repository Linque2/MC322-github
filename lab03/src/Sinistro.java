import java.util.*;

public class Sinistro {
    //Declaração dos atríbutos da classe Sinistro
    private final int id;
    private String data;
    private String endereco;
    private Seguradora seguradora;
    private Veículo veiculo;
    private Cliente cliente;

    
    //Construtor 
    public Sinistro(String data, String endereco, Seguradora seguradora, Veículo veiculo, Cliente cliente) {
        this.id = criaIdAleatorio();
        this.data = data;
        this.endereco = endereco;
        this.seguradora = seguradora;            
        this.veiculo = veiculo;            
        this.cliente = cliente;                
    }

    /* Declaração dos métodos da classe Sinistro */
    //getters e setters
    public int getId() {
        return id;
    }
    /* public void setId(int id) {
        this.id = id;
    } */
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public Seguradora getSeguradora() {
        return this.seguradora;
    }
    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }
    public Veículo getVeiculo() {
        return this.veiculo;
    }
    public void setVeiculo(Veículo veiculo) {
        this.veiculo = veiculo;
    }
    public Cliente getCliente() {
        return this.cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    //demais métodos

    public int criaIdAleatorio() {
        Random gerador = new Random();
        int limite_superior = 1000000;
        int id = gerador.nextInt(limite_superior);
        return id;
    }

    public String toString(Sinistro sinistro){
        String saída;
        saída = "As informações do sinistro são:\n"
                + "ID: " + sinistro.getId() + ";\n"
                + "Data: " + sinistro.getData() + ";\n"
                + "Endereço: " + sinistro.getEndereco() + ";\n";
        return saída;
    }

    public void lerSinistro(Sinistro sinistro) {
        Scanner input = new Scanner(System.in);
        /* setId(criaIdAleatorio()); */ //!Adicionar impressão de ID
        System.out.print("Lendo Sinistro: \nData: ");
        setData(input.nextLine());
        System.out.print("Endereço: ");
        setEndereco(input.nextLine());
        //input.close(); //!testar se funciona

    }
}
