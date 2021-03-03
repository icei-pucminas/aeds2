#include <stdio.h>
#include <stdlib.h>

typedef struct Elemento {
   int valor;
} Elemento;

int main (int argc, char** argv){
   Elemento e1;
   Elemento* e2 = (Elemento*) malloc (3 * sizeof (Elemento));
   Elemento e3[3];
   Elemento** e4 = (Elemento**) malloc(3 * sizeof(Elemento*));
   e4[0] = (Elemento*) malloc(sizeof(Elemento*));
   e4[2] = (Elemento*) malloc(sizeof(Elemento*));

   e4[0]->valor = 7;

   printf("\n%i -- %i\n", e4[0]->valor, e4[2]->valor);
   return 0;
}
