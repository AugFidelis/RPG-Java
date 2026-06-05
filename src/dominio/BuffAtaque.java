package dominio;

public class BuffAtaque implements EfeitoItem {
    private int bonusAtaque;

    public BuffAtaque(int bonusAtaque) {
        if (bonusAtaque <= 0) {
            throw new IllegalArgumentException("Bonus de ataque deve ser positivo.");
        }
        this.bonusAtaque = bonusAtaque;
    }

    @Override
    public boolean aplicar(Personagem alvo) throws Exception {
        alvo.setAtaque(alvo.getAtaque() + this.bonusAtaque);
        System.out.println(alvo.getNome() + " sente-se mais forte!");
        return true;
    }

    @Override
    public String getDescricao() {
        return "Aumenta ataque em " + this.bonusAtaque;
    }
}
