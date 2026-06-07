package dominio;

public interface EfeitoItem {
    boolean aplicar(Personagem alvo) throws Exception;

    String getDescricao();
}
