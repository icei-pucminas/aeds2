#include <stdio.h>
#include <stdbool.h>
#include <string.h>
#include <stdlib.h>

bool isFim(char palavra[40])
{
    return ((palavra[0] == 'F') && (palavra[1] == 'I') && (palavra[2] == 'M') && (strlen(palavra) == 3));
}

bool isConsoante(char s[100])           //metodo que recebe a entrada como char[]
{
    bool resp = true;

    for (int i = 0; i < strlen(s); i++)         //loop percorre o array e verifica se existe alguma vogal
    {
        if (s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u' || s[i] == 'A' || s[i] == 'E' || s[i] == 'I' || s[i] == 'O' || s[i] == 'U')
        {
            resp = false;           //se existe alguma vogal, o loop quebra e retorna false
            break;
        }
    }

    return resp;
}

bool isVogal(char s[100])               //metodo que recebe a entrada como char[]
{
    bool resp = true;

    for (int i = 0; i < strlen(s); i++)                 //loop percorre o array e verifica se existe algum  char diferente das vogais
    {
        if (s[i] != 'a' || s[i] != 'e' || s[i] != 'i' || s[i] != 'o' || s[i] != 'u' || s[i] != 'A' || s[i] != 'E' || s[i] != 'I' || s[i] != 'O' || s[i] != 'U')
        {
            resp = false;                   //se existe alguma consoante, o loop quebra e retorna false
            break;
        }
    }

    return resp;
}

bool isInt(char s[100])                 //metodo que recebe a entrada como char[]
{   
    bool resp = true;

    for (int i = 0; i < strlen(s); i++)         //loop percorre a entra e verifica se existe algum char diferente do conjunto {0-9}
    {
        if (s[i] != '0' || '1' || '2' || '3' || '4' || '5' || '6' || '7' || '8' || '9')
            resp = false;               //caso exista, o loop quebra e retorna false
    }

    return resp;
}

bool isDouble(char s[100])              //metodo que recebe a entrada como char[]
{
    bool resp = true;

    int contV = 0;                               //variaveis que realizam a contagem de pontos e virgulas
    int contP = 0;

    if (isInt(s) == true)                       //como qualquer numero inteiro é real, se o metodo numInt retorna true, o numero é automaticamente real
        resp = true;

    else
    {
        for (int i = 0; i < strlen(s); i++)             //loop que percorre a entra e verifica a ocorrencia de mais de um '.' ou ','
        {
            if (s[i] == '.')
                contP++;

            else if (s[i] == ',')
                contV++;
        }

        if (contP != 1)

            resp = false;                           //se existe mais de um '.' ou ',', o resultado é false
        else if (contV != 1)
            resp = false;
    }

    return resp;
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

    for (int i = 0; i < numEntrada; i++)                //loop que  percorre cada entrada e retorna os valores de acordo com o resultado dos metodos
    {
        if (isConsoante(entrada[i]) == true)
            printf("SIM ");
        else
            printf("NAO ");

        if (isVogal(entrada[i]) == true)
            printf("SIM ");
        else
            printf("NAO ");

        if (isInt(entrada[i]) == true)
            printf("SIM ");
        else
            printf("NAO ");

        if (isDouble(entrada[i]) == true)
            printf("SIM ");
        else
            printf("NAO \n");
    }
}