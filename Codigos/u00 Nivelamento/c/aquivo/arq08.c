#include <stdio.h> 
#include <stdlib.h> 

int main(int argc, char *argv[]) { 

   FILE *p; 

   double d = 12.23;
   int i = 101;
   long l = 123023L;

   if ((p = fopen("teste.txt", "wb")) == NULL) {
      printf ("arquivo nao pode ser aberto\n");
      exit(1);
   }

   fwrite(&d, sizeof(double), 1, p);
   fwrite(&i, sizeof(int), 1, p);
   fwrite(&l, sizeof(long), 1, p);

   fclose(p);

   return 0; 
}
