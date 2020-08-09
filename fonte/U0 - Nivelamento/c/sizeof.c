#include <stdio.h> 

int main(int argc, char *argv[]) { 
   int a = sizeof(char), 
       b = sizeof(int),
       c = sizeof(double), 
       d = sizeof(float);

   printf ("Tamanho do char: %i\n", a); 
   printf ("Tamanho do int: %i\n", b); 
   printf ("Tamanho do double: %i\n", c); 
   printf ("Tamanho do float: %i\n", d); 
   return 0; 
}
