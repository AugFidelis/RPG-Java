package dominio;

public class Mago extends Personagem{
    public Mago(String nome) throws Exception{
        super(nome, 70, 16, 8, (short) 1);

        Item salgado = new Item("Salgado", "Cura 20 HP", new CuraHP(20), 1);
        this.getInventario().adicionarItem(salgado);
    }

    
    public Mago(Mago other) { super(other); }

}
