#ifndef SELECAO_H
#define SELECAO_H
//=============================================================================
#include "geracao.h"
//=============================================================================
void selecao(int *array, int n){
    int i, j, menor;
    for (i = 0; i < (n - 1); i++) {
      menor = i;
      for (j = (i + 1); j < n; j++){
         if (array[menor] > array[j]){
            menor = j;
         }
      }
      swap(&array[menor], &array[i]);
   }
}
//=============================================================================
#endif
