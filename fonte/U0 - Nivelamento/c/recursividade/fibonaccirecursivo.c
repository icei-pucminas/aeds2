#include <stdio.h> 
#include <stdlib.h> 

int fibonacci(int n){
   int resp;
   printf("\nfib (%i)", n);
   resp = (n == 0 || n == 1) ? 1 : fibonacci(n-1) + fibonacci(n-2);
   printf("\nfib n(%i): %i", n, resp);
   return resp;
}


int main(int argc, char *argv[]) { 
   int n = 5;
   printf("\nFIBONACCI RECURSIVO(%i): %i", n, fibonacci(n));

   return 0; 
}
