package aplicacao;

import java.util.Random;

import dominio.Inimigo;
import dominio.Personagem;
import ui.Teclado;

public class ServicoCombate {
    private Random dado;
    private ServicoInventario servicoInventario;

    public ServicoCombate(Random dado, ServicoInventario servicoInventario) {
        this.dado = dado;
        this.servicoInventario = servicoInventario;
    }

    public void iniciarBatalha(Personagem jogador, Inimigo inimigo) throws Exception {
        System.out.println("!!! BATALHA INICIADA: " + inimigo.getNome() + " apareceu! !!!");

        boolean jogadorFugiu = false;

        while (jogador.getPontosVida() > 0 && inimigo.getPontosVida() > 0) {
            exibirEstadoCombate(jogador, inimigo);

            int escolha = lerEscolhaCombate();

            switch (escolha) {
                case 1:
                    jogador.batalhar(inimigo);
                    break;
                case 2:
                    this.servicoInventario.abrirInventario(jogador);
                    break;
                case 3:
                    jogadorFugiu = tentarFugir(jogador, inimigo);
                    break;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
                    break;
            }

            if (jogadorFugiu) {
                break;
            }
        }

        exibirResultadoCombate(jogador, inimigo, jogadorFugiu);
    }

    private void exibirEstadoCombate(Personagem jogador, Inimigo inimigo) {
        System.out.println("\n[TURNO DE COMBATE]");
        System.out.printf("Sua Vida (HP): %d\n", jogador.getPontosVida());
        System.out.printf("Vida Inimigo (HP): %d\n", inimigo.getPontosVida());

        System.out.println("O que voce deseja fazer?");
        System.out.println("1. Atacar");
        System.out.println("2. Usar Item (Inventario)");
        System.out.println("3. Tentar Fugir");
        System.out.print("Escolha: ");
    }

    private int lerEscolhaCombate() {
        try {
            return Teclado.getUmInt();
        } catch (Exception e) {
            System.err.println("Opcao invalida.");
            return 0;
        }
    }

    private boolean tentarFugir(Personagem jogador, Inimigo inimigo) throws Exception {
        System.out.println("Voce tenta fugir...");
        int chanceFuga = this.dado.nextInt(10) + 1;

        if (chanceFuga > 5) {
            System.out.println("Voce conseguiu fugir da batalha!");
            return true;
        }

        System.out.println("A fuga falhou! O inimigo ataca!");
        inimigoAtaca(jogador, inimigo);
        return false;
    }

    private void inimigoAtaca(Personagem jogador, Inimigo inimigo) throws Exception {
        int dadoInimigo = this.dado.nextInt(6) + 1;
        int ataqueTotalInimigo = inimigo.getAtaque() + dadoInimigo;

        if (ataqueTotalInimigo > jogador.getDefesa()) {
            int danoJogador = ataqueTotalInimigo - jogador.getDefesa();
            if (danoJogador <= 0) {
                danoJogador = 1;
            }
            jogador.setPontosVida(jogador.getPontosVida() - danoJogador);
            System.out.println("O inimigo te acertou e causou " + danoJogador + " de dano!");
        } else {
            System.out.println("O inimigo ataca, mas voce se defende!");
        }
    }

    private void exibirResultadoCombate(Personagem jogador, Inimigo inimigo, boolean jogadorFugiu) {
        if (jogadorFugiu) {
            System.out.println("Voce fugiu com sucesso!");
        } else if (jogador.getPontosVida() > 0) {
            System.out.println("Voce derrotou o " + inimigo.getNome() + "!");
        } else {
            System.out.println("Voce foi abatido...");
        }
    }
}
