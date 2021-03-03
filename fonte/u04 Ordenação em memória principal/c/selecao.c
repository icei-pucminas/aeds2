#include "selecao.h"
//=============================================================================
void selecao(int *array, int n){
    for (int i = 0; i < (n - 1); i++) {
      int menor = i;
      for (int j = (i + 1); j < n; j++){
         if (array[menor] > array[j]){
            menor = j;
         }
      }
      swap(&array[menor], &array[i]);
   }
}
//=============================================================================
