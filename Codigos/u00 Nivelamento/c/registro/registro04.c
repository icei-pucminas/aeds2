#include <stdio.h>

#define MAXTAM   100

struct Funcionario {
   int matricula;
   char nome[MAXTAM];
};

typedef struct Funcionario Funcionario;

void main (){
   Funcionario vet[MAXTAM];
   int n = 3;

   for(int i = 0; i < n; i++){
      printf("\nEntre com a matricula do funcionario %d: ", (i+1));
      scanf("%d", &vet[i].matricula);

      printf("\nEntre com o nome do funcionario %d: ", (i+1));
      scanf("%s", vet[i].nome);
   }

   for(int i = 0; i < n; i++){
      printf("\nMatricula do funcionario %d: %d", (i+1), vet[i].matricula);
      printf("\nNome do funcionario %d: %s\n", (i+1), vet[i].nome);
   }
   printf("\n\n");
}
