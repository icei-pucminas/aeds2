#include <stdio.h>
#include <stdlib.h>

int main (int argc, char** argv){
   double a;
   double *p, *q;

   a = 3.14;
   printf("%f\n", a);

   p = &a;
   *p = 2.718;
   printf("%f\n", a);

   a = 5;
   printf("%f\n", *p);

   p = NULL;
   p = (double*) malloc(sizeof(double));
   *p = 20;
   q = p;

   printf("%f\n", *p);
   printf("%f\n", a);
   free(p);
   printf("%f\n", *q);
   printf("\n");

   return 0;
}
