#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main (int argc, char** argv){
   double M [3][3];
   double *p = M[0];

   for (int i = 0; i < pow(3, 2); i++, p++){
      *p=0.0;
   }

}
