#include "geracao.h"
//=============================================================================
#include <stdio.h>
#include <math.h>
#include <time.h>
#include <stdlib.h>
//=============================================================================
// PROCEDIMENTO PARA TROCAR DOIS ELEMENTOS DO VETOR
void swap(int *i, int *j) {
   int temp = *i;
   *i = *j;
   *j = temp;
}
//=============================================================================
// PROCEDIMENTO PARA PREENCHER UM ARRANJO COM ELEMENTOS EM ORDEM CRESCENTE
void crescente(int *array, int n) {
   for (int i = 0; i < n; i++) {
      array[i] = i;
   }
}
//=============================================================================
// PROCEDIMENTO PARA PREENCHER UM ARRANJO COM ELEMENTOS EM ORDEM DECRESCENTE
void decrescente(int *array, int n) {
   for (int i = 0; i < n; i++) {
      array[i] = n - 1 - i;
   }
}
//=============================================================================
// PROCEDIMENTO PARA PREENCHER UM ARRANJO COM ELEMENTOS EM ORDEM ALEATORIA
void aleatorio(int *array, int n) {
   crescente(array, n);
   srand(time(NULL));
   for (int i = 0; i < n; i++) {
      swap(&array[i], &array[rand() % n]);
   }
}
//=============================================================================
// PROCEDIMENTO PARA PREENCHER UM ARRANJO COM ELEMENTOS DA ENTRADA PADRAO
int entradaPadrao(int *array) {
   int n;
   scanf("%i", &n);
   array = (int*) malloc(n*sizeof(int));
   
   for (int i = 0; i < n; i++) {
      scanf("%i", &array[i]);
   }
   return n;
}
//=============================================================================
// PROCEDIMENTO PARA EXIBIR OS DADOS PRESENTES NO ARRANJO
void mostrar(int *array, int n) {
   printf("[ ");
   for (int i = 0; i < n; i++) {
      printf("%d ", array[i]);
   }
   printf("] \n");
}
//=============================================================================
// PROCEDIMENTO PARA VERIFICAR SE O ARRANJO ESTA ORDENADO
bool isOrdenado(int *array, int n){
   bool resp = true;
   for(int i = 1; i < n; i++){
      if(array[i-1] > array[i]){
         i = n;
         resp = false;
      }
   }
   return resp;
}
//=============================================================================
