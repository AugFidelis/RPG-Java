package aplicacao;

import dominio.Personagem;
import ui.Teclado;

public class ServicoInventario {
    public boolean abrirInventario(Personagem jogador) throws Exception {
        System.out.println(jogador.getInventario().toString());
        System.out.print("Digite o nome do item que deseja usar (ou 'voltar'): ");

        String nomeItem = Teclado.getUmString();
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
