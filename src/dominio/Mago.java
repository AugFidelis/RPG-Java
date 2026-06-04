package dominio;

public class Mago extends Personagem{
    public Mago(String nome) throws Exception{
        super(nome, 70, 16, 8, (short) 1);

        Item salgado = new Item("Salgado", "Cura 20 HP", "CURA_HP", 1);
        this.getInventario().adicionarItem(salgado);
    }

    //Ainda falta definir o nome final e suas características próprias|
    public Mago(Mago other) { super(other); }

}
