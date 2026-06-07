package dominio;

public class FabricaPersonagem {

    public static Personagem criarPersonagem(
            int classe,
            String nome) throws Exception {

        switch (classe) {

            case 1:
                System.out.println("Você é 'O Atleta'! Foco em resistir ao combate.");
                return new Guerreiro(nome);

            case 2:
                System.out.println("Você é 'O Programador'! Usando lógica para atacar.");
                return new Mago(nome);

            case 3:
                System.out.println("Você é 'O Arquiteto'! Precisão é sua arma.");
                return new Arqueiro(nome);

            default:
                System.out.println("Opção inválida. Escolhendo 'O Atleta' por padrão.");
                return new Guerreiro(nome);
        }
    }
}