#include "geracao.h"
#include "radixsort.h"
//=============================================================================
int getMax(int *array, int n) {
    int maior = array[0];

    for (int i = 1; i < n; i++) {
        if(maior < array[i]){
            maior = array[i];
        }
    }
    return maior;
}
//=============================================================================
void radixsort(int *array, int n) {
    //Array para contar o numero de ocorrencias de cada elemento
    int max = getMax(array, n);
    for (int exp = 1; max/exp > 0; exp *= 10) {
            radcountingSort(array, n, exp);
    }
}

  void radcountingSort(int *array, int n, int exp) {
        int count[10];
        int output[n];

        //Inicializar cada posicao do array de contagem 
        for (int i = 0; i < 10; count[i] = 0, i++);

        //Agora, o count[i] contem o numero de elemento iguais a i
        for (int i = 0; i < n; i++) {
            count[(array[i]/exp) % 10]++;
        }

        //Agora, o count[i] contem o numero de elemento menores ou iguais a i
        for (int i = 1; i < 10; i++) {
            count[i] += count[i-1];
        }

        //Ordenando
        for (int i = n-1; i >= 0; i--) {
            output[count[(array[i]/exp) % 10] - 1] = array[i];
            count[(array[i]/exp) % 10]--;
        }

        //Copiando para o array original
        for (int i = 0; i < n; i++) {
            array[i] = output[i];
        }
    }
//=============================================================================
