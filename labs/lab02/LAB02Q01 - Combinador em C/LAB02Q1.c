#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char combinador(char p1[100], char p2[100])
{
    char palavra[200];
    int cont = 1;
    int contPal = 0;

    int menTamanho = strlen(p1);
    int maiTamanho = strlen(p2);

    if (strlen(p1) > strlen(p2))
    {
        menTamanho = strlen(p2);
        maiTamanho = strlen(p1);
    }

    int rest = maiTamanho - menTamanho;

    for (int i = 0; i < menTamanho; i += 2, cont += 2, contPal++)
    {
        palavra[i] = p1[contPal];
        palavra[cont] = p2[contPal];
    }

    for (int i = rest; i < 200; i++)
    {
        if (strlen(p1) > strlen(p2))
            palavra[i] = p1[i];

        else if (strlen(p2) > strlen(p1))
            palavra[i] = p2[i];

        else if (p1[i] == '\0' && p2[i] == '\0')
            break;
    }
}

int main()
{

    char palavra1[100];
    char palavra2[100];

    while (scanf("%s", palavra1) != EOF)
    {
        scanf("%s", palavra2);
    }
}