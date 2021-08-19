#include <stdio.h>
#include <string.h>
#include <stdlib.h>

// verifica se uma palavra eh um palindromo

void palindromo(char palavra[])
{
    char copia[1000];
    strcpy(copia, palavra);
    int x = strlen(palavra) - 2;

    for(int i = 0; i < strlen(palavra) - 1; i++){
        copia[i] = palavra[x--];
    }

    if (strcmp(palavra, copia) == 0)
    {
        printf("SIM\n");
    }
    else
    {
        printf("NAO\n");
    }
} // fim int palindromo

int main()
{
    int teste = 1, i = 0;
    char* palavra;
    palavra = (char*) malloc(1000 * sizeof(char));

    while (teste == 1)
    {
        fgets(palavra, 1000, stdin);

        if (strcmp(palavra, "FIM") == 0)
        {
            teste = 0;
        }else{
            printf("%s\n", palavra);
            //palindromo(palavra);
        }
    }

    return 0;
} // fim int main
