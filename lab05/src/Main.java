import java.util.*;

public class Main {
    public static void main(String[] args) {

        /* Instanciação de um objeto de cada classe */
        Seguradora seguradora = new Seguradora("88.287.107/0001-03", "segI", "11999990000", "Rua A", "seg1@email.com");
        Seguradora.getListaSeguradoras().add(seguradora);
        ClientePF cliente0 = new ClientePF("172.242.425-78", "clienteI", "(73) 98084-6147", "Rua B", "cliente1@email.com", "masculino", "Ensino médio completo", LerEntrada.lerData("10/07/2000"));
        ClientePJ cliente1 = new ClientePJ("64.284.773/0001-20", "clienteII", "(98) 96721-2761", "Rua C", "cliente2@email.com", LerEntrada.lerData("12/11/2016"), 10);
        seguradora.cadastrarCliente(cliente0);
        seguradora.cadastrarCliente(cliente1);

        Veículo veiculo0 = new Veículo("NWG-7154", "marca0", "modelo0", 1998);
        cliente0.cadastrarVeiculo(veiculo0);

        Frota frota0 = new Frota("00001");
        Veículo veiculo1 = new Veículo("EGB-5674", "marca1", "modelo1", 2014);
        cliente1.cadastrarFrota(frota0);
        frota0.addVeiculo(veiculo1);
        frota0.addVeiculo(veiculo0);

        SeguroPF seguro0 = new SeguroPF(LerEntrada.lerData("10/05/2019"), LerEntrada.lerData("12/11/2022"), seguradora, 0, veiculo0, cliente0);
        seguro0.calcularValor();
        seguradora.getListaSeguros().add(seguro0);

        SeguroPJ seguro1 = new SeguroPJ(LerEntrada.lerData("10/05/2019"), LerEntrada.lerData("12/11/2022"), seguradora, 0, frota0, cliente1);
        seguro1.calcularValor();
        seguradora.getListaSeguros().add(seguro1);

        Condutor condutor = new Condutor("435.445.382-70", "CondI", "(53) 3822-8025", "Rua B", "condutor1@email.com", null, true);
        Sinistro sinistro0 = new Sinistro(LerEntrada.lerData("10/05/2019"), "Rua A", condutor, seguro1);
        seguro1.gerarSinistro(sinistro0);

        /* Implementação do menu de operações */
        Scanner input = new Scanner(System.in);
        String nome, placa;
        Cliente cliente;
        Seguro seguro;
        Sinistro sinistro;
        Veículo veiculo;
        int ID;
        boolean fim = false;

        while (fim == false) {

            System.out.println("Insira o comando que deseja: \n" +
                           "1-) Cadastros;\n" + 
                           "2-) Listar;\n" + 
                           "3-) Excluir;\n" +
                           "4-) Gerer sinistro;\n" +
                           "5-) Gerar seguro;\n" +
                           "6-) Atualizar frota;\n" +
                           "7-) Calcular receita seguradora;\n" +
                           "8-) Trocar de seguradora;\n" +
                           "9-) Sair;");
            int comando = Integer.parseInt(input.nextLine());
            switch(comando){
                case 1: //Cadastros
                    System.out.println("--" + MenuOperacoes.CADASTROS.getOperacao() + "--");
                    MenuOperacoes.CADASTROS.imprimirSubmenus();

                    comando = Integer.parseInt(input.nextLine());
                        switch(comando){
                            case 1: //Cadastrar cliente
                                System.out.println("--" + SubMenuOpcoes.CADASTRAR_CLIENTE.getOperacao() + "--");
                                seguradora.cadastrarCliente();
                                break;
                            case 2: //Cadastrar seguradora
                                System.out.println("--" + SubMenuOpcoes.CADASTRAR_SEGURADORA.getOperacao() + "--"); 
                                Seguradora.lerSeguradora();
                                break;
                            case 3: //Cadastrar veículo
                                System.out.println("--" + SubMenuOpcoes.CADASTRAR_VEICULO.getOperacao() + "--");
                                System.out.print("Digite o nome do Cliente proprietário: ");
                                nome = input.nextLine();
                                cliente = seguradora.buscaCliente(nome);
                                cliente.cadastrarVeiculo();
                                seguradora.atulizarValoDosSeguros(cliente);                            
                                break;
                            case 4: //Cadastrar frota
                                System.out.println("--" + SubMenuOpcoes.CADASTRAR_FROTA.getOperacao() + "--");
                                System.out.print("Digite o nome do Cliente proprietário: ");
                                nome = input.nextLine();
                                cliente = seguradora.buscaCliente(nome); 
                                if (cliente instanceof ClientePF || cliente == null){
                                    System.out.print("Só é possível associar uma frota a um cliente PJ");
                                    break;  
                                }
                                cliente.cadastrarFrota(LerEntrada.lerFrota());
                                break;
                            case 5: //Autorizar condutor
                                System.out.print("Digite o ID do seguro ao qual deseja vincular o condutor: ");
                                ID = Integer.parseInt(input.nextLine());
                                seguro = seguradora.buscaSeguro(ID);
                                if (seguro == null) {
                                    System.out.println("O seguro inserido não existe");
                                    break;
                                }
                                seguro.autorizarCondutor();
                                seguro.calcularValor();
                                break;
                            case 6: //Voltar
                                break;
                        }

                    break;
                case 2: //Listagens
                    System.out.println("--" + MenuOperacoes.LISTAR.getOperacao() + "--");
                    MenuOperacoes.LISTAR.imprimirSubmenus();
                    comando = Integer.parseInt(input.nextLine());
                        switch(comando){
                            case 1: //Listar Clientes
                                seguradora.listarClientes();
                                break;
                            case 2: //Listar sinistros por cliente
                                seguradora.imprimirSinistrosPorCliente();
                                break;
                            case 3: //Listar seguros por cliente
                                seguradora.imprimirSegurosPorCliente();
                                break;
                            case 4: //Listar veículos do cliente (no caso do clente PJ imprime todos os veículos de todas as frotas)
                                System.out.print("Digite o nome do cliente proprietário: ");
                                nome = input.nextLine();
                                cliente = seguradora.buscaCliente(nome);
                                cliente.listarVeiculos();
                                break;   
                            case 5: //Listar seguradoras
                                Seguradora.imprimirSeguradoras();
                                break;
                            case 6: //Voltar
                                break; 
                        }

                    break;
                case 3: //Exclusões
                    System.out.println("--" + MenuOperacoes.EXCLUIR.getOperacao() + "--");
                    MenuOperacoes.EXCLUIR.imprimirSubmenus();

                    comando = Integer.parseInt(input.nextLine());
                        switch(comando){
                            case 1: //Excluir cliente
                            System.out.println("Digite o nome do cliente que deseja remover: ");
                            boolean sucesso = seguradora.removerCliente(input.nextLine());
                                if (sucesso == true) 
                                    System.out.println("Cliente removido com sucesso!");
                                else
                                    System.out.println("Não foi possível fazer a remoção do cliente.");
                                break;
                            case 2: //Excluir sinistro
                                System.out.print("Digite o ID do seguro do sinistro que deseja remover: ");
                                ID = Integer.parseInt(input.nextLine());
                                seguro = seguradora.buscaSeguro(ID);
                                if (seguro == null) {
                                    System.out.println("O seguro inserido não existe");
                                    break;
                                }
                                System.out.print("Agora insira o ID do sinistro: ");
                                sinistro = seguro.buscaSinistro(ID);
                                seguro.removerSinistro(sinistro);
                                seguro.calcularValor();
                                break;
                            case 3: //Cancelar seguro
                                System.out.print("Digite o ID do seguro cancelar: ");
                                ID = Integer.parseInt(input.nextLine());
                                seguradora.cancelarSeguro(ID);
                                break;
                            case 4: //Excluir veículo
                                System.out.print("Digite o nome do Cliente proprietário: ");
                                nome = input.nextLine();
                                cliente = seguradora.buscaCliente(nome);
                                System.out.print("Digite a placa do veículo que deseja remover: ");
                                placa = input.nextLine();
                                veiculo = cliente.buscarVeiculo(placa);
                                cliente.removerVeiculo(veiculo);
                                seguradora.cancelarSeguro((ClientePF)cliente, veiculo);
                                seguradora.atulizarValoDosSeguros(cliente);
                                break;
                            case 5: //Desautorizar condutor
                                System.out.print("Digite o ID do seguro associado ao condutor que deseja desautorizar: ");
                                ID = Integer.parseInt(input.nextLine());
                                seguro = seguradora.buscaSeguro(ID);
                                if (seguro == null) {
                                    System.out.println("O seguro inserido não existe");
                                    break;
                                }
                                seguro.desautorizarCondutor();
                                seguro.calcularValor();
                                break;
                            case 6: //Voltar
                                break;
                        }
                        
                    break;
                case 4: //Gerar sinistro
                    System.out.print("Digite o ID do seguro em que será registrado o seguro: ");
                    ID = Integer.parseInt(input.nextLine());
                    seguro = seguradora.buscaSeguro(ID);
                    if (seguro == null) {
                        System.out.println("O seguro inserido não existe");
                        break;
                    }
                    seguro.gerarSinistro();
                    seguro.calcularValor();
                    break;
                case 5: //Gerar seguro
                    seguradora.gerarSeguro();
                    System.out.println("Seguro gerado com sucesso!");
                    break;   
                case 6: //Atualizar frota
                    System.out.println("--" + MenuOperacoes.ATUALIZAR_FROTA.getOperacao() + "--");
                    System.out.print("Digite o nome do Cliente proprietário da frota: ");
                    Frota frota;
                    String code;
                    nome = input.nextLine();
                    cliente = seguradora.buscaCliente(nome); 
                    if (cliente instanceof ClientePF){
                        System.out.print("Só é possível associar uma frota a um cliente PJ");
                        break;  
                    }
                    cliente.listarFrotas();
                    System.out.print("Digite o código da frota que deseja modificar: ");
                    code = input.nextLine();
                    frota = cliente.buscarFrota(code);
                    cliente.atualizarFrota(frota);
                    seguradora.atulizarValoDosSeguros(cliente);
                    break;
                case 7: //Calcular receita seguradora
                    System.out.println("--" + MenuOperacoes.CALCULAR_RECEITA_SEGURADORA.getOperacao() + "--");
                    System.out.println(seguradora.calcularReceita());
                    break;
                case 8: //Trocar de seguradora
                    System.out.println("--" + MenuOperacoes.TROCAR_SEGURADORA.getOperacao() + "--");
                    int Indice;
                    System.out.println("Para qual seguradora você deseja trocar?");
                    Seguradora.imprimirSeguradoras();
                    System.out.println("Índice: ");
                    Indice = Integer.parseInt(input.nextLine());
                    seguradora = Seguradora.getListaSeguradoras().get(Indice);
                    break;
                case 9: //Sair
                    System.out.println("--" + MenuOperacoes.SAIR.getOperacao() + "--");
                    fim = true;
                    break;
            }
        }
    }               
}
