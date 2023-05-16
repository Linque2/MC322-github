import java.util.*;

public class Main {
    public static void main(String[] args) {
        Seguradora seguradora = new Seguradora(null, null, null, null);
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
                           "5-) Transferir seguro;\n" + //TODO falta implementar
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
                                System.out.println("--" + SubMenuOpcoes.CADASTRAR_SEGURADORA.getOperacao() + "--"); //!Implementar um meio de cadastrar seguradoras
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

                                    //!/!!/!/!!

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
                                //!Implementar uma forma de remover veículos
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
                    //!Encontrar uma forma de transferir seguros
                    break;
                case 6:
                    System.out.println("--" + MenuOperacoes.CALCULAR_RECEITA_SEGURADORA.getOperacao() + "--");
                    System.out.println(seguradora.calcularReceita());
                    break; //!Precisa atualizar os valores dos seguros a medida que se adicionam sinistros
                case 7:
                    System.out.println("--" + MenuOperacoes.SAIR.getOperacao() + "--");
                    fim = true;
                    break;
            }
        }
    }                   
}