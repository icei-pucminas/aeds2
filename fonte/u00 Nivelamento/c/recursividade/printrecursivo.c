#include <stdio.h> 
#include <stdlib.h> 

void printRecursivo(int i){
   printf("\nvalor de i: %i", i);
   if(i > 0){
      printRecursivo(i-1);
   }
   printf("\nvalor de i: %i", i);
}

int main(int argc, char *argv[]) { 
   int n = 3;
   printRecursivo(n);

   return 0; 
}
