#include <stdio.h>

#define MAXTAM   100

typedef struct Funcionario {
   int matricula;
   char nome[MAXTAM];
} Funcionario;

void main (){
   Funcionario f;

   printf("\nEntre com a matricula: ");
   scanf("%d", &f.matricula);

   printf("\nEntre com o nome: ");
   scanf("%s", f.nome);

   printf("\nMatricula: %d", f.matricula);
   printf("\nNome: %s", f.nome);
   printf("\n\n");
}
