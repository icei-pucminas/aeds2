#include <stdio.h> 
#include <stdlib.h> 

int main(int argc, char *argv[]) { 

   FILE *p = fopen ("teste.txt", "w"); 
   fputc('M', p);
   fclose(p);

   return 0; 
}

