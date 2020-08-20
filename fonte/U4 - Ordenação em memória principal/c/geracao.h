#ifndef GERACAO_H
#define GERACAO_H
//=============================================================================
#include <stdio.h>
#include <math.h>
#include <time.h>
#include <stdlib.h>
#include <stdbool.h>
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
    int i;
    for (i = 0; i < n; i++) {
        array[i] = i;
    }
}
//=============================================================================
// PROCEDIMENTO PARA PREENCHER UM ARRANJO COM ELEMENTOS EM ORDEM DECRESCENTE
void decrescente(int *array, int n) {
    int i;
    for (i = 0; i < n; i++) {
        array[i] = n - 1 - i;
    }
}
//=============================================================================
// PROCEDIMENTO PARA PREENCHER UM ARRANJO COM ELEMENTOS EM ORDEM ALEATORIA
void aleatorio(int *array, int n) {
    int i, pos;
    crescente(array, n);
    srand(time(NULL));
    for (i = 0; i < n; i++) {
        pos = rand() % n;
        swap(&array[i], &array[pos]);
    }
}
//=============================================================================
// PROCEDIMENTO PARA EXIBIR OS DADOS PRESENTES NO ARRANJO
void mostrar(int *array, int n) {
    int i;
    printf("[ ");
    for (i = 0; i < n; i++) {
        printf("%d ", array[i]);
    }
    printf("] \n");
}
//=============================================================================
// PROCEDIMENTO PARA VERIFICAR SE O ARRANJO ESTA ORDENADO
bool isOrdenado(int *array, int n){
    int i;
    for(int i = 1; i < n; i++){
        if(array[i-1] > array[i]){
            return false;
        }
    }
    return true;
}
//=============================================================================
#endif
