#include <stdio.h>
#include <stdlib.h>

#define MAXTAM 10

typedef struct Cliente {
   int codigo;
   char nome[MAXTAM];
} Cliente;

int main (int argc, char** argv){
   Cliente c;
   c.codigo = 5;
   Cliente *p = NULL;
   p = (Cliente*) malloc (sizeof(Cliente));
   p->codigo = 6;
   Cliente *p2 = &c;
   p2->codigo = 7;

   return 0;
}
