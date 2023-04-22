import java.util.*;

public class Main {
    public static void main(String[] args) {
        Seguradora seguradora = new Seguradora(null, null, null, null);
        seguradora.lerSeguradora(seguradora);

        Scanner input = new Scanner(System.in);
        System.out.print("Digite o número de processos que deseja realizar: ");
        int repetições = Integer.parseInt(input.nextLine());
        
        for (int i = 0; i < repetições; i++) {

        System.out.println("Digite o número da ação que deseja:\n" +
                            "\t[1] Cadastrar cliente;\n" + 
                            "\t[2] Gerar sinistro;\n" +
                            "\t[3] Remover cliente;\n" +
                            "\t[4] Listar clientes;\n" +
                            "\t[5] Listar sinistros;\n" +
                            "\t[6] Visualizar sinistro;");
        
        int ação = Integer.parseInt(input.nextLine());
        boolean sucesso;

        switch(ação) {
            case 1: //cadastrar cliente
                System.out.println("Digite o tipo de cliente:\n" + 
                                    "\t[PF] Para pessoa física;\n" + 
                                    "\t[PJ] Para pessoa jurídica;");
                String tipo_cl = input.nextLine();
                if (tipo_cl.equals("PF")){
                    ClientePF cliente = new ClientePF("nome", "endereço", null, null, "educação", "genero", "classeEconomica", "CPF", null);
                    cliente.lerClientePF(cliente);
                    seguradora.cadastrarCliente(cliente);
                } else if(tipo_cl.equals("PJ")) {
                    ClientePJ cliente = new ClientePJ("nome", "endereço", null, "CNPJ", null);
                    cliente.lerClientePJ(cliente);
                    seguradora.cadastrarCliente(cliente);
                }
                System.out.println("Cliente cadastrado com sucesso!");
                break;
            case 2: //gerar sinistro
                sucesso = seguradora.gerarSinistro();
                if (sucesso == true)
                    System.out.println("Sinistro gerado com sucesso!");
                else
                    System.out.println("Não foi possível concluir a geração do sinistro.");
                break;
            case 3: //remover cliente
            System.out.println("Digite o nome do cliente que deseja remover: ");
                sucesso = seguradora.removerCliente(input.nextLine());
                if (sucesso == true) 
                    System.out.println("Cliente removido com sucesso!");
                else
                    System.out.println("Não foi possível fazer a remoção do cliente.");
                break;
            case 4: //listar clientes
                seguradora.listarClientes();
                break;
            case 5: //listar sinistros
                seguradora.listaSinistros();
                break;
            case 6: //visualizar sinistro
                System.out.println("Digite o nome do cliente referente ao sinistro: ");
                seguradora.visualizarSinistro(input.nextLine());
                break;
        }
        }
        input.close();
    }
}