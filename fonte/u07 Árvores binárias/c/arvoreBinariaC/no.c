/**
 * No da arvore binaria
 * @author Max do Val Machado
 */
#include <stdlib.h>
#include "no.h"

/**
 * Criacao do novo no
 * @param elemento Conteudo do no.
 */
No* novoNo(int elemento) {
   No* novo = (No*) malloc(sizeof(No));
   novo->elemento = elemento;
   novo->esq = NULL;
   novo->dir = NULL;
   return novo;
}
