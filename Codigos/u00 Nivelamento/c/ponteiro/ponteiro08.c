#include <stdio.h>
#include <stdlib.h>

int main (int argc, char** argv){
   int a[10], *b;

   b = a;
   b[5] = 100;
   printf("\n%d -- %d", a[5], b[5]);

   b = (int*) malloc(10*sizeof(int));
   b[7] = 100;
   printf("\n%d -- %d", a[7], b[7]);
   printf("\n");

   //O comando a = b gera um erro de compilação

   return 0;
}
