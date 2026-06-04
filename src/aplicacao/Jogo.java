package aplicacao;

import java.util.Random;

import dominio.Personagem;
import dominio.Guerreiro;
import dominio.Mago;
import dominio.Arqueiro;
import dominio.Inimigo;
import dominio.Item;
import ui.Teclado;

public class Jogo {

    private Personagem jogador;
    private Random dado;
    private String localizacaoAtual;

    public Jogo() throws Exception {
        this.dado = new Random();
        this.jogador = criarPersonagem();
        this.localizacaoAtual = "Sala de Aula - Bloco C";
    }

    public void iniciarJogo() throws Exception {
        System.out.println("Durante uma tarde comum de aulas, uma nave alienígena cai...");
        System.out.println("Você se vê preso em uma " + this.localizacaoAtual + ".");

        while (this.jogador.getPontosVida() > 0) {
            exibirMenuPrincipal();
        }

        System.out.println("GAME OVER... Você foi derrotado.");
    }

    private void exibirMenuPrincipal() throws Exception {
        System.out.println("\n----------------------------------------");
        System.out.println("Você está em: " + this.localizacaoAtual);
        System.out.println("HP: " + this.jogador.getPontosVida());
        System.out.println("O que você deseja fazer?");
        System.out.println("1. Explorar o local");
        System.out.println("2. Mover-se para outro local");
        System.out.println("3. Ver Inventário / Usar Item");
        System.out.print("Escolha: ");

        int escolha;
        try {
            escolha = Teclado.getUmInt();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            escolha = 0; // Opção inválida
        }

        switch (escolha) {
            case 1:
                explorar();
                break;
            case 2:
                navegar();
                break;
            case 3:
                abrirInventario();
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private Personagem criarPersonagem() throws Exception {
        System.out.println("Os invasores estão por toda parte! Quem é você?");
        System.out.println("1. O Atleta (Curso: Educação Física) - Foco em HP e Defesa.");
        System.out.println("2. O Programador (Curso: Eng. de Software) - Foco em Ataque.");
        System.out.println("3. O Arquiteto (Curso: Arquitetura) - Atributos mais balanceados.");
        System.out.print("Escolha sua classe: ");

        int classe = Teclado.getUmInt();

        System.out.print("Digite o nome do seu personagem: ");
        String nome = Teclado.getUmString();

        Personagem p;

        switch (classe) {
            case 1:
                System.out.println("Você é 'O Atleta'! Foco em resistir ao combate.");
                p = new Guerreiro(nome);
                break;

            case 2:
                System.out.println("Você é 'O Programador'! Usando lógica para atacar.");
                p = new Mago(nome);
                break;

            case 3:
                System.out.println("Você é 'O Arquiteto'! Precisão é sua arma.");
                p = new Arqueiro(nome);
                break;

            default:
                System.out.println("Opção inválida. Escolhendo 'O Atleta' por padrão.");
                p = new Guerreiro(nome);
                break;
        }

        //Isso é só de exemplo, esse trecho de dar o salgado deveria ser removido e
        //Um item(s) específico(s) deveria ser dado automaticamente DENTRO da subclasse
        //de cada classe, ao invés de dentro da classe Jogo
        Item salgado = new Item("Salgado", "Cura 20 HP", "CURA_HP", 2);
        p.getInventario().adicionarItem(salgado);
        System.out.println(nome + " se junta à luta! Você tem 2 Salgados no inventário.");


        return p;
    }

    private void navegar() {
        System.out.println("De " + this.localizacaoAtual + ", você pode ir para:");

        try {
            switch (this.localizacaoAtual) {
                case "Sala de Aula - Bloco C":
                    System.out.println("1. Pátio Central");
                    System.out.println("2. Cantina");
                    int escolhaC = Teclado.getUmInt();
                    if (escolhaC == 1) this.localizacaoAtual = "Pátio Central";
                    else if (escolhaC == 2) this.localizacaoAtual = "Cantina";
                    break;
                case "Pátio Central":
                    System.out.println("1. Bloco C");
                    System.out.println("2. Biblioteca");
                    System.out.println("3. Prédio H (Laboratórios)");
                    int escolhaP = Teclado.getUmInt();
                    if (escolhaP == 1) this.localizacaoAtual = "Sala de Aula - Bloco C";
                    else if (escolhaP == 2) this.localizacaoAtual = "Biblioteca";
                    else if (escolhaP == 3) this.localizacaoAtual = "Prédio H";
                    break;
                case "Cantina":
                    System.out.println("1. Voltar para o Bloco C");
                    if (Teclado.getUmInt() == 1) this.localizacaoAtual = "Sala de Aula - Bloco C";
                    break;
                case "Biblioteca":
                    System.out.println("1. Voltar para o Pátio Central");
                    if (Teclado.getUmInt() == 1) this.localizacaoAtual = "Pátio Central";
                    break;
                case "Prédio H":
                    System.out.println("1. Voltar para o Pátio Central");
                    if (Teclado.getUmInt() == 1) this.localizacaoAtual = "Pátio Central";
                    break;
            }
        } catch (Exception e) {
            System.err.println("Opção de navegação inválida.");
        }

    }

    private void explorar() throws Exception {
        System.out.println("Você explora " + this.localizacaoAtual + "...");
        int chance = dado.nextInt(100);

        if (this.localizacaoAtual.equals("Cantina") && chance < 50) {
            System.out.println("Você achou um 'Salgado' largado!");
            this.jogador.getInventario().adicionarItem(new Item("Salgado", "Cura 20 HP", "CURA_HP", 1));
        } else if (this.localizacaoAtual.equals("Prédio H") && chance < 40) {
            System.out.println("Você achou 'Componentes Eletrônicos'!");
            this.jogador.getInventario().adicionarItem(new Item("Componentes", "Para gadgets", "ITEM", 2));

        } else if (this.localizacaoAtual.equals("Pátio Central") && chance < 70) {
            System.out.println("Uma patrulha te avista!");

            Inimigo inimigo = Inimigo.gerarInimigo(this.localizacaoAtual);
            iniciarBatalha(inimigo);

        } else if (chance < 30) {
            System.out.println("Um alarme soa! Um inimigo aparece!");
            Inimigo inimigo = Inimigo.gerarInimigo(this.localizacaoAtual);
            iniciarBatalha(inimigo);
        } else {
            System.out.println("Nada de interessante por aqui.");
        }
    }

    private void abrirInventario() throws Exception {
        System.out.println(this.jogador.getInventario().toString());
        System.out.print("Digite o nome do item que deseja usar (ou 'voltar'): ");

        String nomeItem = Teclado.getUmString();

        if (nomeItem.equalsIgnoreCase("voltar")) {
            return;
        }
        
        boolean sucesso = this.jogador.getInventario().usarItem(nomeItem, this.jogador);

        if (sucesso) {
            System.out.println(this.jogador.getNome() + " usou " + nomeItem + ".");
        } else {
            System.out.println("Não foi possível usar " + nomeItem + ".");
        }
    }

    private void iniciarBatalha(Inimigo inimigo) throws Exception {
        System.out.println("!!! BATALHA INICIADA: " + inimigo.getNome() + " apareceu! !!!");

        boolean jogadorFugiu = false;

        while (this.jogador.getPontosVida() > 0 && inimigo.getPontosVida() > 0) {
            System.out.println("\n[TURNO DE COMBATE]");
            System.out.printf("Sua Vida (HP): %d\n", this.jogador.getPontosVida());
            System.out.printf("Vida Inimigo (HP): %d\n", inimigo.getPontosVida());

            System.out.println("O que você deseja fazer?");
            System.out.println("1. Atacar");
            System.out.println("2. Usar Item (Inventário)");
            System.out.println("3. Tentar Fugir");
            System.out.print("Escolha: ");

            int escolha = 0;
            try {
                escolha = Teclado.getUmInt();
            } catch (Exception e) {
                System.err.println("Opção inválida.");
                continue;
            }

            switch (escolha) {
                case 1:
                    this.jogador.batalhar(inimigo);
                    break;
                case 2:
                    abrirInventario();
                    break;
                case 3:
                    System.out.println("Você tenta fugir...");
                    int chanceFuga = dado.nextInt(10) + 1;
                    if (chanceFuga > 5) {
                        System.out.println("Você conseguiu fugir da batalha!");
                        jogadorFugiu = true;
                    } else {
                        System.out.println("A fuga falhou! O inimigo ataca!");
                        int dadoInimigo = dado.nextInt(6) + 1;
                        int ataqueTotalInimigo = inimigo.getAtaque() + dadoInimigo;
                        if (ataqueTotalInimigo > this.jogador.getDefesa()) {
                            int danoJogador = ataqueTotalInimigo - this.jogador.getDefesa();
                            if (danoJogador <= 0) danoJogador = 1;
                            this.jogador.setPontosVida(this.jogador.getPontosVida() - danoJogador);
                            System.out.println("O inimigo te acertou e causou " + danoJogador + " de dano!");
                        } else {
                            System.out.println("O inimigo ataca, mas você se defende!");
                        }
                    }
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

            if (jogadorFugiu) {
                break;
            }
        }

        if (jogadorFugiu) {
            System.out.println("Você fugiu com sucesso!");
        }
        else if (this.jogador.getPontosVida() > 0) {
            System.out.println("Você derrotou o " + inimigo.getNome() + "!");

            //Seria bom fazer alguma mecânica aqui com Random, do inimigo droppar algum item aleatório

        } else {
            System.out.println("Você foi abatido...");
        }
    }
}