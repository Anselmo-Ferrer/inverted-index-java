class ListaEncadeada {
    private Nodo primeiro;
    private Nodo ultimo;
    private int n_elementos;

    private static class Nodo {
        public int valor;
        public Nodo proximo;

        public Nodo(int valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }

    public ListaEncadeada() {
        this.primeiro = null;
        this.ultimo = null;
        this.n_elementos = 0;
    }

    public void insereFinal(int valor) {
        Nodo novoNodo = new Nodo(valor);
        if (primeiro == null) {
            primeiro = novoNodo;
            ultimo = novoNodo;
        } else {
            if (ultimo.valor == valor) return;
            ultimo.proximo = novoNodo;
            ultimo = novoNodo;
        }
        n_elementos++;
    }

    public String toString() {
        StringBuilder string = new StringBuilder();
        Nodo atual = primeiro;
        while (atual != null) {
            string.append(atual.valor);
            if (atual.proximo != null) string.append(", ");
            atual = atual.proximo;
        }
        return string.toString();
    }
}
