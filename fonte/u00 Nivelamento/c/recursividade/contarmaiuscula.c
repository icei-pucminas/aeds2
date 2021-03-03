#include <stdio.h> 
#include <stdlib.h> 
#include <string.h>

#define bool int
#define true 1
#define false 0

bool isUpper(char x){
   return (x >= 'A' && x <= 'Z');
}

int contMaiusculo(char* s){
   int cont = 0;

   for(int i = 0; i < strlen(s); i++){
      if(isUpper(s[i]) == true){
         cont++;
      }
   }
   return cont;
}

int contMaiusculoRec(char* s, int i){
   int cont = 0;

   if(i < strlen(s)){
      if(isUpper(s[i]) == true){
         cont++;
      }
      cont += contMaiusculoRec(s, i + 1);
   }
   return cont;
}

int contMaiusculoRecursivo(char* s){
   return contMaiusculoRec(s, 0);
}

int main(int argc, char *argv[]) { 
   printf("\nAlGoritmos e Estrutudas de Dados: %i", contMaiusculo("AlGoritmos e Estruturas de Dados"));
   printf("\nAlGoritmos e Estruturas de Dados: %i", contMaiusculoRecursivo("AlGoritmos e Estruturas de Dados"));

   return 0; 
}
