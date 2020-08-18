#include "bolha.h"
//=============================================================================
int main(int argc, char **argv) {

    int n, *array;
    clock_t comeco, fim;
    double total;
    srand(time(NULL));

    if(argc < 2){
        printf("Execute: %s n\n", argv[0]);
        printf("n - tamanho do vetor (int)\n");
        return 0;
    }

    n = atoi(argv[1]);

    if(n <= 0){
        printf("Erro: n deve ser > 0\n");
        return 0;
    }

    array = (int*)malloc(n*sizeof(int));

    printf("Teste Bolha: Ordem Crescente\n");
    crescente(array, n);
    mostrar(array, n);
    comeco = clock();
    bolha(array, n);
    fim = clock();
    total = (fim - comeco) / (double)CLOCKS_PER_SEC / 1000.0;    
    mostrar(array, n);
    printf("Tempo para ordenar: %f ms (%i).", total, isOrdenado(array, n));

    printf("Teste Bolha: Ordem Decrescente\n");
    decrescente(array, n);
    mostrar(array, n);
    comeco = clock();
    bolha(array, n);
    fim = clock();
    total = (fim - comeco) / (double)CLOCKS_PER_SEC / 1000.0;    
    mostrar(array, n);
    printf("Tempo para ordenar: %f ms (%i).", total, isOrdenado(array, n));

    printf("Teste Bolha: Ordem Aleatoria\n");
    aleatorio(array, n);
    mostrar(array, n);
    comeco = clock();
    bolha(array, n);
    fim = clock();
    total = (fim - comeco) / (double)CLOCKS_PER_SEC / 1000.0;    
    mostrar(array, n);
    printf("Tempo para ordenar: %f ms (%i).", total, isOrdenado(array, n));   

    free(array);

    return 0;
}