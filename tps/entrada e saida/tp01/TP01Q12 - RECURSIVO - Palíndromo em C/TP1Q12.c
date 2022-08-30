#include <string.h>
#include <stdio.h>
#include <stdbool.h>

bool isFim(char palavra[40])
{
    return ((palavra[0] == 'F') && (palavra[1] == 'I') && (palavra[2] == 'M') && (strlen(palavra) == 3)); // metodo que verifica se o arquivo chegou ao fim
}

bool isPalindromo(char p[], int i, int j)   //metodo que recebe string de cada linha do arquivo
{
    bool resp = true;

    if (i <= j)     //verifica se a ambas as metades da palavra foram analisadas
    {
        if (p[i] != p[j])               //se algum char for diferente, a resposta é false 
        {
            resp = false;
            i = strlen(p);
        }

        else
            return isPalindromo(p, i + 1, j - 1);                           //continua o loop por toda a palavra
    }

    return resp;    //retorna resp final
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

    for (int i = 0; i < numEntrada; i++) 
    {
        if (isPalindromo(entrada[i], 0, strlen(entrada[i]) - 1) == true)    // aciona o metodo isPalindromo com a entrada de dados do arquivo
            printf("SIM\n");

        else
            printf("NAO\n");
    }
}