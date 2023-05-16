import java.util.LinkedList;
import java.util.Scanner;

public class Seguradora {
    //Declaração dos atríbutos da classe Seguradora
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private LinkedList<Sinistro> listaSinistros;
    private LinkedList<Cliente> listaClientes;
    private LinkedList<Double> listaEntradas;


    //Construtor
    public Seguradora(String nome, String telefone, String email, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.listaSinistros = new LinkedList<Sinistro>();    
        this.listaClientes = new LinkedList<Cliente>();     
        this.listaEntradas = new LinkedList<Double>();   
    }

    /* Declaração dos métodos da classe Seguradora */
    //getters e setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }    
    public LinkedList<Sinistro> getListaSinistros() {
        return this.listaSinistros;
    }
    public void setListaSinistros(Sinistro sinistro) {
        this.listaSinistros.add(sinistro);
    }
    public LinkedList<Cliente> getListaClientes() {
        return this.listaClientes;
    }
    public void setListaClientes(Cliente cliente) {
        this.listaClientes.add(cliente);
    }
    public LinkedList<Double> getListaEntradas() {
        return this.listaEntradas;
    }
    public void setListaEntradas(Double entradas) {
        this.listaEntradas.add(entradas);
    }

    //Demais métodos

    public boolean cadastrarCliente(ClientePF cliente) {
        setListaClientes(cliente);
        return true;
    }

    public boolean cadastrarCliente(ClientePJ cliente) {
        setListaClientes(cliente);
        return true;
    }

    public boolean removerCliente(String cliente) {
        for (int i = 0; i < getListaClientes().size(); i++){
            if (getListaClientes().get(i).getNome().equals(cliente)) {
                getListaClientes().remove(getListaClientes().get(i)); 
                return true;
            }
        }
        return false;
    }

    public void listarClientes() {
        for (int i = 0; i < listaClientes.size(); i++)
            System.out.println("[" + i + "]" + listaClientes.get(i).getNome());
    }

    public Cliente buscaCliente(String nome) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getNome().equals(nome))
                return cliente;
        }
        return null;
    }

    public int buscaClienteindex(String nome) {
        for (int i = 0; i < getListaClientes().size(); i++) {
            if (getListaClientes().get(i).getNome().equals(nome))
                return i;
        }
        return -1;
    }

    public boolean gerarSinistro() {
        Sinistro sinistro = new Sinistro("data", "endereco", null, null, null);
        Scanner input = new Scanner(System.in);
        System.out.print("--Lendo Sinistro--\nData: ");
        sinistro.setData(input.nextLine());
        System.out.print("Endereço: ");
        sinistro.setEndereco(input.nextLine());
        sinistro.setSeguradora(this); 

        String nome_cliente;
        System.out.print("Nome do cliente: ");
        nome_cliente = input.nextLine();
        Cliente cliente = buscaCliente(nome_cliente);
        if (cliente == null)
            return false;
        sinistro.setCliente(cliente);
        cliente.setQuantidade_de_sinistros(cliente.getQuantidade_de_sinistros() + 1);

        String placa;
        System.out.print("Placa do Veículo: ");
        placa = input.nextLine();
        for (int j = 0; j < sinistro.getCliente().getListaVeiculos().size(); j++) {
            if (sinistro.getCliente().getListaVeiculos().get(j).getPlaca().equals(placa)) 
                sinistro.setVeiculo(sinistro.getCliente().getListaVeiculos().get(j));
            else if (j == sinistro.getCliente().getListaVeiculos().size() && !sinistro.getCliente().getListaVeiculos().get(j).getPlaca().equals(placa)){ 
                return false;
            }
        }
        setListaSinistros(sinistro);

        if (cliente.getTipo().equals("PF")){ //Recalcula o seguro, após a alteração na quantidade de sinistros do cliente
            cliente.setPreco_do_seguro((calcularPrecoSeguroCliente((ClientePF)cliente)));
        } else if (cliente.getTipo().equals("PJ")) {
            cliente.setPreco_do_seguro((calcularPrecoSeguroCliente((ClientePJ)cliente)));
        }

        return true;
    }

    public Sinistro buscaSinistro(int ID) {
        for (Sinistro sinistro : getListaSinistros()) {
            if (sinistro.getId() == ID)
                return sinistro;
        }
        return null;
    }

    public void excluirSinistro(Sinistro sinistro) {
        getListaSinistros().remove(sinistro);
    }

    public boolean visualizarSinistro(String cliente) {
        for (int i = 0; i < listaSinistros.size(); i++) {
            if (listaSinistros.get(i).getCliente().getNome().equals(cliente))
                System.out.println("Sinistro " + listaSinistros.get(i).getId());
            else if(i == listaSinistros.size() && !listaSinistros.get(i).getCliente().getNome().equals(cliente)){ 
                return false;
            }
        }
        return true;
    }

    public void listaSinistros() {
        for (int i = 0; i < listaSinistros.size(); i++)
            System.out.println("[" + i + "]" + listaSinistros.get(i).toString());
    }


    public double calcularPrecoSeguroCliente(ClientePF cliente) {//TODO remover os valores de entrada antigos
        double preco = cliente.calculaScore() * (1 + cliente.getQuantidade_de_sinistros());
        listaEntradas.add(preco);
        System.out.println("O valor do seguro de " + cliente.getNome() + "é: " + preco);
        return preco;
    }

    public double calcularPrecoSeguroCliente(ClientePJ cliente) {
        double preco = cliente.calculaScore() * (1 + cliente.getQuantidade_de_sinistros());
        listaEntradas.add(preco);
        System.out.println("O valor do seguro de " + cliente.getNome() + "é: " + preco);
        return preco;
    }

    public double calcularReceita() { //TODO iterar na lista de clientes os valores das entradas
        double receita = 0;
        for (Cliente cliente : getListaClientes())
            receita +=  cliente.getPreco_do_seguro();
        return receita;
    }

    public void transferirSeguro(Cliente fornecedor, Cliente recebedor) {
        recebedor.getListaVeiculos().addAll(fornecedor.getListaVeiculos());
        recebedor.setQuantidade_de_sinistros(fornecedor.getQuantidade_de_sinistros() + recebedor.getQuantidade_de_sinistros());
        fornecedor.setQuantidade_de_sinistros(0);
        fornecedor.getListaVeiculos().clear();
    }

    public String toString(Seguradora seguradora) {
        String saída;
        saída = "As informações da seguradora são:\n" 
                + "Nome: " + seguradora.getNome() + ";\n" 
                + "Telefone: " + seguradora.getTelefone() + ";\n" 
                + "Email: " + seguradora.getEmail() + ";\n"
                + "Endereço: " + seguradora.getEndereco() + ";\n";
        return saída;
    }

    public void lerSeguradora(Seguradora seguradora) {
        Scanner input = new Scanner(System.in);
        System.out.print("Lendo Seguradora: \nNome: ");
        setNome(input.nextLine());
        System.out.print("Telefone: ");
        setTelefone(input.nextLine());
        System.out.print("Email: ");
        setEmail(input.nextLine());
        System.out.print("Endereço: ");
        setEndereco(input.nextLine());
    }
}

//TODO: calcularReceita(), calcularPrecoSeguro(), 