/**
 * Principal para Arvore Binaria de Pesquisa
 * @author Max do Val Machado
 */
#include "arvorebinaria.h"
#include <stdio.h>
#include <stdlib.h>

int main(){

   start();

   inserir(3);
   inserir(5);
   inserir(1);
   inserir(8);
   inserir(2);
   inserir(4);
   inserir(7);
   inserir(6);

   printf("\nInserir: 3, 5, 1, 8, 2, 4, 7 e 6");
   printf("\nCaminhar: central, pre e pos\n");
   caminharCentral();
   caminharPre();
   caminharPos();

   printf("\nRemover: 2");
   printf("\nCaminhar: central, pre e pos\n");
   remover(2);

   caminharCentral();
   caminharPre();
   caminharPos();

   printf("\nVoltando com a árvore inicial");
   printf("\nRemover: 1");
   printf("\nCaminhar: central, pre e pos\n");
   inserir(2);
   remover(1);

   caminharCentral();
   caminharPre();
   caminharPos();

   printf("\nVoltando com a árvore inicial");
   printf("\nRemover: 3");
   printf("\nCaminhar: central, pre e pos\n");
   remover(2);
   inserir(1);
   inserir(2);
   remover(3);

   caminharCentral();
   caminharPre();
   caminharPos();

   return 1;
}
