public class Palavra {
    private String palavra;
    private ListaEncadeada ocorrencias;

    public Palavra(String palavra, int linha) {
        this.palavra = palavra;
        this.ocorrencias = new ListaEncadeada();
        this.ocorrencias.insereFinal(linha);
    }

    public String getPalavra() {
        return palavra;
    }

    public ListaEncadeada getOcorrencias() {
        return ocorrencias;
    }

    public void adicionarOcorrencia(int linha) {
        this.ocorrencias.insereFinal(linha);
    }

    @Override
    public String toString() {
        return palavra + ": " + ocorrencias.toString();
    }
}