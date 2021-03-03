#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]){
   char c;
   char s[100];
   int i; 
   double d;

   printf("\nEntre com um caractere: ");
   scanf("%c", &c);

   printf("\nEntre com uma palavra: ");
   scanf("%s", s);

   printf("\nEntre com um inteiro e um real: ");
   scanf("%i%lf", &i, &d);

   printf("\ninteiro(%d) real(%f) char(%c) s(%s)", i, d, c, s);  

   return 0;
}
