#include <stdio.h>

int main(int argc, char *argv[]) { 
   FILE *p  = fopen("teste.txt", "wb+");

   double d = 12.23;		int i = 101;			long l = 123023L;


   fwrite(&d, sizeof(double), 1, p);
   fwrite(&i, sizeof(int), 1, p);
   fwrite(&l, sizeof(long), 1, p);

   rewind(p);

   fread(&d, sizeof(double), 1, p);
   fread (&i, sizeof(int), 1, p);
   fread (&l, sizeof(long), 1, p);

   printf("%f %d %ld", d, i, l);
   fclose(p);

   return 0; 
}
