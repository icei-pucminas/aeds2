#include <stdlib.h>
#include <stdio.h>
 
int main(void)
{
   int i, ranvals[5];
 
   srand(17);
   for (i = 0; i < 5; i++)
   {
      ranvals[i] = rand();
      printf("Iteration %d ranvals [%d] = %d\n", i+1, i, ranvals[i]);
   }
}


