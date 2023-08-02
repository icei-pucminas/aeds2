/**
 * Arvore binaria de pesquisa
 * @author Max do Val Machado
 */

#include <err.h>
#include "arvorebinaria.h"

/**
 * Construtor da classe.
 */
ArvoreBinaria::ArvoreBinaria() {
    raiz = NULL;
}

/**
 * Metodo publico iterativo para pesquisar elemento.
 * @param x Elemento que sera procurado.
 * @return <code>true</code> se o elemento existir,
 * <code>false</code> em caso contrario.
 */
bool ArvoreBinaria::pesquisar(int x) {
    return pesquisar(x, raiz);
}

/**
 * Metodo privado recursivo para pesquisar elemento.
 * @param x Elemento que sera procurado.
 * @param i No em analise.
 * @return <code>true</code> se o elemento existir,
 * <code>false</code> em caso contrario.
 */
bool ArvoreBinaria::pesquisar(int x, No* i) {
    bool resp;
    if (i == NULL) {
        resp = false;

    } else if (x == i->elemento) {
        resp = true;

    } else if (x < i->elemento) {
        resp = pesquisar(x, i->esq);

    } else {
        resp = pesquisar(x, i->dir);
    }
    return resp;
}

/**
 * Metodo publico iterativo para exibir elementos.
 */
void ArvoreBinaria::caminharCentral() {
    cout << "[ ";
    caminharCentral(raiz);
    cout << "]\n";
}

/**
 * Metodo privado recursivo para exibir elementos.
 * @param i No em analise.
 */
void ArvoreBinaria::caminharCentral(No* i) {
    if (i != NULL) {
        caminharCentral(i->esq); // Elementos da esquerda.
        cout << i->elemento << " "; // Conteudo do no.
        caminharCentral(i->dir); // Elementos da direita.
    }
}

/**
 * Metodo publico iterativo para exibir elementos.
 */
void ArvoreBinaria::caminharPre() {
    cout << "[ ";
    caminharPre(raiz);
    cout << "]\n";
}

/**
 * Metodo privado recursivo para exibir elementos.
 * @param i No em analise.
 */
void ArvoreBinaria::caminharPre(No* i) {
    if (i != NULL) {
        cout << i->elemento << " "; // Conteudo do no.
        caminharPre(i->esq); // Elementos da esquerda.
        caminharPre(i->dir); // Elementos da direita.
    }
}

/**
 * Metodo publico iterativo para exibir elementos.
 */
void ArvoreBinaria::caminharPos() {
    cout << "[ ";
    caminharPos(raiz);
    cout << "]\n";
}

/**
 * Metodo privado recursivo para exibir elementos.
 * @param i No em analise.
 */
void ArvoreBinaria::caminharPos(No* i) {
    if (i != NULL) {
        caminharPos(i->esq); // Elementos da esquerda.
        caminharPos(i->dir); // Elementos da direita.
        cout << i->elemento << " "; // Conteudo do no.
    }
}

/**
 * Metodo publico iterativo para inserir elemento.
 * @param x Elemento a ser inserido.
 */
void ArvoreBinaria::inserir(int x) {
    inserir(x, raiz);
}

/**
 * Metodo privado recursivo para inserir elemento.
 * @param x Elemento a ser inserido.
 * @param i No em analise.
 */
void ArvoreBinaria::inserir(int x, No* &i) {
    if (i == NULL) {
        i = new No(x);

    } else if (x < i->elemento) {
        inserir(x, i->esq);

    } else if (x > i->elemento) {
        inserir(x, i->dir);

    } else {
        errx(1, "Erro ao inserir!");
    }
}

/**
 * Metodo publico iterativo para remover elemento.
 * @param x Elemento a ser removido.
 */
void ArvoreBinaria::remover(int x) {
    remover(x, raiz);
}

/**
 * Metodo privado recursivo para remover elemento.
 * @param x Elemento a ser removido.
 * @param i No em analise.
 */
void ArvoreBinaria::remover(int x, No* &i) {
    if (i == NULL) {
        errx(1, "Erro ao remover!");

    } else if (x < i->elemento) {
        remover(x, i->esq);

    } else if (x > i->elemento) {
        remover(x, i->dir);

        // Sem no a direita.
    } else if (i->dir == NULL) {
        No* del = i;
        i = i->esq;
        delete del;

        // Sem no a esquerda.
    } else if (i->esq == NULL) {
        No* del = i;
        i = i->dir;
        delete del;

        // No a esquerda e no a direita.
    } else {
        maiorEsq(i, i->esq);
    }
}


/**
 * Metodo para trocar no removido pelo maior elemento da esquerda.
 * @param i No que teve o elemento removido.
 * @param j No da subarvore esquerda.
 */
void ArvoreBinaria::maiorEsq(No* i, No* &j) {
    // Encontrou o maximo da subarvore esquerda.
    if (j->dir == NULL) {
        No* del = j;
        i->elemento = j->elemento; // Substitui i por j.
        j = j->esq; // Substitui j por j.ESQ.
        delete del;

        // Existe no a direita.
    } else {
        maiorEsq(i, j->dir); // Caminha para direita.
    }
}
