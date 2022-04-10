#include "bolha.h"
#include "countingsort.h"
#include "heapsort.h"
#include "insercao.h"
#include "mergesort.h"
#include "quicksort.h"
#include "selecao.h"
#include "shellsort.h"

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

//=============================================================================
int main(int argc, char **argv) {

    //Delcaracao de variaveis
    int n = (argc < 2) ? 1000 : atoi(argv[1]);
    int *array = (int*) malloc(n*sizeof(int));
    clock_t inicio, fim;
    double total;


    //Geracao do conjunto a ser ordenado
	 aleatorio(array, n);
	 //crescente(array, n);
	 //decrescente(array, n);


    //Mostrar o conjunto a ser ordenado
	 //mostrar(array, n);
		

    //Execucao do algoritmo de ordenacao
	 inicio = clock();
    //bolha(array, n);
    //countingsort(array, n);
    //heapsort(array, n);
    //insercao(array, n);
    //mergesort(array, n);
    //quicksort(array, n);
    selecao(array, n);
    //shellsort(array, n);
	 fim = clock();
    total = ((fim - inicio) / (double)CLOCKS_PER_SEC);    


    //Mostrar o conjunto ordenado, tempo de execucao e status da ordenacao
	 //algoritmo.mostrar(array, n);
	 printf("Tempo para ordenar: %f s.\n", total);
	 printf("isOrdenado: %s\n", isOrdenado(array, n) ? "true" : "false");

    //Desalocar o espaco de memoria do array
    free(array);

    return 0;
}
