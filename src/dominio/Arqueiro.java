package dominio;

public class Arqueiro extends Personagem{
    public Arqueiro(String nome) throws Exception{
        super(nome, 90, 12, 10, (short) 1);
    }

    //Ainda falta definir o nome final e suas características próprias\

    public Arqueiro(Arqueiro other) {
               super(other);
    }
}
