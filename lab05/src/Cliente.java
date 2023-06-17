public abstract class Cliente {
    //Difinição dos atributos da classe Cliente
    //private final String tipo;

    private String nome;
    private String telefone;
    private String endereco;
    private String email;

    /*Construtor*/
    public Cliente(String nome, String telefone, String endereco, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
    }

    /*Definição dos métodos da classe Cliente*/
    //getters e setters
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
   
    /*Demais métodos */
    public Seguro lerSeguro(Seguradora seguradora) {
        return null;
    }

    public boolean cadastrarVeiculo() {
        return true;
    }

    public boolean cadastrarFrota(Frota frota) {
        return true;
    }

    public void listarVeiculos() {
    }

    public boolean atualizarFrota(Frota frota) {
        return true;
    }

    public boolean removerVeiculo(Veículo veículo) {    
        return true;    
    }

    public boolean removerVeiculo() {    
        return true;    
    }

    public void listarFrotas() {
    }

    public Frota buscarFrota(String code) {
        return null;
    }

    public Veículo buscarVeiculo(String veiculo) {
        return null;
    }
}
