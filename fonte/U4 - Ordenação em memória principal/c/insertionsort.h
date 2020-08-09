 #ifndef INSERTSORT_H
 #define INSERTSORT_H
 //=============================================================================
#include "sort.h"
//=============================================================================
void insertSort(int *array, int n){
    int i, j, tmp;
    for (int i = 1; i < n; i++) {
      tmp = array[i];
      int j = i - 1;

      while ((j >= 0) && (array[j] > tmp)) {
         array[j + 1] = array[j];
         j--;
      }
      array[j+1] = tmp;
   }
}
//=============================================================================
#endif