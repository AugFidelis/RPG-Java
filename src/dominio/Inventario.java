package dominio;

import java.util.ArrayList;
import java.util.Collections;

public class Inventario implements Cloneable {

    private ArrayList<Item> itens;

    public Inventario() {
        this.itens = new ArrayList<>();
    }

    public Inventario(Inventario outro) {
        if (outro == null) {
            throw new IllegalArgumentException("Inventário de cópia não pode ser nulo!");
        }

        this.itens = new ArrayList<>();

        for (int i = 0; i < outro.itens.size(); i++) {
            Item itemOriginal = outro.itens.get(i);
            this.itens.add(itemOriginal.clone());
        }
    }

    public void adicionarItem(Item itemParaAdicionar) {
        if (itemParaAdicionar == null || itemParaAdicionar.getQuantidade() <= 0) {
            return;
        }

        for (int i = 0; i < this.itens.size(); i++) {
            Item itemExistente = this.itens.get(i);

            if (itemExistente.equals(itemParaAdicionar)) {
                int novaQuantidade = itemExistente.getQuantidade() + itemParaAdicionar.getQuantidade();
                itemExistente.setQuantidade(novaQuantidade);
                return;
            }
        }

        this.itens.add(itemParaAdicionar.clone());
    }

    public boolean usarItem(String nomeDoItem, Personagem alvo) throws Exception {
        for (int i = 0; i < this.itens.size(); i++) {
            Item item = this.itens.get(i);

            if (item.getNome().equalsIgnoreCase(nomeDoItem)) {
                boolean foiUsado = item.usar(alvo);

                if (foiUsado) {
                    if (item.getQuantidade() <= 0) {
                        this.itens.remove(i);
                    }
                    return true;
                }

                return false;
            }
        }

        System.out.println("Você não possui este item em seu inventário.");
        return false;
    }

    public ArrayList<Item> getItensOrdenados() {
        Collections.sort(this.itens);
        return this.itens;
    }

    @Override
    public Inventario clone() {
        return new Inventario(this);
    }

    @Override
    public String toString() {
        if (this.itens.isEmpty()) {
            return "O inventário está vazio!";
        }

        Collections.sort(this.itens);

        String ret = "Inventário:\n";

        for (int i = 0; i < this.itens.size(); i++) {
            Item item = this.itens.get(i);
            ret = ret + String.format("- %s (x%d): %s\n",
                    item.getNome(), item.getQuantidade(), item.getDescricao());
        }

        return ret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventario that = (Inventario) o;

        Collections.sort(this.itens);
        Collections.sort(that.itens);

        return this.itens.equals(that.itens);
    }

    @Override
    public int hashCode() {
        Collections.sort(this.itens);
        return this.itens.hashCode();
    }
}
