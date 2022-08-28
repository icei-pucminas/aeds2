#include <string.h>
#include <stdio.h>
#include <stdbool.h>

bool isPalindromo(char p[])             //metodo que verifica se a entrada é  um palindromo ou nao
{
    bool resposta = true;
    int k = 0;

    for (int i = strlen(p) - 1; i >= 0; i--, k++)       //loop que verifica asa letras opostas do char[]
    {
        if (p[i] != p[k])
            resposta = false;                           // se houver diferença, retorna false
    }

    return resposta;
}

bool isFim(char palavra[40])
{
    return ((palavra[0] == 'F') && (palavra[1] == 'I') && (palavra[2] == 'M') && (strlen(palavra) == 3));   //metodo que verifica se o arquivo chegou ao fim
}

int main()
{
    char entrada[1000][100];
    int numEntrada = 0;

    //entrada de dados padrao

    do
    {
        scanf(" %[^\n]s", entrada[numEntrada]);

    } while (isFim(entrada[numEntrada++]) == false);
    numEntrada--;

    for (int i = 0; i < numEntrada; i++) //aciona o metodo isPalindromo com a entrada de dados do arquivo
    {
        if (isPalindromo(entrada[i]) == true)
            printf("SIM\n");

        else
            printf("NAO\n");
    }
}
