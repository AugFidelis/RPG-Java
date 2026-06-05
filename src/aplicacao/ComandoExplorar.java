package aplicacao;

public class ComandoExplorar implements ComandoMenu {
    private Jogo jogo;

    public ComandoExplorar(Jogo jogo) {
        this.jogo = jogo;
    }

    @Override
    public void executar() throws Exception {
        this.jogo.explorar();
    }

    @Override
    public String getDescricao() {
        return "Explorar o local";
    }
}
