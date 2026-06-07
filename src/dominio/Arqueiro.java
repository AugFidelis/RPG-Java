package dominio;

public class Arqueiro extends Personagem{
    public Arqueiro(String nome) throws Exception{
        super(nome, 90, 12, 10, (short) 1);
    }


    public Arqueiro(Arqueiro other) {
               super(other);
    }
}
