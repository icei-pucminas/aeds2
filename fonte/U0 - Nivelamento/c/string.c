#include <stdio.h>
#include <string.h>

int main(int argc, char *argv[]){
   char s1[80], s2[80]; 

   strcpy(s1, "Algoritmos"); 
   strcpy(s2, " e Estruturas de Dados II"); 

   printf("\nTamanho s1(%i)", (int)strlen(s1)); 
   printf("\nTamanho s2(%i)", (int)strlen(s2)); 

   if(!strcmp(s1, s2))  printf("\nIguais!!!"); 
   else                 printf("\nDiferentes!!!"); 

   strcat(s1, s2);
   printf("\nNova s1 (%s)", s1); 

   strcpy(s2, s1); 
   printf("\nNova s2 (%s)", s2); 

   if(!strcmp(s1, s2))  printf("\nIguais!!!"); 
   else                 printf("\nDiferentes!!!");

   s1[10] = s2[10] = '\0';  s1[11] = 'a';  s2[11] = 'b';
   printf("\nNova s1 (%s)", s1); 
   printf("\nNova s2 (%s)", s2);

   if(!strcmp(s1, s2))  printf("\nIguais!!!"); 
   else                 printf("\nDiferentes!!!");

   return 0; 
}
