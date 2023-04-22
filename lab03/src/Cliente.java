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

    /*public String toString(Cliente cliente) {
        String saída;
        saída = "As informações do cliente são:\n"
                + "ID: " + cliente.getNome() + ";\n"
                + "Data: " + cliente.getCpf() + ";\n"
                + "Endereço: " + cliente.getDataNascimento() + ";\n"
                + "Idade: " + cliente.getIdade() + ";\n"
                + "Endereço: " + cliente.getEndereco() + ";\n";
        return saída;
    }*/
    /*public void lerCliente(Cliente cliente) {
        Scanner input = new Scanner(System.in);
        System.out.print("Lendo Cliente: \nNome: ");
        setNome(input.nextLine());
        
        boolean Inválido = false;
        do {
            if (Inválido == true)
                System.out.println("CPF inválido. Insira novamente: ");
            System.out.print("CPF: ");
            setCpf(input.nextLine());
            Inválido = true;
        }while(cliente.validarCPF(cliente.getCpf()) == false);

        System.out.print("Data de nascimento: ");
        setDataNascimento(input.nextLine());
        System.out.print("Idade: ");
        setIdade(Integer.parseInt(input.nextLine()));
        System.out.print("Endereço: ");
        setEndereco(input.nextLine());

    }*/
}
