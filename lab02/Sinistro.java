package lab02;

import java.util.Random;

public class Sinistro {
    //Declaração dos atríbutos da classe Sinistro
    private int id;
    private String data;
    private String endereco;
    
    //Construtor 
    public Sinistro(int id, String data, String endereco) {
        this.id = id;
        this.data = data;
        this.endereco = endereco;
    }

    //Declaração dos métodos da classe Sinistro
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
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
    public int criaIdProcedutal() {
        Random gerador = new Random();
        int limite_superior = 10000;
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
}

/*toString() é um método que deve ser aplicado para todas as classes e tem a afunção de imprimir uma mensagem com os dados pertencentes a um objeto da classe */