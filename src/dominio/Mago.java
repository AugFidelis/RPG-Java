package dominio;

public class Mago extends Personagem{
    public Mago(String nome) throws Exception{
        super(nome, 70, 16, 8, (short) 1);
    }

    
    public Mago(Mago other) { super(other); }

}
