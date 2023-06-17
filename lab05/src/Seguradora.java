import java.util.ArrayList;
import java.util.Scanner;

public class Seguradora {
    /*Declaração dos atributos da classe Seguradora */
    private static ArrayList<Seguradora> listaSeguradoras = new ArrayList<>(10);
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

    public Seguradora(String cnpj,String nome, String telefone, String endereco, String email) {    
        this.cnpj = cnpj;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.listaClientes = new ArrayList<Cliente>(10);
        this.listaSeguros = new ArrayList<Seguro>(10); 
    }

    //getters e setters
    public static ArrayList<Seguradora> getListaSeguradoras() {
        return listaSeguradoras;
    }

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

    public boolean gerarSeguro() { 
        Scanner input = new  Scanner(System.in);
        Seguro seguro;
        System.out.println("Insira o nome do cliente: ");
        String nomeCliente = input.nextLine();
        Cliente cliente = buscaCliente(nomeCliente);

        if (cliente == null) {
            System.out.println("O cliente " + nomeCliente + " não existe");
            return false;
        }
        seguro = cliente.lerSeguro(this);

        if (seguro == null) {
            System.out.println("Seguro inválido!");
            return false;
        }

        getListaSeguros().add(seguro);
        return true;   
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

    public boolean cancelarSeguro(ClientePF cliente, Veículo veiculo) {
        for (int i = 0; i < getListaSeguros().size(); i++) { 
            if (getListaSeguros().get(i).getCliente().equals(cliente)) {
                SeguroPF seguro = (SeguroPF)getListaSeguros().get(i);
                if (seguro.getVeiculo().equals(veiculo))
                    getListaSeguros().remove(seguro);
            } 
        }
        return true;
    }

    public boolean cancelarSeguro(ClientePJ cliente, Frota frota) {
        for (int i = 0; i < getListaSeguros().size(); i++) { 
            if (getListaSeguros().get(i).getCliente().equals(cliente)) {
                SeguroPJ seguro = (SeguroPJ)getListaSeguros().get(i);
                if (seguro.getFrota().equals(frota))
                    getListaSeguros().remove(seguro);
            } 
        }
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
        ArrayList<Seguro> segurosDoCliente = getSegurosPorCliente(nome);
        for (Seguro seguro : segurosDoCliente)
            cancelarSeguro(seguro.getId());
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
        
        for (int i = 0; i < getListaSeguros().size(); i++) {    //! Tentar aplicar o for aprimorado
            if (getListaSeguros().get(i).getCliente().equals(cliente)) {
                segurosDoCliente.add(getListaSeguros().get(i));
            } 
        }
        return segurosDoCliente;    //TODO adicionar um caso se o cliente não possuir seguros
    }

    public ArrayList<Sinistro> getSinistrosPorCliente(String nome) {
        ArrayList<Sinistro> sinistrosDoCliente = new ArrayList<Sinistro>(10);
        Cliente cliente = buscaCliente(nome);
        if (cliente == null) {
            System.out.println("O cliente " + nome + " não existe");
            return null;
        }

        for (int i = 0; i < getListaSeguros().size(); i++) {
            if (getListaSeguros().get(i).getCliente().equals(cliente)) {
                for (int j = 0; j < getListaSeguros().get(i).getListaSinistros().size(); j++)
                    sinistrosDoCliente.add(getListaSeguros().get(i).getListaSinistros().get(j));
            }
        }
        return sinistrosDoCliente;
    }

    public double calcularReceita() {
        double receita = 0;
        for (Seguro seguro : getListaSeguros())
            receita += seguro.getValorMensal();
        return receita;
    }

    public String toString() {
        String saida = "Seguradora{CNPJ: " + getCnpj() + 
                        ", Nome: " + getNome() +
                        ", Telefone: " + getTelefone() +
                        ", Endereço: " + getEndereco() +
                        ", Email: " + getEmail();
        return saida;
    }

    static Seguradora lerSeguradora() {
            Scanner input = new Scanner(System.in);
            Seguradora seguradora;
            String nome, telefone, endereco, email;
            System.out.println("--Lendo seguradora--\nNome: ");
            nome = input.nextLine();
            System.out.println("Telefone: ");
            telefone = input.nextLine();
            System.out.println("Endereço: ");
            endereco = input.nextLine();
            System.out.println("Email: ");
            email = input.nextLine();
            seguradora = new Seguradora(nome, telefone, endereco, email);
            System.out.println("Seguradora " + nome + " cadastrada com sucesso!");
            getListaSeguradoras().add(seguradora);
            System.out.println();
            return seguradora;
    }

    static void imprimirSeguradoras() {
        for (int i = 0; i < getListaSeguradoras().size(); i++)
            System.out.println("[" + i + "]" + getListaSeguradoras().get(i).toString());
    }

    public void imprimirSegurosPorCliente() {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o nome do cliente que se deseja visualizar os seguros: ");
        String nome = input.nextLine();
        ArrayList<Seguro> seguros = getSegurosPorCliente(nome);
        for (int i = 0; i < seguros.size(); i++)
            System.out.println("[" + i + "] " + seguros.get(i).toString());          
    }

    public void imprimirSinistrosPorCliente() {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o nome do cliente que se deseja visualizar os sinistros: ");
        String nome = input.nextLine();
        ArrayList<Sinistro> sinistros = getSinistrosPorCliente(nome);
        for (int i = 0; i < sinistros.size(); i++)
            System.out.println("[" + i + "] " + sinistros.get(i).toString());          
    }

    public boolean atulizarValoDosSeguros(Cliente cliente) {
        ArrayList<Seguro> seguros = getSegurosPorCliente(cliente.getNome());
        for (Seguro seguro : seguros)
            seguro.calcularValor();
        return true;
    }

    // métodos que buscam nas listas de seguradora 

    /* Método que devolve um cliente específico a partir da String nome inserida como parametro da função */
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
