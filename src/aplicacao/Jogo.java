package aplicacao;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import dominio.Arqueiro;
import dominio.CuraHP;
import dominio.Guerreiro;
import dominio.Inimigo;
import dominio.Item;
import dominio.Mago;
import dominio.Personagem;
import dominio.SemEfeito;
import ui.Teclado;

public class Jogo {

    private Personagem jogador;
    private Random dado;
    private String localizacaoAtual;
    private ServicoCombate servicoCombate;
    private ServicoInventario servicoInventario;
    private Map<Integer, ComandoMenu> comandosMenu;

    public Jogo() throws Exception {
        this.dado = new Random();
        this.servicoInventario = new ServicoInventario();
        this.servicoCombate = new ServicoCombate(this.dado, this.servicoInventario);
        this.jogador = criarPersonagem();
        this.localizacaoAtual = "Sala de Aula - Bloco C";
        this.comandosMenu = criarComandosMenu();
    }

    public void iniciarJogo() throws Exception {
        System.out.println("Durante uma tarde comum de aulas, uma nave alienigena cai...");
        System.out.println("Voce se ve preso em uma " + this.localizacaoAtual + ".");

        while (this.jogador.getPontosVida() > 0) {
            exibirMenuPrincipal();
        }

        System.out.println("GAME OVER... Voce foi derrotado.");
    }

    private Map<Integer, ComandoMenu> criarComandosMenu() {
        Map<Integer, ComandoMenu> comandos = new LinkedHashMap<>();
        comandos.put(1, new ComandoExplorar(this));
        comandos.put(2, new ComandoMover(this));
        comandos.put(3, new ComandoInventario(this));
        return comandos;
    }

    private void exibirMenuPrincipal() throws Exception {
        System.out.println("\n----------------------------------------");
        System.out.println("Voce esta em: " + this.localizacaoAtual);
        System.out.println("HP: " + this.jogador.getPontosVida());
        System.out.println("O que voce deseja fazer?");

        for (Map.Entry<Integer, ComandoMenu> entrada : this.comandosMenu.entrySet()) {
            System.out.println(entrada.getKey() + ". " + entrada.getValue().getDescricao());
        }

        System.out.print("Escolha: ");

        int escolha = lerOpcaoMenu();
        ComandoMenu comando = this.comandosMenu.get(escolha);

        if (comando == null) {
            System.out.println("Opcao invalida.");
            return;
        }

        comando.executar();
    }

    private int lerOpcaoMenu() {
        try {
            return Teclado.getUmInt();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return 0;
        }
    }

    private Personagem criarPersonagem() throws Exception {
        System.out.println("Os invasores estao por toda parte! Quem e voce?");
        System.out.println("1. O Atleta (Curso: Educacao Fisica) - Foco em HP e Defesa.");
        System.out.println("2. O Programador (Curso: Eng. de Software) - Foco em Ataque.");
        System.out.println("3. O Arquiteto (Curso: Arquitetura) - Atributos mais balanceados.");
        System.out.print("Escolha sua classe: ");

        int classe = Teclado.getUmInt();

        System.out.print("Digite o nome do seu personagem: ");
        String nome = Teclado.getUmString();

        Personagem p;

        switch (classe) {
            case 1:
                System.out.println("Voce e 'O Atleta'! Foco em resistir ao combate.");
                p = new Guerreiro(nome);
                break;

            case 2:
                System.out.println("Voce e 'O Programador'! Usando logica para atacar.");
                p = new Mago(nome);
                break;

            case 3:
                System.out.println("Voce e 'O Arquiteto'! Precisao e sua arma.");
                p = new Arqueiro(nome);
                break;

            default:
                System.out.println("Opcao invalida. Escolhendo 'O Atleta' por padrao.");
                p = new Guerreiro(nome);
                break;
        }

        Item salgado = new Item("Salgado", "Cura 20 HP", new CuraHP(20), 2);
        p.getInventario().adicionarItem(salgado);
        System.out.println(nome + " se junta a luta! Voce tem 2 Salgados no inventario.");

        return p;
    }

    public void navegar() {
        System.out.println("De " + this.localizacaoAtual + ", voce pode ir para:");

        try {
            switch (this.localizacaoAtual) {
                case "Sala de Aula - Bloco C":
                    System.out.println("1. Patio Central");
                    System.out.println("2. Cantina");
                    int escolhaC = Teclado.getUmInt();
                    if (escolhaC == 1) {
                        this.localizacaoAtual = "Patio Central";
                    } else if (escolhaC == 2) {
                        this.localizacaoAtual = "Cantina";
                    }
                    break;
                case "Patio Central":
                    System.out.println("1. Bloco C");
                    System.out.println("2. Biblioteca");
                    System.out.println("3. Predio H (Laboratorios)");
                    int escolhaP = Teclado.getUmInt();
                    if (escolhaP == 1) {
                        this.localizacaoAtual = "Sala de Aula - Bloco C";
                    } else if (escolhaP == 2) {
                        this.localizacaoAtual = "Biblioteca";
                    } else if (escolhaP == 3) {
                        this.localizacaoAtual = "Predio H";
                    }
                    break;
                case "Cantina":
                    System.out.println("1. Voltar para o Bloco C");
                    if (Teclado.getUmInt() == 1) {
                        this.localizacaoAtual = "Sala de Aula - Bloco C";
                    }
                    break;
                case "Biblioteca":
                    System.out.println("1. Voltar para o Patio Central");
                    if (Teclado.getUmInt() == 1) {
                        this.localizacaoAtual = "Patio Central";
                    }
                    break;
                case "Predio H":
                    System.out.println("1. Voltar para o Patio Central");
                    if (Teclado.getUmInt() == 1) {
                        this.localizacaoAtual = "Patio Central";
                    }
                    break;
                default:
                    System.out.println("Nao ha rotas cadastradas para este local.");
                    break;
            }
        } catch (Exception e) {
            System.err.println("Opcao de navegacao invalida.");
        }
    }

    public void explorar() throws Exception {
        System.out.println("Voce explora " + this.localizacaoAtual + "...");
        int chance = dado.nextInt(100);

        if (this.localizacaoAtual.equals("Cantina") && chance < 50) {
            System.out.println("Voce achou um 'Salgado' largado!");
            this.jogador.getInventario().adicionarItem(new Item("Salgado", "Cura 20 HP", new CuraHP(20), 1));
        } else if (this.localizacaoAtual.equals("Predio H") && chance < 40) {
            System.out.println("Voce achou 'Componentes Eletronicos'!");
            this.jogador.getInventario().adicionarItem(new Item("Componentes", "Para gadgets", new SemEfeito(), 2));
        } else if (this.localizacaoAtual.equals("Patio Central") && chance < 70) {
            System.out.println("Uma patrulha te avista!");
            Inimigo inimigo = Inimigo.gerarInimigo(this.localizacaoAtual);
            this.servicoCombate.iniciarBatalha(this.jogador, inimigo);
        } else if (chance < 30) {
            System.out.println("Um alarme soa! Um inimigo aparece!");
            Inimigo inimigo = Inimigo.gerarInimigo(this.localizacaoAtual);
            this.servicoCombate.iniciarBatalha(this.jogador, inimigo);
        } else {
            System.out.println("Nada de interessante por aqui.");
        }
    }

    public void abrirInventario() throws Exception {
        this.servicoInventario.abrirInventario(this.jogador);
    }
}
