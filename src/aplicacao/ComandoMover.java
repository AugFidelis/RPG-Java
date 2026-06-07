package aplicacao;

public class ComandoMover implements ComandoMenu {
    private Jogo jogo;

    public ComandoMover(Jogo jogo) {
        this.jogo = jogo;
    }

    @Override
    public void executar() {
        this.jogo.navegar();
    }

    @Override
    public String getDescricao() {
        return "Mover-se para outro local";
    }
}
