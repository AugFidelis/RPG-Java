package dominio;

import java.util.Random;

public class Inimigo extends Personagem {
    public Inimigo(String nome, int pontosVida, int ataque, int defesa, short nivel) throws Exception {
        super(nome, pontosVida, ataque, defesa, nivel);
    }

    public Inimigo(Inimigo other) {
        super(other);
    }

    public static Inimigo gerarInimigo(String localizacao) throws Exception {
        Random dado = new Random();
        int chance = dado.nextInt(100);

        if (localizacao.equals("Predio H") || localizacao.equals("Biblioteca")) {
            if (chance < 60) {
                return new Inimigo("Soldado Invasor", 70, 15, 8, (short) 3);
            }
            return new Inimigo("Drone Sentinela", 90, 8, 15, (short) 3);
        }

        if (chance < 70) {
            return new Inimigo("Drone de Patrulha", 40, 10, 5, (short) 1);
        }

        return new Inimigo("Soldado Invasor", 70, 15, 8, (short) 3);
    }
}
