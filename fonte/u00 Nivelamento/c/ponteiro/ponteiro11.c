#include <stdio.h>
#include <stdlib.h>

typedef struct Celula {
   int elemento;
   struct Celula *prox;
} Celula;

Celula *novaCelula(int elemento) {
   Celula *nova = (Celula*) malloc(sizeof(Celula));
   nova->elemento = elemento;
   nova->prox = NULL;
   return nova;
}

int main (int argc, char** argv){
   Celula *tmp = novaCelula(3);

   return 0;
}
