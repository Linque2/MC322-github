public enum SubMenuOpcoes {
    CADASTRAR_CLIENTE("Cadastrar cliente"),
	CADASTRAR_VEICULO("Cadastrar veiculo"),
	CADASTRAR_SEGURADORA("Cadastrar seguradora"),
	CADASTRAR_FROTA("Cadastrar frota"),
	AUTORIZAR_CONDUTOR("Autorizar condutor"),
	LISTAR_CLIENTES("Listar cliente"),
	LISTAR_SINISTROS_POR_CLIENTE("Listar sinistros por cliente"),
	LISTAR_SEGUROS_POR_CLIENTE("Listar seguros por cliente"),
	LISTAR_VEICULOS("Listar veiculo"),
	LISTAR_SEGURADORAS("Listar seguradoras"),
	EXCLUIR_CLIENTE("Excluir cliente"),
	EXCLUIR_VEICULO("Excluir veiculo"),
	EXCLUIR_SINISTRO("Excluir sininstro"),
	CANCELAR_SEGURO("Cancelar seguro"),
	DESAUTORIZAR_CONDUTOR("Desautorizar condutor"),
	VOLTAR("Voltar");

    private final String operacao;

    SubMenuOpcoes(String operacao) {
        this.operacao = operacao;
    }
    public String getOperacao() {
        return this.operacao;
    }
}