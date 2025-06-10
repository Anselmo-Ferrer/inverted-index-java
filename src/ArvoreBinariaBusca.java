public class ArvoreBinariaBusca {

    class Nodo {
        public Palavra palavra;
        public Nodo esquerdo, direito;

        public Nodo(Palavra palavra) {
            this.palavra = palavra;
        }
    }

    public Nodo raiz;

    public Nodo inserir(Nodo nodo, String texto, int linha) {
        if (nodo == null) return new Nodo(new Palavra(texto, linha));
        int comparar = texto.compareTo(nodo.palavra.getPalavra());
        if (comparar < 0) nodo.esquerdo = inserir(nodo.esquerdo, texto, linha);
        else if (comparar > 0) nodo.direito = inserir(nodo.direito, texto, linha);
        else nodo.palavra.adicionarOcorrencia(linha);
        return nodo;
    }

    public Palavra buscar(Nodo nodo, String texto) {
        if (nodo == null) return null;
        int comparar = texto.compareTo(nodo.palavra.getPalavra());
        if (comparar < 0) return buscar(nodo.esquerdo, texto);
        if (comparar > 0) return buscar(nodo.direito, texto);
        return nodo.palavra;
    }
}