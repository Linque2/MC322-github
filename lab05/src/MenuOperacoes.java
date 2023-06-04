public enum MenuOperacoes {
    CADASTROS("Cadastros", new SubMenuOpcoes[]{
                                        SubMenuOpcoes.CADASTRAR_CLIENTE,
                                        SubMenuOpcoes.CADASTRAR_SEGURADORA,
                                        SubMenuOpcoes.CADASTRAR_VEICULO,
                                        SubMenuOpcoes.VOLTAR
    }),
    LISTAR("Listar", new SubMenuOpcoes[]{
                                  SubMenuOpcoes.LISTAR_CLIENTES,
                                  SubMenuOpcoes.LISTAR_SINISTROS,
                                  SubMenuOpcoes.LISTAR_VEICULOS,
                                  SubMenuOpcoes.VOLTAR
    }), 
    EXCLUIR("Excluir", new SubMenuOpcoes[]{
                                    SubMenuOpcoes.EXCLUIR_CLIENTE,
                                    SubMenuOpcoes.EXCLUIR_SINISTRO,
                                    SubMenuOpcoes.EXCLUIR_VEICULO,
                                    SubMenuOpcoes.VOLTAR
    }), 
    GERAR_SINISTRO("Gerar sinistro", new SubMenuOpcoes[]{
                                                  SubMenuOpcoes.VOLTAR
    }), 
    TRANSFERIR_SEGURO("Transferir seguro", new SubMenuOpcoes[]{
                                                        SubMenuOpcoes.VOLTAR
    }), 
    CALCULAR_RECEITA_SEGURADORA("Calcular receita seguradora", new SubMenuOpcoes[]{
                                                                            SubMenuOpcoes.VOLTAR
    }), 
    SAIR("Sair", new SubMenuOpcoes[]{
    });

    public final String operacao;
    public final SubMenuOpcoes[] submenu;

    MenuOperacoes(String operacao, SubMenuOpcoes[] submenu) {
        this.operacao = operacao;
        this.submenu = submenu;
    }
    public String getOperacao() {
        return this.operacao;
    }
    public SubMenuOpcoes[] getSubmenu() {
        return this.submenu;
    }
    public void imprimirSubmenus() {
        int i = 0;
        for (SubMenuOpcoes opcao : submenu){
            i++;
            System.out.println(i + "-)" + opcao.getOperacao() + ";");
        }
    }
}

//TODO implementar outros enum's para os submenus.
