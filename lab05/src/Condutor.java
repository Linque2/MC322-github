import java.util.*;
import java.time.*;

public class Condutor {

    /*Definindo os atributos da classe */
    private final String cpf;
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    private LocalDate dataNasc;
    private ArrayList<Sinistro> listaSinistros;

    /*métodos da classe Condutor */
    //Construtor
    public Condutor(String cpf, String nome, String telefone, String endereco, String email, LocalDate dataNasc, boolean autorizacao) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.dataNasc = dataNasc;
        this.listaSinistros = new ArrayList<Sinistro>(5);
    }

    //getters e setters
    public String getCpf() {
        return this.cpf;
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

    public LocalDate getDataNasc() {
        return this.dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public ArrayList<Sinistro> getListaSinistros() {
        return this.listaSinistros;
    }

    public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
        this.listaSinistros = listaSinistros;
    }

    //demais métodos
    public boolean adicionarSinistro(Sinistro sinistro) {
        getListaSinistros().add(sinistro);  //!Devolver false caso o sinistro já existir na lista
        return true;
    }

    public String toString() {
        String saida = "Condutor{Nome: " + getNome() +
                        ", CPF:" + getCpf() +
                        ", Telefone: " + getTelefone() +
                        ", Endereço: " + getEndereco() + 
                        ", Email: " + getEmail() +
                        ", Data de nascimento: " + getDataNasc();
        return saida;
    }

}



