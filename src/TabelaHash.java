public class TabelaHash {
    private ArvoreBinariaBusca[] tabela;

    public TabelaHash(int capacidade) {
        this.tabela = new ArvoreBinariaBusca[capacidade];
        for (int i = 0; i < capacidade; i++) {
            tabela[i] = new ArvoreBinariaBusca();
        }
    }

    private int funcaoHash(String palavra) {
        char primeiraLetra = removerAcentoEMinuscula(palavra.charAt(0));
        if (primeiraLetra < 'a' || primeiraLetra > 'z') return -1;
        return primeiraLetra - 'a';
    }

    private char removerAcentoEMinuscula(char c) {
        String original = "áàâãäéèêëíìîïóòôõöúùûüç";
        String semAcento = "aaaaaeeeeiiiiooooouuuuc";
        c = Character.toLowerCase(c);

        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == c) return semAcento.charAt(i);
        }
        return c;
    }

    public void inserirPalavra(String palavra, int linha) {
        int indice = funcaoHash(palavra);
        if (indice == -1) return;

        tabela[indice].raiz = tabela[indice].inserir(tabela[indice].raiz, palavra, linha);
    }

    public Palavra buscarPalavra(String palavra) {
        int indice = funcaoHash(palavra);
        return tabela[indice].buscar(tabela[indice].raiz, palavra);
    }
}
