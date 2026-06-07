package dominio;

import java.util.Random;

public class Inimigo extends Personagem {
    public Inimigo(String nome, int pontosVida, int ataque, int defesa, short nivel) throws Exception {
        super(nome, pontosVida, ataque, defesa, nivel);
    }

    public Inimigo(Inimigo other) {
        super(other);
    }

}
