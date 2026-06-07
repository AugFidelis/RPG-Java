package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Teclado implements EntradaUsuario {
    private final BufferedReader leitor;

    public Teclado() {
        this.leitor = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String lerTexto() throws Exception {
        try {
            return this.leitor.readLine();
        } catch (IOException erro) {
            throw new Exception("Erro ao ler texto do teclado.", erro);
        }
    }

    @Override
    public int lerInteiro() throws Exception {
        String texto = lerTexto();

        try {
            return Integer.parseInt(texto);
        } catch (NumberFormatException erro) {
            throw new Exception("Digite um numero inteiro valido.", erro);
        }
    }
}
