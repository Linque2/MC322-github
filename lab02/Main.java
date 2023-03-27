package lab02;

public class Main {
    public static void main(String[] args) {
        Seguradora seguradora = new Seguradora("nome", "telefone", "email", "endereco");     //pensar em como dar o input para os atributos de cada classe
        System.out.println(seguradora.toString(seguradora));
        
        Sinistro sinistro = new Sinistro(0, "00/00/0000", "endereco");
        sinistro.setId(sinistro.criaIdProcedutal());
        System.out.println(sinistro.toString(sinistro));

        Cliente cliente = new Cliente("nome", "460.025.688-32", "data_de_nascimento", 0, "endereço");
        cliente.validarCPF(cliente.getCpf());
        System.out.println(cliente.toString(cliente));

        Veículo veículo = new Veículo("AAA0A00", "marca", "modelo");
        System.out.println(veículo.toString(veículo));
    }
}
