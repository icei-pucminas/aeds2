
/**
 * No da arvore binaria
 * @author Max do Val Machado
 */

class No {
    public int elemento; // Conteudo do no.
    public No esq, dir;  // Filhos da esq e dir.

    /**
     * Construtor da classe.
     * @param elemento Conteudo do no.
     */
    public No(int elemento) {
        this(elemento, null, null);
    }

    /**
     * Construtor da classe.
     * @param elemento Conteudo do no.
     * @param esq No da esquerda.
     * @param dir No da direita.
     */
    public No(int elemento, No esq, No dir) {
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
    }
}

