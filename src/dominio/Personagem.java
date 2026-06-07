package dominio;

import java.util.Random;

public abstract class Personagem {
    private String nome;
    private int pontosVida, ataque, defesa, vidaMaxima;
    private short nivel;
    private Inventario inventario;

    public Personagem(String nome, int pontosVida, int ataque, int defesa, short nivel) throws Exception {
        this.setNome(nome);
        this.setPontosVida(pontosVida);
        this.setAtaque(ataque);
        this.setDefesa(defesa);
        this.setNivel(nivel);
        this.inventario = new Inventario();
        this.vidaMaxima = pontosVida;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setPontosVida(int pontosVida) throws Exception {
        this.pontosVida = pontosVida;
    }

    public int getPontosVida() {
        return this.pontosVida;
    }

    public void setAtaque(int ataque) throws Exception {
        if (ataque < 0) {
            throw new Exception("Valor de ataque inválido!");
        }
        this.ataque = ataque;
    }

    public int getAtaque() {
        return this.ataque;
    }

    public void setDefesa(int defesa) throws Exception {
        if (defesa < 0) {
            throw new Exception("Valor de defesa inválido!");
        }
        this.defesa = defesa;
    }

    public int getDefesa() {
        return this.defesa;
    }

    public void setNivel(short nivel) throws Exception {
        if (nivel < 0) {
            throw new Exception("Valor de nível inválido!");
        }
        this.nivel = nivel;
    }

    public int getNivel() {
        return this.nivel;
    }

    public Inventario getInventario() {
        return this.inventario;
    }

    public int getVidaMaxima() {
        return this.vidaMaxima;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s \nHP: %d \nAtaque: %d \nDefesa: %d \nNível: %d",
                this.nome, this.pontosVida, this.ataque, this.defesa, this.nivel);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Personagem outro = (Personagem) o;

        return this.pontosVida == outro.pontosVida &&
                this.ataque == outro.ataque &&
                this.defesa == outro.defesa &&
                this.nivel == outro.nivel &&
                this.nome.equals(outro.nome);
    }

    @Override
    public int hashCode() {
        int ret = 1;

        ret = 31 * ret + ((this.nome == null) ? 0 : this.nome.hashCode());
        ret = 31 * ret + this.pontosVida;
        ret = 31 * ret + this.ataque;
        ret = 31 * ret + this.defesa;
        ret = 31 * ret + this.nivel;

        return ret;
    }

    protected Personagem(Personagem other) {
        if (other == null) {
            throw new IllegalArgumentException("other não pode ser null");
        }
        this.nome = other.nome;
        this.pontosVida = other.pontosVida;
        this.ataque = other.ataque;
        this.defesa = other.defesa;
        this.nivel = other.nivel;
        this.vidaMaxima = other.vidaMaxima;
        this.inventario = other.inventario.clone();
    }

    public void batalhar(Inimigo inimigo) throws Exception {
        Random random = new Random();

        int dadoJogador = random.nextInt(6) + 1;
        int ataqueTotalJogador = this.getAtaque() + dadoJogador;

        if (ataqueTotalJogador > inimigo.getDefesa()) {
            int danoInimigo = ataqueTotalJogador - inimigo.getDefesa();
            if (danoInimigo <= 0) danoInimigo = 1;

            inimigo.setPontosVida(inimigo.getPontosVida() - danoInimigo);
            System.out.println("Você acertou o inimigo e deu dano de:" + danoInimigo);
            System.out.println("Vida do Inimigo: " + inimigo.getPontosVida());
        } else {
            System.out.println("Você errou o ataque.");
        }

        if (inimigo.getPontosVida() > 0) {
            int dadoInimigo = random.nextInt(6) + 1;
            int ataqueTotalInimigo = inimigo.getAtaque() + dadoInimigo;

            if (ataqueTotalInimigo > this.getDefesa()) {
                int danoJogador = ataqueTotalInimigo - this.getDefesa();
                if (danoJogador <= 0) danoJogador = 1;

                this.setPontosVida(this.getPontosVida() - danoJogador);
                System.out.println("O inimigo te acertou e te deu dano de:" + danoJogador);
                System.out.println("Sua Vida: " + this.getPontosVida());
            } else {
                System.out.println("O inimigo errou o ataque.");
            }
        }
    }
}
