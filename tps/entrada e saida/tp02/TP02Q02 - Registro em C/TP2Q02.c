#define _GNU_SOURCE
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
FILE *arq;

bool isFim(char palavra[40])
{
    return ((palavra[0] == 'F') && (palavra[1] == 'I') && (palavra[2] == 'M') && (strlen(palavra) == 3)); // metodo que verifica se o arquivo chegou ao fim
}

void readData(int dado)
{
    int dadoGames = 0;
    int pos = 0;
    char initialData[1000];

    arq = fopen("/tmp/games.csv", "r");

    while (fscanf(arq, "%d", &dadoGames) != -1)
    {
        if (dado == dadoGames)
        {
            fscanf(arq, " %[^\n]s", &initialData);
            int size = strlen(initialData);
            char newData[size];
            strcpy(newData, initialData);
            printData(newData);
        }
    }
}

void printData(char s[])
{
    int firstPos = 0;
    int lastPos = 0;
    int sizeLanguages = lastPos - firstPos;

    char languages[sizeLanguages];

    for (int i = 0; i < strlen(s); i++)
    {
        if (s[i] == '[')
            firstPos = i;
        else if (s[i] == ']')
            lastPos = i;

        for (int j = firstPos + 1, k = 0; j < sizeLanguages; j++, k++)
        {
            languages[k] = s[j];
            if (s[j] == '\'')
                languages[k] = ' ';
        }
    }
}

int main()
{
    char entrada[1000][100];
    int numEntrada = 0;

    // entrada de dados padrao

    do
    {
        scanf(" %[^\n]s", entrada[numEntrada]);

    } while (isFim(entrada[numEntrada++]) == false);
    numEntrada--;
}
