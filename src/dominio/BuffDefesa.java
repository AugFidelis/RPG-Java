package dominio;

public class BuffDefesa implements EfeitoItem {
    private int bonusDefesa;

    public BuffDefesa(int bonusDefesa) {
        if (bonusDefesa <= 0) {
            throw new IllegalArgumentException("Bonus de defesa deve ser positivo.");
        }
        this.bonusDefesa = bonusDefesa;
    }

    @Override
    public boolean aplicar(Personagem alvo) throws Exception {
        alvo.setDefesa(alvo.getDefesa() + this.bonusDefesa);
        System.out.println(alvo.getNome() + " sente-se mais resistente!");
        return true;
    }

    @Override
    public String getDescricao() {
        return "Aumenta defesa em " + this.bonusDefesa;
    }
}
