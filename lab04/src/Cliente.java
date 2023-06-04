import java.util.*;

public class Cliente {
    //Difinição dos atributos da classe Cliente
    private final String tipo;
    private String nome;
    private String endereco;
    private LinkedList<Veículo> listaVeiculos;
    private int quantidade_de_sinistros;
    private double preco_do_seguro; 

    //Construtor
    public Cliente(String nome, String endereco, LinkedList<Veículo> listaVeiculos, int quantidade_de_sinistros, String tipo) {
        this.nome = nome;
        this.endereco = endereco;
        this.listaVeiculos = new LinkedList<Veículo>();
        this.quantidade_de_sinistros = 0;
        this.tipo = tipo;
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

    public int getQuantidade_de_sinistros() {
        return this.quantidade_de_sinistros;
    }

    public void setQuantidade_de_sinistros(int quantidade_de_sinistros) {
        this.quantidade_de_sinistros = quantidade_de_sinistros;
    }

    public double getPreco_do_seguro() {
        return this.preco_do_seguro;
    }
    public void setPreco_do_seguro(double preco_do_seguro) {
        this.preco_do_seguro = preco_do_seguro; 
    }
    public String getTipo() {
        return this.tipo;
    }
    

    public void listarVeiculos() {
        int i = 0;
        for (Veículo veiculo : getListaVeiculos()) {
            System.out.println("[" + i + "]" + veiculo);
            i++;
        }
    }
    public boolean removerVeiculo(String placa) {
        for (Veículo veiculo : getListaVeiculos()) {
            if (veiculo.getPlaca().equals(placa))
                getListaVeiculos().remove(veiculo);
                return true;
        }
        return false;
    }

    public int quantidadeCarros() {
        return this.getListaVeiculos().size();
    }

    public String toString() {
        String saida = "--Imprimindo Cliente" + getTipo() + "--\n" +
                           "Nome: " + getNome() + "\n" +
                           "Endereco: " + getEndereco() + "\n" +
                           "Valor do seguro: " + getPreco_do_seguro() ;
        return saida;
    }

}
