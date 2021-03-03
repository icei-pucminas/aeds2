#include <stdio.h> 
#include <stdlib.h> 

int main(int argc, char *argv[]) {

   FILE *in = fopen ("teste.txt", "r"), 
        *out = fopen ("copia.txt", "w");

   while ( !feof(in) ) {
      char ch = getc(in);
      if ( !feof(in)) {
         putc(ch, out);
      }
   }

   fclose(in);
   fclose(out);
   return 0; 
}
