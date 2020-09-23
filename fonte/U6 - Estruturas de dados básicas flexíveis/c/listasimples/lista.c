/**
 * Lista simples dinamica
 * @author Max do Val Machado
 * @version 2 01/2015
 */
#include <stdio.h>
#include <stdlib.h>
#include <err.h>
#define bool   short
#define true   1
#define false  0

//TIPO CELULA ===================================================================
typedef struct Celula {
	int elemento;        // Elemento inserido na celula.
	struct Celula* prox; // Aponta a celula prox.
} Celula;

Celula* novaCelula(int elemento) {
   Celula* nova = (Celula*) malloc(sizeof(Celula));
   nova->elemento = elemento;
   nova->prox = NULL;
   return nova;
}

//LISTA PROPRIAMENTE DITA =======================================================
Celula* primeiro;
Celula* ultimo;


/**
 * Cria uma lista sem elementos (somente no cabeca).
 */
void start () {
   primeiro = novaCelula(-1);
   ultimo = primeiro;
}


/**
 * Insere um elemento na primeira posicao da lista.
 * @param x int elemento a ser inserido.
 */
void inserirInicio(int x) {
   Celula* tmp = novaCelula(x);
   tmp->prox = primeiro->prox;
   primeiro->prox = tmp;
   if (primeiro == ultimo) {                    
      ultimo = tmp;
   }
   tmp = NULL;
}

/**
 * Insere um elemento na ultima posicao da lista.
 * @param x int elemento a ser inserido.
 */
void inserirFim(int x) {
   ultimo->prox = novaCelula(x);
   ultimo = ultimo->prox;
}


/**
 * Remove um elemento da primeira posicao da lista.
 * @return resp int elemento a ser removido.
 * @throws Exception Se a lista nao contiver elementos.
 */
int removerInicio() {
   if (primeiro == ultimo) {
      errx(1, "Erro ao remover!");
   }

   Celula* tmp = primeiro;
   primeiro = primeiro->prox;
   int resp = primeiro->elemento;
   tmp->prox = NULL;
   free(tmp);
   tmp = NULL;
   return resp;
}


/**
 * Remove um elemento da ultima posicao da lista.
 * @return resp int elemento a ser removido.
 */
int removerFim() {
   if (primeiro == ultimo) {
      errx(1, "Erro ao remover!");
   } 

   // Caminhar ate a penultima celula:
   Celula* i;
   for(i = primeiro; i->prox != ultimo; i = i->prox);

   int resp = ultimo->elemento;
   ultimo = i;
   free(ultimo->prox);
   i = ultimo->prox = NULL;

   return resp;
}


/**
 * Calcula e retorna o tamanho, em numero de elementos, da lista.
 * @return resp int tamanho
 */
int tamanho() {
   int tamanho = 0;
   Celula* i;
   for(i = primeiro; i != ultimo; i = i->prox, tamanho++);
   return tamanho;
}


/**
 * Insere um elemento em uma posicao especifica considerando que o 
 * primeiro elemento valido esta na posicao 0.
 * @param x int elemento a ser inserido.
 * @param pos int posicao da insercao.
 * @throws Exception Se <code>posicao</code> invalida.
 */
void inserir(int x, int pos) {

   int tam = tamanho();

   if(pos < 0 || pos > tam){
      errx(1, "Erro ao inserir posicao (%d/ tamanho = %d) invalida!", pos, tam);
   } else if (pos == 0){
      inserirInicio(x);
   } else if (pos == tam){
      inserirFim(x);
   } else {
      // Caminhar ate a posicao anterior a insercao
      int j;
      Celula* i = primeiro;
      for(j = 0; j < pos; j++, i = i->prox);

      Celula* tmp = novaCelula(x);
      tmp->prox = i->prox;
      i->prox = tmp;
      tmp = i = NULL;
   }
}


/**
 * Remove um elemento de uma posicao especifica da lista
 * considerando que o primeiro elemento valido esta na posicao 0.
 * @param posicao Meio da remocao.
 * @return resp int elemento a ser removido.
 * @throws Exception Se <code>posicao</code> invalida.
 */
int remover(int pos) {
   int resp;
   int tam = tamanho();

   if (primeiro == ultimo){
      errx(1, "Erro ao remover (vazia)!");
   } else if(pos < 0 || pos >= tam){
      errx(1, "Erro ao remover posicao (%d/ tamanho = %d) invalida!", pos, tam);
   } else if (pos == 0){
      resp = removerInicio();
   } else if (pos == tam - 1){
      resp = removerFim();
   } else {
      // Caminhar ate a posicao anterior a insercao
      Celula* i = primeiro;
      int j;
      for(j = 0; j < pos; j++, i = i->prox);

      Celula* tmp = i->prox;
      resp = tmp->elemento;
      i->prox = tmp->prox;
      tmp->prox = NULL;
      free(tmp);
      i = tmp = NULL;
   }
   return resp;
}


/**
 * Mostra os elementos da lista separados por espacos.
 */
void mostrar() {
   printf("[ ");
   Celula* i;
   for (i = primeiro->prox; i != NULL; i = i->prox) {
      printf("%d ", i->elemento);
   }
   printf("] \n");
}


/**
 * Procura um elemento e retorna se ele existe.
 * @param x Elemento a pesquisar.
 * @return <code>true</code> se o elemento existir,
 * <code>false</code> em caso contrario.
 */
bool pesquisar(int x) {
   bool retorno = false;
   Celula* i;

   for (i = primeiro->prox; i != NULL; i = i->prox) {
      if(i->elemento == x){
         retorno = true;
         i = ultimo;
      }
   }
   return retorno;
}


int main(int argc, char** argv) {
   int x1, x2, x3, x4, x5, x6;
   printf("=== LISTA DINAMICA SIMPLESMENTE ENCADEADA === \n\n");

   start();

   inserirInicio(1);
   inserirInicio(0);
   inserirFim(4);
   inserirFim(5);
   inserir(2, 2);
   inserir(3, 3);
   inserir(6, 6);
   inserir(-1, 0);
   inserirFim(7);
   inserirFim(8);

   printf("Apos insercoes: ");
   mostrar();

   x1 = remover(3);
   x2 = remover(2);
   x3 = removerFim();
   x4 = removerInicio();
   x5 = remover(0);
   x6 = remover(4);

   printf("Apos remocoes (%d, %d, %d, %d, %d, %d): ", x1, x2, x3, x4, x5, x6);
   mostrar();
   return 0;
}
