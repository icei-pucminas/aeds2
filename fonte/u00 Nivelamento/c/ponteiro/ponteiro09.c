#include <stdio.h>
#include <stdlib.h>

int main (int argc, char** argv){
   int *x1;
   int x2;
   int *x3;

   x1 = (int*) malloc(sizeof(int));
   printf("\nx1(%p)(%p)(%i) x2(%p)(%i) x3(%p)(%p)(%i)", &x1, x1, *x1, &x2, x2, &x3, x3, *x3);

   *x1 = 20;
   printf("\nx1(%p)(%p)(%i) x2(%p)(%i) x3(%p)(%p)(%i)", &x1, x1, *x1, &x2, x2, &x3, x3, *x3);

   x2 = *x1;
   printf("\nx1(%p)(%p)(%i) x2(%p)(%i) x3(%p)(%p)(%i)", &x1, x1, *x1, &x2, x2, &x3, x3, *x3);

   *x3 = x2 * *x1;
   printf("\nx1(%p)(%p)(%i) x2(%p)(%i) x3(%p)(%p)(%i)", &x1, x1, *x1, &x2, x2, &x3, x3, *x3);

   x3 = &x2;
   printf("\nx1(%p)(%p)(%i) x2(%p)(%i) x3(%p)(%p)(%i)", &x1, x1, *x1, &x2, x2, &x3, x3, *x3);

   x2 = 15;
   printf("\nx1(%p)(%p)(%i) x2(%p)(%i) x3(%p)(%p)(%i)", &x1, x1, *x1, &x2, x2, &x3, x3, *x3);

   x2 = 13 & 3;
   printf("\nx1(%p)(%p)(%i) x2(%p)(%i) x3(%p)(%p)(%i)", &x1, x1, *x1, &x2, x2, &x3, x3, *x3);

   x2 = 13 | 3;
   printf("\nx1(%p)(%p)(%i) x2(%p)(%i) x3(%p)(%p)(%i)", &x1, x1, *x1, &x2, x2, &x3, x3, *x3);

   x2 = 13 >> 1;
   printf("\nx1(%p)(%p)(%i) x2(%p)(%i) x3(%p)(%p)(%i)", &x1, x1, *x1, &x2, x2, &x3, x3, *x3);

   x2 = 13 << 1;
   printf("\nx1(%p)(%p)(%i) x2(%p)(%i) x3(%p)(%p)(%i)", &x1, x1, *x1, &x2, x2, &x3, x3, *x3);

   return 0;
}
