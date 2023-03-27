package lab02;

public class Seguradora {
    //Declaração dos atríbutos da classe Seguradora
    private String nome;
    private String telefone;
    private String email;
    private String endereco;

    //Construtor
    public Seguradora(String nome, String telefone, String email, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    //Declaração dos métodos da classe Seguradora
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
    public String toString(Seguradora seguradora){
        String saída;
        saída = "As informações da seguradora são:\n" 
                + "Nome: " + seguradora.getNome() + ";\n" 
                + "Telefone: " + seguradora.getTelefone() + ";\n" 
                + "Email: " + seguradora.getEmail() + ";\n"
                + "Endereço: " + seguradora.getEndereco() + ";\n";
        return saída;
    }
}
