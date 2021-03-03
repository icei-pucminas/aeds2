#include <stdio.h>
#include <stdlib.h>

int main (int argc, char** argv){
   int x1 = 11, 
       x2 = 22, 
       x3 = 33;   
   int *p;

   p = &x1; //p <- o endereço de x1
   x2 = *p; //x2 <- o cont. do addr apont. por p
   *p = x3; //o cont. do addr apont. por p <- x3
   p = &x3; //p <- o endereço de x3
   *p = 0;  //o cont. do addr apont. por p <- x3

   printf("\ncont:%d %d %d %d", x1, x2, x3, *p);
   printf("\naddr:%p %p %p %p", &x1, &x2, &x3, p);
   printf("\n");
}
