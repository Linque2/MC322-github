import java.util.*;

public class Main {
    public static void main(String[] args) {
        Seguradora seguradora = new Seguradora("segI", "11999990000", "Rua A", "seg1@email.com");
        ClientePF cliente0 = new ClientePF("172.242.425-78", "clienteI", "(73) 98084-6147", "Rua B", "cliente1@email.com", "masculino", "Ensino médio completo", LerEntrada.lerData("10/07/2000"));
        ClientePJ cliente1 = new ClientePJ("64.284.773/0001-20", "clienteII", "(98) 96721-2761", "Rua C", "cliente2@email.com", LerEntrada.lerData("12/11/2016"), 10);
        seguradora.cadastrarCliente(cliente0);
        seguradora.cadastrarCliente(cliente1);
        seguradora.listarClientes();

        Veículo veiculo0 = new Veículo("NWG-7154", "marca0", "modelo0", 1998);
        cliente0.cadastrarVeiculo(veiculo0);
        seguradora.gerarSeguro();
        System.out.println(seguradora.getSegurosPorCliente("clienteI"));

        Frota frota0 = new Frota("00001");
        cliente1.cadastrarFrota(frota0);
        frota0.addVeiculo(veiculo0);
        seguradora.gerarSeguro();
        System.out.println(seguradora.getSegurosPorCliente("clienteII"));

        

        /* Seguradora seguradora = new Seguradora(null, null, null, null);
        seguradora.lerSeguradora(seguradora);

        Scanner input = new Scanner(System.in);

        boolean fim = false;
        double preco;

        while (fim == false) {
            System.out.println("Insira o comando que deseja: \n" +
                           "1-) Cadastros;\n" + 
                           "2-) Listar;\n" + 
                           "3-) Excluir;\n" +
                           "4-) Gerer sinistro;\n" +
                           "5-) Transferir seguro;\n" +
                           "6-) Calcular receita seguradora;\n" +
                           "7-) Sair;");
            int comando = Integer.parseInt(input.nextLine());
            switch(comando){
                case 1:
                    System.out.println("--" + MenuOperacoes.CADASTROS.getOperacao() + "--");
                    MenuOperacoes.CADASTROS.imprimirSubmenus();

                    comando = Integer.parseInt(input.nextLine());
                        switch(comando){
                            case 1:
                                System.out.println("--" + SubMenuOpcoes.CADASTRAR_CLIENTE.getOperacao() + "--");
                                System.out.println("Digite o tipo de cliente:\n" + 
                                    "\t[PF] Para pessoa física;\n" + 
                                    "\t[PJ] Para pessoa jurídica;");
                                String tipo_cl = input.nextLine();
                                if (tipo_cl.equals("PF")){
                                    ClientePF cliente = new ClientePF("nome", "endereço", null, null, "educação", "genero", "classeEconomica", "CPF", null, 0, "PF");
                                    cliente.lerClientePF(cliente);
                                    seguradora.cadastrarCliente(cliente);
                                    preco = seguradora.calcularPrecoSeguroCliente(cliente);
                                    cliente.setPreco_do_seguro(preco);
                                } else if(tipo_cl.equals("PJ")) {
                                    ClientePJ cliente = new ClientePJ(null, null, null, null, null, 0, 0, "PJ");
                                    cliente.lerClientePJ(cliente);
                                    seguradora.cadastrarCliente(cliente);
                                    preco = seguradora.calcularPrecoSeguroCliente(cliente);
                                    cliente.setPreco_do_seguro(preco);
                                }
                                System.out.println("Cliente cadastrado com sucesso!");
                                break;
                            case 2: 
                                System.out.println("--" + SubMenuOpcoes.CADASTRAR_SEGURADORA.getOperacao() + "--"); 
                                System.out.println("O método de gerar seguradoras ainda não foi implementado.");
                                //TODO Implementar um meio de cadastrar seguradoras
                                break;
                            case 3:
                                System.out.println("--" + SubMenuOpcoes.CADASTRAR_VEICULO.getOperacao() + "--");
                                System.out.println("Digite o nome do cliente proprietário:");
                                String nome = input.nextLine();
                                
                                Cliente cliente = seguradora.buscaCliente(nome);


                                if (cliente == null)
                                    System.out.println("O cliente não está cadastrado. Tente novamente.");
                                else {
                                    Veículo veiculo = new Veículo(null, null, null, 0);
                                    veiculo.lerVeículo();
                                    cliente.setListaVeiculos(veiculo);
                                    System.out.println("Veículo cadastrado com sucesso!");

                                    seguradora.recalcularPrecoSeguroCliente(cliente);
                                }
                                break;
                            case 4:
                                break;
                        }

                    break;
                case 2:
                    System.out.println("--" + MenuOperacoes.LISTAR.getOperacao() + "--");
                    MenuOperacoes.LISTAR.imprimirSubmenus();

                    comando = Integer.parseInt(input.nextLine());
                        switch(comando){
                            case 1:
                                seguradora.listarClientes();
                                break;
                            case 2: 
                                seguradora.listaSinistros();
                                break;
                            case 3:
                                System.out.println("Digite o nome do cliente proprietário:");
                                String nome = input.nextLine();
                                Cliente cliente = seguradora.buscaCliente(nome);
                                if (cliente == null)
                                    System.out.println("O cliente não está cadastrado. Tente novamente.");
                                else 
                                    cliente.listarVeiculos();
                                break;
                            case 4:
                                break;
                        }

                    break;
                case 3:
                    System.out.println("--" + MenuOperacoes.EXCLUIR.getOperacao() + "--");
                    MenuOperacoes.EXCLUIR.imprimirSubmenus();

                    comando = Integer.parseInt(input.nextLine());
                        switch(comando){
                            case 1:
                            System.out.println("Digite o nome do cliente que deseja remover: ");
                            boolean sucesso = seguradora.removerCliente(input.nextLine());
                                if (sucesso == true) 
                                    System.out.println("Cliente removido com sucesso!");
                                else
                                    System.out.println("Não foi possível fazer a remoção do cliente.");
                                break;
                            case 2:
                                System.out.println("Digite o ID do sinistro que deseja remover.");
                                int ID = Integer.parseInt(input.nextLine());
                                Sinistro sinistro =  seguradora.buscaSinistro(ID);
                                if (sinistro == null)
                                    System.out.println("O ID inserido não corresponde a nenhum sinistro.");
                                else
                                    seguradora.excluirSinistro(sinistro);
                                break;
                            case 3:
                                System.out.println("Digite o nome do cliente proprietário:");
                                String nome = input.nextLine();

                                Cliente cliente = seguradora.buscaCliente(nome);


                                if (cliente == null)
                                    System.out.println("O cliente não está cadastrado. Tente novamente.");
                                else {
                                    System.out.println("Digite a placa do veículo:");
                                    String placa = input.nextLine();
                                    cliente.removerVeiculo(placa);
                                    System.out.println("Veículo removido com sucesso!");
                                }
                                seguradora.recalcularPrecoSeguroCliente(cliente);
                                break;
                            case 4:
                                break;
                        }
                        
                    break;
                case 4:
                    System.out.println("--" + MenuOperacoes.GERAR_SINISTRO.getOperacao() + "--");
                    boolean sucesso = seguradora.gerarSinistro();
                    if (sucesso == true) 
                        System.out.println("Sinistro gerado com sucesso!");
                    else
                        System.out.println("Não foi possível concluir a geração do sinistro.");
                    break;
                case 5:
                    System.out.println("--" + MenuOperacoes.TRANSFERIR_SEGURO.getOperacao() + "--");
                    System.out.println("Insira o nome de quem fornece o seguro:");
                    String nome = input.nextLine();
                    Cliente fornecedor = seguradora.buscaCliente(nome);
                    System.out.println("Insira o nome de quem recebe o seguro:");
                    nome = input.nextLine();
                    Cliente recebedor = seguradora.buscaCliente(nome);
                    seguradora.transferirSeguro(fornecedor, recebedor);

                    seguradora.recalcularPrecoSeguroCliente(fornecedor);
                    seguradora.recalcularPrecoSeguroCliente(recebedor);
                    break;
                case 6:
                    System.out.println("--" + MenuOperacoes.CALCULAR_RECEITA_SEGURADORA.getOperacao() + "--");
                    System.out.println(seguradora.calcularReceita());
                    break;
                case 7:
                    System.out.println("--" + MenuOperacoes.SAIR.getOperacao() + "--");
                    fim = true;
                    break;
            }
        } */
    }               
}
