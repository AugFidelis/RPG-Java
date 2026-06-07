package aplicacao;

import dominio.Personagem;
import ui.EntradaUsuario;

public class ServicoInventario {
    private EntradaUsuario entradaUsuario;

    public ServicoInventario(EntradaUsuario entradaUsuario) {
        this.entradaUsuario = entradaUsuario;
    }

    public boolean abrirInventario(Personagem jogador) throws Exception {
        System.out.println(jogador.getInventario().toString());
        System.out.print("Digite o nome do item que deseja usar (ou 'voltar'): ");

        String nomeItem = this.entradaUsuario.lerTexto();
        if (nomeItem == null || nomeItem.equalsIgnoreCase("voltar")) {
            return false;
        }

        boolean sucesso = jogador.getInventario().usarItem(nomeItem, jogador);

        if (sucesso) {
            System.out.println(jogador.getNome() + " usou " + nomeItem + ".");
        } else {
            System.out.println("Nao foi possivel usar " + nomeItem + ".");
        }

        return sucesso;
    }
}

