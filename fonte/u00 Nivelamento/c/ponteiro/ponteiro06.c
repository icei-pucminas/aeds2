#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAXTAM 100

typedef struct Cliente {
   int codigo;
   char nome[MAXTAM];
} Cliente;

int main (int argc, char** argv){
   Cliente registro;
   Cliente* ponteiro = (Cliente*) malloc (sizeof(Cliente));

   registro.codigo = 1;
   strcpy(registro.nome, "AA");
   printf("\nFuncionario (%i): %s", registro.codigo, registro.nome);

   ponteiro->codigo = 2;
   strcpy(ponteiro->nome, "BB");
   printf("\nFuncionario (%i): %s", ponteiro->codigo, ponteiro->nome);
   printf("\n");
}
