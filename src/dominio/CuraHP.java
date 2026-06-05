package dominio;

public class CuraHP implements EfeitoItem {
    private int quantidadeCura;

    public CuraHP(int quantidadeCura) {
        if (quantidadeCura <= 0) {
            throw new IllegalArgumentException("Quantidade de cura deve ser positiva.");
        }
        this.quantidadeCura = quantidadeCura;
    }

    @Override
    public boolean aplicar(Personagem alvo) throws Exception {
        int vidaAtual = alvo.getPontosVida();
        int vidaMaxima = alvo.getVidaMaxima();

        if (vidaAtual >= vidaMaxima) {
            System.out.println(alvo.getNome() + " ja esta com a vida cheia!");
            return false;
        }

        int novaVida = vidaAtual + this.quantidadeCura;
        if (novaVida > vidaMaxima) {
            novaVida = vidaMaxima;
        }

        alvo.setPontosVida(novaVida);
        System.out.println(alvo.getNome() + " recuperou HP! Vida atual: " + novaVida + "/" + vidaMaxima);
        return true;
    }

    @Override
    public String getDescricao() {
        return "Cura " + this.quantidadeCura + " HP";
    }
}
