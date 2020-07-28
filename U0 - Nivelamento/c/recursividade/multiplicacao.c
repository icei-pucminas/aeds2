#include <stdio.h> 
#include <stdlib.h> 

int multiplicacaoRec(int a, int b, int i){
   int resp = 0;

   if(i < b){
      resp = a + multiplicacaoRec(a, b, i+1);
   }

   return resp;
}

int multiplicacao(int a, int b){
   return multiplicacaoRec(a, b, 0);
}

int multiplicacaoIt(int a, int b){
   int resp = 0;
   for(int i = 0; i < b; i++){
      resp = a + resp;
   }
   return resp;
}

int main(int argc, char *argv[]) { 
   int mult = multiplicacaoIt(4, 3);
   printf("\nRESPOSTA IT: %i", mult);

   mult = multiplicacao(4, 3);
   printf("\nRESPOSTA REC: %i", mult);

   return 0; 
}
