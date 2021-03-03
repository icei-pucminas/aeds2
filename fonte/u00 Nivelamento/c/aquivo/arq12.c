#include <stdio.h>

int main(int argc, char *argv[]) { 
   FILE *p  = fopen("teste.txt", "wb+");
   int registro, valor, i;

   for (i = valor = 0; i < 10; i++, valor = i * 10)    fwrite(&valor, sizeof(int), 1, p);

   int numRegistro = ftell(p) / sizeof (int);

   do {
      printf ("\nEscolha um numero entre zero e %i: ", numRegistro-1);
      scanf("%d", &registro);
   } while (registro < 0 || registro >= numRegistro);

   fseek(p, registro * sizeof(int), SEEK_SET);
   fread(&valor, sizeof(int), 1, p);
   fclose(p);
   printf ("\nValor: %d\n\n", valor);

   return 0; 
}
