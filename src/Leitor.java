import java.io.*;
import java.text.Collator;
import java.util.Arrays;
import java.util.Locale;

public class Leitor {

    public static void processarArquivos(String caminhoTexto, String caminhoChaves, String caminhoSaida) throws IOException {
        TabelaHash tabela = processarTexto(caminhoTexto);
        gerarIndice(tabela, caminhoChaves, caminhoSaida);
        System.out.println("Índice remissivo gerado em: " + caminhoSaida);
    }

    // ------------------------- Funcoes -------------------------

    private static TabelaHash processarTexto(String caminhoTexto) throws IOException {
        TabelaHash tabela = new TabelaHash(26);
        BufferedReader leitor = new BufferedReader(new FileReader(caminhoTexto));

        String linha;
        int numeroLinha = 1;

        while ((linha = leitor.readLine()) != null) {
            String[] palavras = tratarPalavras(linha);
            for (String palavra : palavras) {
                if (!palavra.isEmpty()) {
                    tabela.inserirPalavra(palavra, numeroLinha);
                }
            }
            numeroLinha++;
        }

        leitor.close();
        return tabela;
    }


    private static String[] tratarPalavras(String linha) {
        linha = linha.toLowerCase()
                .replaceAll("[^\\p{L}\\s]", "")
                .replaceAll("s(?=\\s|$)", "");
        return linha.split("\\s+");
    }


    private static void gerarIndice(TabelaHash tabela, String caminhoChaves, String caminhoSaida) throws IOException {
        BufferedReader leitor = new BufferedReader(new FileReader(caminhoChaves));
        String linha = leitor.readLine();
        leitor.close();

        String[] chaves = linha.split(",");
        for (int i = 0; i < chaves.length; i++) {
            chaves[i] = chaves[i].trim().toLowerCase();
        }

        Collator collator = Collator.getInstance(new Locale("pt", "BR"));
        collator.setStrength(Collator.PRIMARY);
        Arrays.sort(chaves, collator);

        BufferedWriter escritor = new BufferedWriter(new FileWriter(caminhoSaida));
        for (String chave : chaves) {
            Palavra resultado = tabela.buscarPalavra(chave);
            if (resultado != null) {
                escritor.write(resultado.getPalavra() + ": " + resultado.getOcorrencias());
                escritor.newLine();
            }
        }
        escritor.close();
    }
}