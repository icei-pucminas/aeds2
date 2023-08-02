/**
 * Arvore binaria de pesquisa
 * @author Max do Val Machado
 */
#include <err.h>
#include <stdlib.h>
#include <stdio.h>
#include "arvorebinaria.h"

/*
 * Variavel global
 */
No* raiz;

/**
 * Criar arvore binaria.
 */
void start() {
   raiz = NULL;
}

/**
 * Metodo publico iterativo para pesquisar elemento.
 * @param x Elemento que sera procurado.
 * @return <code>true</code> se o elemento existir,
 * <code>false</code> em caso contrario.
 */
bool pesquisar(int x) {
   return pesquisarRec(x, raiz);
}

/**
 * Metodo privado recursivo para pesquisar elemento.
 * @param x Elemento que sera procurado.
 * @param i No em analise.
 * @return <code>true</code> se o elemento existir,
 * <code>false</code> em caso contrario.
 */
bool pesquisarRec(int x, No* i) {
   bool resp;
   if (i == NULL) {
      resp = false;

   } else if (x == i->elemento) {
      resp = true;

   } else if (x < i->elemento) {
      resp = pesquisarRec(x, i->esq);

   } else {
      resp = pesquisarRec(x, i->dir);
   }
   return resp;
}

/**
 * Metodo publico iterativo para exibir elementos.
 */
void caminharCentral() {
   printf("[ ");
   caminharCentralRec(raiz);
   printf("]\n");
}

/**
 * Metodo privado recursivo para exibir elementos.
 * @param i No em analise.
 */
void caminharCentralRec(No* i) {
   if (i != NULL) {
      caminharCentralRec(i->esq);
      printf("%d ", i->elemento);
      caminharCentralRec(i->dir);
   }
}

/**
 * Metodo publico iterativo para exibir elementos.
 */
void caminharPre() {
   printf("[ ");
   caminharPreRec(raiz);
   printf("]\n");
}

/**
 * Metodo privado recursivo para exibir elementos.
 * @param i No em analise.
 */
void caminharPreRec(No* i) {
   if (i != NULL) {
      printf("%d ", i->elemento);
      caminharPreRec(i->esq);
      caminharPreRec(i->dir);
   }
}

/**
 * Metodo publico iterativo para exibir elementos.
 */
void caminharPos() {
   printf("[ ");
   caminharPosRec(raiz);
   printf("]\n");
}

/**
 * Metodo privado recursivo para exibir elementos.
 * @param i No em analise.
 */
void caminharPosRec(No* i) {
   if (i != NULL) {
      caminharPosRec(i->esq);
      caminharPosRec(i->dir);
      printf("%d ", i->elemento);
   }
}

/**
 * Metodo publico iterativo para inserir elemento.
 * @param x Elemento a ser inserido.
 */
void inserir(int x) {
   inserirRec(x, &raiz);
}

/**
 * Metodo privado recursivo para inserir elemento.
 * @param x Elemento a ser inserido.
 * @param i No** endereco do ponteiro No
 */
void inserirRec(int x, No** i) {
   if (*i == NULL) {
      *i = novoNo(x);

   } else if (x < (*i)->elemento) {
      inserirRec(x, &((*i)->esq));

   } else if (x > (*i)->elemento) {
      inserirRec(x, &((*i)->dir));

   } else {
      errx(1, "Erro ao inserir!");
   }
}

/**
 * Metodo publico iterativo para remover elemento.
 * @param x Elemento a ser removido.
 */
void remover(int x) {
   removerRec(x, &raiz);
}

/**
 * Metodo privado recursivo para remover elemento.
 * @param x Elemento a ser removido.
 * @param i No** endereco do ponteiro No
 */
void removerRec(int x, No** i) {
   if (*i == NULL) {
      errx(1, "Erro ao remover!");

   } else if (x < (*i)->elemento) {
      removerRec(x, &((*i)->esq));

   } else if (x > (*i)->elemento) {
      removerRec(x, &((*i)->dir));

   } else if ((*i)->dir == NULL) {
      No* del = *i;
      *i = (*i)->esq;
      free(del);

   } else if ((*i)->esq == NULL) {
      No* del = *i;
      *i = (*i)->dir;
      free(del);

   } else {
      maiorEsq(i, &((*i)->esq));
   }
}

/**
 * Metodo para trocar no removido pelo maiorEsq.
 * @param i No** endereco do ponteiro No que contem o elemento removido.
 * @param j No** endereco do ponteiro No da subarvore esquerda.
 */
void maiorEsq(No** i, No** j) {
   if ((*j)->dir != NULL) {
      maiorEsq(i, &((*j)->dir));

   } else {
      No* del = *j;
      (*i)->elemento = (*j)->elemento;
      (*j) = (*j)->esq;
      free(del);
   }
}



