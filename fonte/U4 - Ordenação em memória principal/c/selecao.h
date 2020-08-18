#ifndef SELECAO_H
#define SELECAO_H
//=============================================================================
#include "geracao.h"
//=============================================================================
void selecao(int *array, int n){
    int i, j, indice;
    for (i = 0; i < (n - 1); i++) {
      indice = i;
      for (j = (i + 1); j < n; j++){
         if (array[indice] > array[j]){
            indice = j;
         }
      }
      swap(&array[indice], &array[i]);
   }
}
//=============================================================================
#endif