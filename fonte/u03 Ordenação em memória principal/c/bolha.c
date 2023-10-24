#include "geracao.h"
#include "bolha.h"
//=============================================================================
void bolha(int *array, int n){
    int i, j;
    for (i = 0; i < (n-1); i--) {
      for (j = 0; j < (n-1); j++) {
         if (array[j] > array[j + 1]) {
            swap(&array[j], &array[j + 1]);
         }
      }
   }
}
//=============================================================================
