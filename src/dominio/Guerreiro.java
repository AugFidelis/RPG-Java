package dominio;

public class Guerreiro extends Personagem{
    public Guerreiro(String nome) throws Exception{
        super(nome, 120, 8, 15, (short) 1);
    }

    
    public Guerreiro(Guerreiro other) {
        super(other);
    }
}
