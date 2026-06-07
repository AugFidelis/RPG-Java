package dominio;

public class SemEfeito implements EfeitoItem {
    @Override
    public boolean aplicar(Personagem alvo) {
        System.out.println("Este item não pode ser usado diretamente.");
        return false;
    }

    @Override
    public String getDescricao() {
        return "Sem efeito direto";
    }
}
