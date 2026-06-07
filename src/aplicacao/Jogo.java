package aplicacao;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import dominio.CuraHP;
import dominio.FabricaInimigo;
import dominio.FabricaPersonagem;
import dominio.Inimigo;
import dominio.Item;
import dominio.Personagem;
import dominio.SemEfeito;
import ui.EntradaUsuario;
import ui.Teclado;

public class Jogo {

    private Personagem jogador;
    private Random dado;
    private String localizacaoAtual;
    private ServicoCombate servicoCombate;
    private ServicoInventario servicoInventario;
    private EntradaUsuario entradaUsuario;
    private Map<Integer, ComandoMenu> comandosMenu;

    public Jogo() throws Exception {
        this(new Teclado());
    }

    public Jogo(EntradaUsuario entradaUsuario) throws Exception {
        this.dado = new Random();
        this.entradaUsuario = entradaUsuario;
        this.servicoInventario = new ServicoInventario(entradaUsuario);
        this.servicoCombate = new ServicoCombate(this.dado, this.servicoInventario, entradaUsuario);
        this.jogador = criarPersonagem();
        this.localizacaoAtual = "Sala de Aula - Bloco C";
        this.comandosMenu = criarComandosMenu();
    }

    public void iniciarJogo() throws Exception {
        System.out.println("Durante uma tarde comum de aulas, uma nave alienígena cai...");
        System.out.println("Você se vê preso em uma " + nomeLocalExibicao(this.localizacaoAtual) + ".");

        while (this.jogador.getPontosVida() > 0) {
            exibirMenuPrincipal();
        }

        System.out.println("GAME OVER... Você foi derrotado.");
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
        System.out.println("Você está em: " + nomeLocalExibicao(this.localizacaoAtual));
        System.out.println("HP: " + this.jogador.getPontosVida());
        System.out.println("O que você deseja fazer?");

        for (Map.Entry<Integer, ComandoMenu> entrada : this.comandosMenu.entrySet()) {
            System.out.println(entrada.getKey() + ". " + entrada.getValue().getDescricao());
        }

        System.out.print("Escolha: ");

        int escolha = lerOpcaoMenu();
        ComandoMenu comando = this.comandosMenu.get(escolha);

        if (comando == null) {
            System.out.println("Opção inválida.");
            return;
        }

        comando.executar();
    }

    private int lerOpcaoMenu() {
        try {
            return this.entradaUsuario.lerInteiro();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return 0;
        }
    }

    private Personagem criarPersonagem() throws Exception {
        System.out.println("Os invasores estão por toda parte! Quem é você?");
        System.out.println("1. O Atleta (Curso: Educação Física) - Foco em HP e Defesa.");
        System.out.println("2. O Programador (Curso: Eng. de Software) - Foco em Ataque.");
        System.out.println("3. O Arquiteto (Curso: Arquitetura) - Atributos mais balanceados.");
        System.out.print("Escolha sua classe: ");

        int classe = this.entradaUsuario.lerInteiro();

        System.out.print("Digite o nome do seu personagem: ");
        String nome = this.entradaUsuario.lerTexto();

        Personagem p = FabricaPersonagem.criarPersonagem(classe, nome);

        Item salgado = new Item("Salgado", "Cura 20 HP", new CuraHP(20), 2);
        p.getInventario().adicionarItem(salgado);
        System.out.println(nome + " se junta à luta! Você tem 2 Salgados no inventário.");

        return p;
    }

    public void navegar() {
        System.out.println("De " + nomeLocalExibicao(this.localizacaoAtual) + ", você pode ir para:");

        try {
            switch (this.localizacaoAtual) {
                case "Sala de Aula - Bloco C":
                    System.out.println("1. Pátio Central");
                    System.out.println("2. Cantina");
                    int escolhaC = this.entradaUsuario.lerInteiro();
                    if (escolhaC == 1) {
                        this.localizacaoAtual = "Patio Central";
                    } else if (escolhaC == 2) {
                        this.localizacaoAtual = "Cantina";
                    }
                    break;
                case "Patio Central":
                    System.out.println("1. Bloco C");
                    System.out.println("2. Biblioteca");
                    System.out.println("3. Prédio H (Laboratórios)");
                    int escolhaP = this.entradaUsuario.lerInteiro();
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
                    if (this.entradaUsuario.lerInteiro() == 1) {
                        this.localizacaoAtual = "Sala de Aula - Bloco C";
                    }
                    break;
                case "Biblioteca":
                    System.out.println("1. Voltar para o Pátio Central");
                    if (this.entradaUsuario.lerInteiro() == 1) {
                        this.localizacaoAtual = "Patio Central";
                    }
                    break;
                case "Predio H":
                    System.out.println("1. Voltar para o Pátio Central");
                    if (this.entradaUsuario.lerInteiro() == 1) {
                        this.localizacaoAtual = "Patio Central";
                    }
                    break;
                default:
                    System.out.println("Não há rotas cadastradas para este local.");
                    break;
            }
        } catch (Exception e) {
            System.err.println("Opção de navegação inválida.");
        }
    }

    public void explorar() throws Exception {
        System.out.println("Você explora " + nomeLocalExibicao(this.localizacaoAtual) + "...");
        int chance = dado.nextInt(100);

        if (this.localizacaoAtual.equals("Cantina") && chance < 50) {
            System.out.println("Você achou um 'Salgado' largado!");
            this.jogador.getInventario().adicionarItem(new Item("Salgado", "Cura 20 HP", new CuraHP(20), 1));
        } else if (this.localizacaoAtual.equals("Predio H") && chance < 40) {
            System.out.println("Você achou 'Componentes Eletrônicos'!");
            this.jogador.getInventario().adicionarItem(new Item("Componentes", "Para gadgets", new SemEfeito(), 2));
        } else if (this.localizacaoAtual.equals("Patio Central") && chance < 70) {
            System.out.println("Uma patrulha te avista!");

            Inimigo inimigo = FabricaInimigo.criarInimigo(this.localizacaoAtual);
            this.servicoCombate.iniciarBatalha(this.jogador, inimigo);

        } else if (chance < 30) {
            System.out.println("Um alarme soa! Um inimigo aparece!");
            Inimigo inimigo = FabricaInimigo.criarInimigo(this.localizacaoAtual);
            this.servicoCombate.iniciarBatalha(this.jogador, inimigo);
        } else {
            System.out.println("Nada de interessante por aqui.");
        }
    }

    public void abrirInventario() throws Exception {
        this.servicoInventario.abrirInventario(this.jogador);
    }

    private String nomeLocalExibicao(String localizacao) {
        if (localizacao.equals("Patio Central")) {
            return "Pátio Central";
        }
        if (localizacao.equals("Predio H")) {
            return "Prédio H";
        }
        return localizacao;
    }
}
