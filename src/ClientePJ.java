import java.time.LocalDate;
import java.util.*;
public class ClientePJ extends Cliente {
    //Definindo os atributos da classe
    private String CNPJ;
    private LocalDate dataFundação;

    //Construtor
    public ClientePJ(String nome, String endereco, LinkedList listaVeiculos, String CNPJ, LocalDate dataFundação) {
        super(nome, endereco, listaVeiculos);
        this.CNPJ = CNPJ;
        this.dataFundação = dataFundação;
    }

    /*Definição dos métodos da classe ClientePJ*/
    //getters e setters

    public String getCNPJ() {
        return this.CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public LocalDate getDataFundaçãO() {
        return this.dataFundação;
    }

    public void setDataFundaçãO(LocalDate dataFundação) {
        this.dataFundação = dataFundação;
    }
}