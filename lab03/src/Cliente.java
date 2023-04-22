import java.util.*;

public class Cliente {
    //Difinição dos atributos da classe Cliente
    private String nome;
    private String endereco;
    private LinkedList<Veículo> listaVeiculos;

    //Construtor
    public Cliente(String nome, String endereco, LinkedList<Veículo> listaVeiculos) {
        this.nome = nome;
        this.endereco = endereco;
        this.listaVeiculos = new LinkedList<Veículo>();
    }

    /*Definição dos métodos da classe Cliente*/
    //getters e setters
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public LinkedList<Veículo> getListaVeiculos() {
        return this.listaVeiculos;
    }

    public void setListaVeiculos(Veículo veiculo) {
        this.listaVeiculos.add(veiculo);
    }
}
