/**
 * No da arvore binaria
 * @author Max do Val Machado
 */

#include "no.h"

/**
 * Construtor da classe.
 * @param elemento Conteudo do no.
 */
No::No(int elemento) {
   this->elemento = elemento;
   this->esq = NULL;
   this->dir = NULL;
}
