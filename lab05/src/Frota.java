import java.util.ArrayList;

public class Frota {
    //definindo os atributos da classe
    private String code;
    private ArrayList<Veículo> listaVeiculos;

    //declaração do construtor da classe
    public Frota(String code) {
        this.code = code;
        this.listaVeiculos = new ArrayList<Veículo>(5);
    }

    /*Definição dos métodos da classe Frota*/
    //getters e setters
    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ArrayList<Veículo> getListaVeiculos() {
        return this.listaVeiculos;
    }

    public void setListaVeiculos(ArrayList<Veículo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }
    
    //Demais métodos
    public boolean addVeiculo(Veículo veículo) { //? Pensar se o setListaVeículo faz sentido
        getListaVeiculos().add(veículo);  //TODO Verificar se a placa do veículo já existe
        return true;
    }

    public boolean removerVeiculo(Veículo veículo) {    //! Adicionar um método de busca por string, ou remover pelo indice
        return getListaVeiculos().remove(veículo);    //O método ArrayList.remove(object o) devolve um valor do tipo boolean por padrão, true caso "o" tenha sido removido da lista e false caso "o" não exista na lista, ou seja, não foi removido.
     }

    public String listarVeiculos() {
        String saida = "";
        for (int i = 0; i < getListaVeiculos().size(); i++)
            saida += "\t" + getListaVeiculos().get(i).toString();
        return saida;
    }

    public Veículo buscarVeiculo(String placa) {
        for (Veículo veiculo : getListaVeiculos())
            if (veiculo.getPlaca().equals(placa))
                return veiculo;
        return null;
    }

    public String toString() {
        String saida = "Frota{Código: " + getCode() +
                        ", Veículos: \n" + listarVeiculos() + "}\n";
        return saida;
    }
}
