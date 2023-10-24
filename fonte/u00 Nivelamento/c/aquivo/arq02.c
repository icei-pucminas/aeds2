#include <stdio.h> 
#include <stdlib.h> 



int main(int argc, char *argv[]) { 

   FILE *p = fopen ("teste.txt", "r"); 

   // testa se o arquivo foi aberto com sucesso 
   if (p != NULL) {
      printf ("Arquivo foi aberto com sucesso.\n\n"); 
      fclose(p);
   } else {
      printf ("Nao foi possivel abrir o arquivo.\n\n"); 
   }

   return 0; 
}
