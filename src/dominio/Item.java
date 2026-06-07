package dominio;

import java.util.Objects;

public class Item implements Comparable<Item>, Cloneable {
    private String nome;
    private String descricao;
    private EfeitoItem efeito;
    private int quantidade;

    public Item() {
        this.nome = "";
        this.descricao = "";
        this.efeito = new SemEfeito();
        this.quantidade = 0;
    }

    public Item(String nome, String descricao, EfeitoItem efeito, int quantidade) {
        setNome(nome);
        setDescricao(descricao);
        setEfeito(efeito);
        setQuantidade(quantidade);
    }

    public Item(Item other) {
        if (other == null) {
            throw new IllegalArgumentException("Item de copia nao pode ser nulo.");
        }
        this.nome = other.nome;
        this.descricao = other.descricao;
        this.efeito = other.efeito;
        this.quantidade = other.quantidade;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public EfeitoItem getEfeito() {
        return efeito;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do item nao pode ser vazio.");
        }
        this.nome = nome.trim();
    }

    public void setDescricao(String descricao) {
        this.descricao = (descricao == null) ? "" : descricao.trim();
    }

    public void setEfeito(EfeitoItem efeito) {
        this.efeito = (efeito == null) ? new SemEfeito() : efeito;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("Quantidade nao pode ser negativa.");
        }
        this.quantidade = quantidade;
    }

    public boolean usar(Personagem alvo) throws Exception {
        if (this.quantidade <= 0) {
            return false;
        }

        boolean aplicado = this.efeito.aplicar(alvo);
        if (!aplicado) {
            return false;
        }

        this.quantidade--;
        return true;
    }

    @Override
    public int compareTo(Item o) {
        if (o == null) {
            return 1;
        }
        return this.nome.compareToIgnoreCase(o.nome);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Item)) {
            return false;
        }
        Item item = (Item) o;
        return nome.equalsIgnoreCase(item.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome.toLowerCase());
    }

    @Override
    public Item clone() {
        return new Item(this);
    }

    @Override
    public String toString() {
        return "Item{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", efeito='" + efeito.getDescricao() + '\'' +
                ", quantidade=" + quantidade +
                '}';
    }
}
