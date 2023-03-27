package lab02;

public class Veículo {
    //Declaração dos atríbutos da classe Veículo
    private String placa;
    private String marca;
    private String modelo;

    //Construtor
    public Veículo(String placa, String marca ,String modelo) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
    }

    //Declaração dos atríbutos da classe Veículo
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
    public String toString(Veículo veículo){
        String saída;
        saída = "As informações do veículo são:\n" 
                + "Placa: " + veículo.getPlaca() + ";\n" 
                + "Marca: " + veículo.getMarca() + ";\n" 
                + "Modelo: " + veículo.getModelo() + ";\n";
        return saída;
    }
}