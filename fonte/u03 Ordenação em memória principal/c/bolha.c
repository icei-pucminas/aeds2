#include "geracao.h"
#include "bolha.h"
//=============================================================================
void bolha(int *array, int n){
    int i, j;
    for (i = (n - 1); i > 0; i--) {
      for (j = 0; j < i; j++) {
         if (array[j] > array[j + 1]) {
            swap(&array[j], &array[j + 1]);
         }
      }
   }
}
//=============================================================================
