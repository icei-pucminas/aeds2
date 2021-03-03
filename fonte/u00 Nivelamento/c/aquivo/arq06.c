#include <stdio.h> 
#include <stdlib.h> 

int main(int argc, char *argv[]) { 

   FILE *p = fopen ("teste.txt", "w"); 
   fputs("Algoritmos e Estruturas de Dados II", p);
   fclose(p);

   return 0; 
}
