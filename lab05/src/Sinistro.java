import java.util.*;

public class Sinistro {

    /*Declaração dos atríbutos da classe Sinistro*/
    private final int id;
    private String data;
    private String endereco;
    private Condutor condutor;
    private Seguro seguro;

    /* Declaração dos métodos da classe Sinistro*/
    //Construtor 
    public Sinistro(String data, String endereco, Condutor condutor, Seguro seguro) {
        this.id = LerEntrada.criaIdAleatorio();
        this.data = data;
        this.endereco = endereco;
        this.condutor = condutor;
        this.seguro = seguro;             
    }

    //getters e setters
    public int getId() {
        return id;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Condutor getCondutor() {
        return this.condutor;
    }

    public void setCondutor(Condutor condutor) {
        this.condutor = condutor;
    }

    public Seguro getSeguro() {
        return this.seguro;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }


    //demais métodos
    public String toString(){
        String saída = null;
        //TODO
        return saída;
    }
}
