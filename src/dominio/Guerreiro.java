package dominio;

public class Guerreiro extends Personagem{
    public Guerreiro(String nome) throws Exception{
        super(nome, 120, 8, 15, (short) 1);
    }

    //Ainda falta definir o nome final e suas características próprias

    public Guerreiro(Guerreiro other) {
        super(other);
    }
}
