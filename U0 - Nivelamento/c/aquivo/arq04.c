#include <stdio.h> 
#include <stdlib.h> 

int main(int argc, char *argv[]) { 

   FILE *p = fopen ("teste.txt", "r"); 
   char str[100+1];
   char* resp;
   int i = 0;

   if (p != NULL) {
      do {
         resp = fgets(str, 100, p);
         if(resp != NULL){
            printf("(%d) %s", i, str);
            i++;
         }
      } while (resp != NULL);
      fclose(p);
   }

   return 0; 
}
