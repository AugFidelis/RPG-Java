package ui;

import aplicacao.Jogo;

public class Main {
    public static void main(String[] args) {
        try{
            Jogo novoJogo = new Jogo();

            novoJogo.iniciarJogo();
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
}