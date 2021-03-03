#include <stdio.h>
#include <stdlib.h>
#define true 1

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

Celula* primeiro;

void start () {
   primeiro = novaCelula(-1);
}

void inserir(int x) {
   primeiro->prox = novaCelula(x);
   Celula* tmp = primeiro;
   primeiro = primeiro->prox;
   free(tmp);
}

int main(int argc, char** argv) {
   start();
   while(true){
      inserir(0);
   }
   return 0;
}


