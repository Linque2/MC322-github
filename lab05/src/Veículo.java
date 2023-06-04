
public class Veículo {
    //Declaração dos atríbutos da classe Veículo
    private String placa;
    private String marca;
    private String modelo;
    private int anoFabricacao;

    //Construtor
    public Veículo(String placa, String marca ,String modelo, int anoFabricacao) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
    }

    /* Declaração dos atríbutos da classe Veículo */
    //getters e setters
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }    
    public int getAnoFabricacao() {
        return this.anoFabricacao;
    }
    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }
    
    //Demais métodos
    public String toString(){
        String saída;
        saída = "Veículo{Placa: " + getPlaca() +
                ", Marca: " + getMarca() +
                ", Modelo: " + getModelo() + "}\n";
        return saída;
    }
}