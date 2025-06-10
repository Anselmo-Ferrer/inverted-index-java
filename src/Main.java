import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Leitor leitor = new Leitor();

        String texto = "texto.txt";
        String palavrasChave = "chaves.txt";
        String saida = "indice.txt";

        leitor.processarArquivos(texto, palavrasChave, saida);
    }
}
