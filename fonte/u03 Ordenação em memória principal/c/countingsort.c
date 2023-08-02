#include "geracao.h"
#include "countingsort.h"
//=============================================================================
int getMaior(int *array, int n) {
    int maior = array[0];

    for (int i = 0; i < n; i++) {
        if(maior < array[i]){
            maior = array[i];
        }
    }
    return maior;
}
//=============================================================================
void countingsort(int *array, int n) {
    //Array para contar o numero de ocorrencias de cada elemento
    int tamCount = getMaior(array, n) + 1;
    int count[tamCount];
    int ordenado[n];

    //Inicializar cada posicao do array de contagem 
    for (int i = 0; i < tamCount; count[i] = 0, i++);

    //Agora, o count[i] contem o numero de elemento iguais a i
    for (int i = 0; i < n; count[array[i]]++, i++);

    //Agora, o count[i] contem o numero de elemento menores ou iguais a i
    for(int i = 1; i < tamCount; count[i] += count[i-1], i++);

    //Ordenando
    for(int i = n-1; i >= 0; ordenado[count[array[i]]-1] = array[i], count[array[i]]--, i--);

    //Copiando para o array original
    for(int i = 0; i < n; array[i] = ordenado[i], i++);
}
//=============================================================================
