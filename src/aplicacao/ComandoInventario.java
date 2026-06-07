package aplicacao;

public class ComandoInventario implements ComandoMenu {
    private Jogo jogo;

    public ComandoInventario(Jogo jogo) {
        this.jogo = jogo;
    }

    @Override
    public void executar() throws Exception {
        this.jogo.abrirInventario();
    }

    @Override
    public String getDescricao() {
        return "Ver Inventário / Usar Item";
    }
}
