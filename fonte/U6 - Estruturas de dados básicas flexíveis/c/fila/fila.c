/**
 * Fila dinamica
 * @author Max do Val Machado
 * @version 2 01/2015
 */
#include <stdio.h>
#include <stdlib.h>
#include <err.h>

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

//FILA PROPRIAMENTE DITA ========================================================
Celula* primeiro;
Celula* ultimo;


/**
 * Cria uma fila sem elementos (somente no cabeca).
 */
void start () {
   primeiro = novaCelula(-1);
   ultimo = primeiro;
}


/**
 * Insere elemento na fila (politica FIFO).
 * @param x int Elemento a inserir.
 */
void inserir(int x) {
   ultimo->prox = novaCelula(x);
   ultimo = ultimo->prox;
}


/**
 * Remove elemento da fila (politica FIFO).
 * @return Elemento removido.
 */
int remover() {
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
 * Mostra os elementos separados por espacos.
 */
void mostrar() {
   Celula* i;
   printf("[ ");
   for (i = primeiro->prox; i != NULL; i = i->prox) {
      printf("%d ", i->elemento);
   }
   printf("] \n");
}


//METODO PRINCIPAL ==============================================================
int main(int argc, char** argv){
   int x1, x2, x3;
   printf("\n==== FILA DINAMICA ====");

   start();

   inserir(5);
   inserir(7);
   inserir(8);
   inserir(9);

   printf("\nApos insercoes(5, 7, 8, 9): ");
   mostrar();

   x1 = remover();
   x2 = remover();

   printf("\nApos remocoes (%d, %d):", x1, x2);
   mostrar();

   inserir(3);
   inserir(4);


   printf("\nApos insercoes(3, 4): ");
   mostrar();

   x1 = remover();
   x2 = remover();
   x3 = remover();

   printf("\nApos remocoes (%d, %d, %d):", x1, x2, x3);
   mostrar();

   inserir(4);
   inserir(5);

   printf("\nApos insercoes(4, 5): ");
   mostrar();

   x1 = remover();
   x2 = remover();

   printf("\nApos remocoes (%d, %d):", x1, x2);
   mostrar();

   inserir(6);
   inserir(7);

   printf("\nApos insercoes(6, 7): ");
   mostrar();

   x1 = remover();

   printf("\nApos remocao (%d):", x1);
   mostrar();
}
