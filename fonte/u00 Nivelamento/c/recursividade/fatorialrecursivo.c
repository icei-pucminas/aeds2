#include <stdio.h> 
#include <stdlib.h> 

int fatorial(int n){
   int resp;
   printf("\nfat (%i)", n);
   resp = (n == 1) ? 1 : n * fatorial(n-1);
   printf("\nfat n(%i): %i", n, resp);
   return resp;
}


int main(int argc, char *argv[]) { 
   int n = 5;
   printf("\nFATORIAL RECURSIVO(%i): %i", n, fatorial(n));

   return 0; 
}
