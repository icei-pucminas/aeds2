#include <stdlib.h>
#include <stdio.h>
#include <math.h>

/**
 * Árvore AVL   
 * @author Artur Bomtempo Colen
 */

/**
 * Estrutura de um nó da árvore AVL.
 */
typedef struct No {
    int elemento;
    struct No *esq, *dir;
    int nivel;
} No;

No *raiz = NULL;

/**
 * Função para criar um novo nó.
 * 
 * @param elemento Conteúdo do nó.
 * @return Ponteiro para o nó criado.
 */
No* criarNo(int elemento) {
    No *novo = (No *) malloc (sizeof(No));
    novo->elemento = elemento;
    novo->esq = novo->dir = NULL;
    novo->nivel = 1;
    return novo;
}

/**
 * Obtém o nível de um nó.
 * 
 * @param no Ponteiro para o nó.
 * @return Nível do nó ou 0 se for NULL.
 */
int getNivel(No *no) {
    return (no == NULL) ? 0 : no->nivel;
}

/**
 * Atualiza o nível de um nó.
 * 
 * @param no Ponteiro para o nó.
 */
void setNivel(No *no) {
    if (no != NULL) {
        no->nivel = 1 + fmax(getNivel(no->esq), getNivel(no->dir));
    }
}

/**
 * Rotaciona o nó para a direita.
 * 
 * @param no Ponteiro para o nó a ser rotacionado.
 * @return Novo nó após a rotação.
 */
No* rotacionarDir(No *no) {
    No *noEsq = no->esq;
    No *noEsqDir = noEsq->dir;

    noEsq->dir = no;
    no->esq = noEsqDir;

    setNivel(no);
    setNivel(noEsq);

    return noEsq;
}

/**
 * Rotaciona o nó para a esquerda.
 * 
 * @param no Ponteiro para o nó a ser rotacionado.
 * @return Novo nó após a rotação.
 */
No* rotacionarEsq(No* no) {
    No *noDir = no->dir;
    No *noDirEsq = noDir->esq;

    noDir->esq = no;
    no->dir = noDirEsq;

    setNivel(no);
    setNivel(noDir);

    return noDir;
}

/**
 * Balanceia um nó da árvore AVL.
 * 
 * @param no Ponteiro para o nó a ser balanceado.
 * @return Nó balanceado.
 */
No* balancear(No *no) {
    if (no != NULL) {
        int fator = getNivel(no->dir) - getNivel(no->esq);

        if (fator == 2) {
            int fatorFilhoDir =  getNivel(no->dir->dir) - getNivel(no->dir->esq);

            if (fatorFilhoDir == -1) {
                no->dir = rotacionarDir(no->dir);
            }

            no = rotacionarEsq(no);
        } else if (fator == -2) {
            int fatorFilhoEsq =  getNivel(no->esq->dir) - getNivel(no->esq->esq);

            if (fatorFilhoEsq == 1) {
                no->esq = rotacionarEsq(no->esq);
            }

            no = rotacionarDir(no);
        } else {
            setNivel(no);
        }
    }

    return no;
}

/**
 * Insere um elemento na árvore AVL.
 * 
 * @param no Ponteiro para o nó atual.
 * @param elemento Elemento a ser inserido.
 * @return Ponteiro para o nó atualizado.
 */
No* inserir(No *no, int elemento) {
    if (no == NULL) {
        no = criarNo(elemento);
    } else if (elemento < no->elemento) {
        no->esq = inserir(no->esq, elemento);
    } else if (elemento > no->elemento) {
        no->dir = inserir(no->dir, elemento);
    }

    no = balancear(no);

    return no;
}

/**
 * Exibe a árvore em pré-ordem.
 * 
 * @param no Ponteiro para o nó atual.
 */
void caminharPreRec(No *no) {
    if (no != NULL) {
        printf("%d(fator %d) ", no->elemento, getNivel(no->dir) - getNivel(no->esq));
        caminharPreRec(no->esq);
        caminharPreRec(no->dir);
    }
}

/**
 * Exibe a árvore em pré-ordem a partir da raiz.
 */
void caminharPre() {
    printf("[ ");
    caminharPreRec(raiz);
    printf(" ]");
}

/**
 * Inicializa a árvore com NULL.
 */
void start() {
    raiz = NULL;
}

/**
 * Função principal para testar a árvore AVL.
 */
int main() {
    start();

    int array[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int tamanho = sizeof(array) / sizeof(array[0]);

    for (int i = 0; i < tamanho; i++) {
        printf("Inserindo -> %d\n", array[i]);
        raiz = inserir(raiz, array[i]);
        caminharPre();
        printf("\n");
    }

    return 0;
}