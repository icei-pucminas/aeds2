#include <stdio.h> 
#include <stdlib.h> 

int main(int argc, char *argv[]) { 

   FILE *p = fopen (argv[1], "r"); 
   int ch;

   if (p != NULL) {
      do {
         ch = fgetc(p);
         if(ch != EOF){
            printf( "%i %c\n", ch, (char)ch);
            //printf( "%c", (char)ch);
         }
      } while (ch != EOF);
      fclose(p);
   }

   return 0; 
}
