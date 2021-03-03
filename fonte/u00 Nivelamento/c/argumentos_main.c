#include <stdio.h>
#include <stdlib.h>
//=============================================================================
// EXEMPLO DE UTILIZAÇÃO DOS ARGUMENTOS PASSADOS PARA O MAIN
int main(int argc, char *argv[]){
    
    int i;

    for (i = 0; i < argc; i++)
        printf("%d Parametro: %s\n", i, argv[i]);

    return 0;
}
//=============================================================================