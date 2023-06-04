import java.util.ArrayList;
import java.util.Scanner;

public class Seguradora {
    /*Declaração dos atributos da classe Seguradora */
    private final String cnpj;
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Seguro> listaSeguros;

    /* Declaração dos métodos da classe Seguradora */
    //Construtor
    public Seguradora(String nome, String telefone, String endereco, String email) {    
        this.cnpj = LerEntrada.lerCnpj();
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.listaClientes = new ArrayList<Cliente>(10);
        this.listaSeguros = new ArrayList<Seguro>(10); 
    }

    //getters e setters
    public String getCnpj() {
        return this.cnpj;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Cliente> getListaClientes() {
        return this.listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public ArrayList<Seguro> getListaSeguros() {
        return this.listaSeguros;
    }

    public void setListaSeguros(ArrayList<Seguro> listaSeguros) {
        this.listaSeguros = listaSeguros;
    }

    //Demais métodos
    public void listarClientes() {
        for (int i = 0; i < getListaClientes().size(); i++) 
            System.out.println("[" + i +"]" + getListaClientes().get(i).toString());
    }

    public boolean gerarSeguro() {  //?Deveria implementar um método para leeitura de suguros?
        Scanner input = new  Scanner(System.in);
        Seguro seguro;
        System.out.println("Insira o nome do cliente: ");
        String nomeCliente = input.nextLine();
        Cliente cliente = buscaCliente(nomeCliente);

        if (cliente instanceof ClientePF) 
            seguro = LerEntrada.lerSeguro(this, (ClientePF)cliente);
        else if (cliente instanceof ClientePJ) 
            seguro = LerEntrada.lerSeguro(this, (ClientePJ)cliente);
        else {
            seguro = null;
        }
        /* if (cliente == null) {
            System.out.println("O cliente " + nomeCliente + " não existe");
            return false;
        } */

        if (seguro == null) {
            System.out.println("Seguro inválido!");
            return false;
        }

        getListaSeguros().add(seguro);
        return true;    //! Verificar se o polimorfismo está funcionando
    }

    public boolean cancelarSeguro(int ID) {
        Seguro seguro = buscaSeguro(ID);
        if (seguro == null) {
            System.out.println("O seguro " + ID + "não existe");
            return false;
        }

        getListaSeguros().remove(seguro);
        return true;
    }

    public boolean cadastrarCliente(ClientePF cliente) {
        if (Validacao.validarNome(cliente.getNome()) == false) {
            System.out.println("Não foi possível cadastrar o cliente (Nome inválido)\n");
            return false;
        }
        if (Validacao.validarCPF(cliente.getCpf()) == false) {
            System.out.println("Não foi possível cadastrar o cliente (CPF inválido)\n");
            return false;
        }
        getListaClientes().add(cliente);
        return true;
    }

    public boolean cadastrarCliente(ClientePJ cliente) {
        if (Validacao.validarNome(cliente.getNome()) == false) {
            System.out.println("Não foi possível cadastrar o cliente (Nome inválido)\n");
            return false;
        }
        if (Validacao.validarCNPJ(cliente.getCnpj()) == false) {
            System.out.println("Não foi possível cadastrar o cliente (CNPJ; inválido)\n");
            return false;
        }
        getListaClientes().add(cliente);
        return true;
    }

    public boolean cadastrarCliente() {  //?Deveria implementar a leitura do cliente neste métoddo?
        Cliente cliente;
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o tipo de cliente:\n" + 
                           "\t[PF] Para pessoa física;\n" + 
                           "\t[PJ] Para pessoa jurídica;");
        String tipo_cl = input.nextLine();

        if (tipo_cl.equals("PF"))
            cliente = LerEntrada.lerClientePF();
        else if(tipo_cl.equals("PJ")) 
            cliente = LerEntrada.lerClientePJ();
        else {
            System.out.println("Tipo inválido\n");
            return false;
        }
            
        

        if (getListaClientes().contains(cliente)) {
            System.out.println("O cliente [" + cliente.getNome() + "] já possui cadastro em nossa seguradora.");
            return false;   // O método devolve falso caso o cliente inserido já esteja na lista de clientes
        }

        System.out.println("Cliente cadastrado com sucesso!");
        getListaClientes().add(cliente);   
        return true;
    }

    public boolean removerCliente(String nome) {
        Cliente cliente = buscaCliente(nome);
        if (cliente == null)
            return false;
        getListaClientes().remove(cliente);
        return true;
    }

    public ArrayList<Seguro> getSegurosPorCliente(String nome) {
        ArrayList<Seguro> segurosDoCliente = new ArrayList<Seguro>(10);
        Cliente cliente = buscaCliente(nome);   //!pensar em como podemos aplicar o plomorfismo para estes métodos
        if (cliente == null) {
            System.out.println("O cliente " + nome + " não existe");
            return null;
        }
        
        for (int i = 0; i < getListaSeguros().size(); i++) {
            if (getListaSeguros().get(i).getCliente().equals(cliente)) {
                segurosDoCliente.add(getListaSeguros().get(i));
            } 
        }
        return segurosDoCliente;    //TODO adicionar um caso se o cliente não possuir seguros
    }

    public String toString() {
        String saida = "Seguradora{CNPJ: " + getCnpj() + 
                        ", Nome: " + getNome() +
                        ", Telefone: " + getTelefone() +
                        ", Endereço: " + getEndereco() +
                        ", Email: " + getEmail();
        return saida;
    }

    // métodos que iteram sobre as listas de seguradora 

    /*Método que devolve um cliente específico a partir da String nome inserida como parametro da função */
    public Cliente buscaCliente(String nome) {
        for (Cliente cliente : getListaClientes()) {
            if (cliente.getNome().equals(nome))
                return cliente;
        }
        return null;
    }

    public int buscaClienteIndex(String nome) {
        for (int i = 0; i < getListaClientes().size(); i++) {
            if (getListaClientes().get(i).getNome().equals(nome))
                return i;
        }
        return -1;
    }

    public Seguro buscaSeguro(int ID) {
        for (Seguro seguro : getListaSeguros()) {
            if (seguro.getId() == ID)
                return seguro;
        }
        return null;
    } 
}

    /* public boolean cadastrarCliente(ClientePF cliente) {
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
        Cliente cliente0;
        for (int i = 0; i < listaClientes.size(); i++) {
            cliente0 = listaClientes.get(i);
            if (cliente0.getTipo().equals("PF")){
                ClientePF cliente = (ClientePF)cliente0;
                System.out.println("[" + i + "]" + cliente.toString());
            } else if (cliente0.getTipo().equals("PJ")) {
                ClientePJ cliente = (ClientePJ)cliente0;
                System.out.println("[" + i + "]" + cliente.toString());
            }
        }
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

        recalcularPrecoSeguroCliente(cliente);

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

    public void recalcularPrecoSeguroCliente(Cliente cliente) {
        if (cliente.getTipo().equals("PF")){
            cliente.setPreco_do_seguro(calcularPrecoSeguroCliente((ClientePF)cliente));
        } else if (cliente.getTipo().equals("PJ")) {
            cliente.setPreco_do_seguro(calcularPrecoSeguroCliente((ClientePJ)cliente));
        }
    }

    public double calcularPrecoSeguroCliente(ClientePF cliente) {
        double preco = cliente.calculaScore() * (1 + cliente.getQuantidade_de_sinistros());
        System.out.println("O valor do seguro de " + cliente.getNome() + " é: " + preco);
        return preco;
    }

    public double calcularPrecoSeguroCliente(ClientePJ cliente) {
        double preco = cliente.calculaScore() * (1 + cliente.getQuantidade_de_sinistros());
        System.out.println("O valor do seguro de " + cliente.getNome() + " é: " + preco);
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
    } */

//TODO: calcularReceita(), calcularPrecoSeguro(), 