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


    //Construtor
    public Seguradora(String nome, String telefone, String email, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.listaSinistros = new LinkedList<Sinistro>();    
        this.listaClientes = new LinkedList<Cliente>();        
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

    //Demais métodos

    public boolean cadastrarCliente(Cliente cliente) {
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

    public boolean gerarSinistro() {
        Sinistro sinistro = new Sinistro("data", "endereco", null, null, null);
        Scanner input = new Scanner(System.in);
        System.out.print("--Lendo Sinistro--\nData: ");
        sinistro.setData(input.nextLine());
        System.out.print("Endereço: ");
        sinistro.setEndereco(input.nextLine());
        sinistro.setSeguradora(this); //?
        /*para adicionar a "seguradora," cliente e veículo é necessário listas já formadas
        */

        String nome_cliente;
        System.out.print("Nome do cliente: ");
        nome_cliente = input.nextLine();
        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getNome().equals(nome_cliente))
                sinistro.setCliente(listaClientes.get(i));
            else if (i == listaClientes.size()-1 && !listaClientes.get(i).getNome().equals(nome_cliente)){ 
                return false;
            } //TODO printar "o cliente ainda não foi cadastrado" //
        }
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
        return true;
    }

    public boolean visualizarSinistro(String cliente) {
        Scanner input = new Scanner(System.in);
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
            System.out.println("[" + i + "]" + listaSinistros.get(i).getId());
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
        //input.close(); //!testar se funciona
    }
}