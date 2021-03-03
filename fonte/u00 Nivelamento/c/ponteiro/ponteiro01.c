#include <stdio.h>
#include <stdlib.h>

int main (int argc, char** argv){
   int x = 10;
   int * y = & x;
   printf("\n%i", x);
   printf("\n%p", &x);
   printf("\n%p", y); 
   printf("\n%p", &y);
   printf("\n%i", *y);
   printf("\n");
}
