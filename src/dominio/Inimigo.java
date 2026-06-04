package dominio;

import java.util.Random;

public class Inimigo extends Personagem{
    public Inimigo(String nome, int pontosVida, int ataque, int defesa, short nivel) throws Exception{
        super(nome, pontosVida, ataque, defesa, nivel);
    }

    public Inimigo(Inimigo other) {
        super(other);
    }

    public static Inimigo gerarInimigo(String localizacao) throws Exception {

        Random dado = new Random();
        int chance = dado.nextInt(100);

        //Exemplo de como seria a implementação de inimigos específicos de cada lugar
        if (localizacao.equals("Prédio H") || localizacao.equals("Biblioteca")) {
            // Locais mais difíceis
            if (chance < 60) {
                return new Inimigo("Soldado Invasor", 70, 15, 8, (short) 3);
            } else {
                return new Inimigo("Drone Sentinela", 90, 8, 15, (short) 3); // Foco em defesa
            }
        }

        // APENAS UM EXEMPLO!!! FALTA DEFINIR OS INIMIGOS/LOCAIS/HISTÓRIA FINAL!!!
        // Lógica padrão para locais mais fáceis
        if (chance < 70) {
            return new Inimigo("Drone de Patrulha", 40, 10, 5, (short) 1);
        } else {
            return new Inimigo("Soldado Invasor", 70, 15, 8, (short) 3);
        }
    }
}