/**
 * Lista estatica
 * @author Max do Val Machado
 * @version 2 01/2015
 */
#include <stdio.h>
#include <stdlib.h>

#define MAXTAM    6
#define bool      short
#define true      1
#define false     0

int array[MAXTAM+1];   // Elementos da pilha 
int primeiro;          // Remove do indice "primeiro".
int ultimo;             // Insere no indice "ultimo".


/**
 * Inicializacoes
 */
void start(){
   primeiro = ultimo = 0;
}


/**
 * Insere um elemento na ultima posicao da 
 * @param x int elemento a ser inserido.
 * @Se a fila estiver cheia.
 */
void inserir(int x) {

   //validar insercao
   if (((ultimo + 1) % MAXTAM) == primeiro) {
      printf("Erro ao inserir!");
      exit(1);
   }

   array[ultimo] = x;
   ultimo = (ultimo + 1) % MAXTAM;
}


/**
 * Remove um elemento da primeira posicao da fila e movimenta 
 * os demais elementos para o primeiro da mesma.
 * @return resp int elemento a ser removido.
 * @Se a fila estiver vazia.
 */
int remover() {

   //validar remocao
   if (primeiro == ultimo) {
      printf("Erro ao remover!");
      exit(1);
   }

   int resp = array[primeiro];
   primeiro = (primeiro + 1) % MAXTAM;
   return resp;
}


/**
 * Mostra os array separados por espacos.
 */
void mostrar (){
   int i;
   printf("\n[");

   for(i = primeiro; i != ultimo; i = ((i + 1) % MAXTAM)) {
      printf(" %d", array[i]);
   }

   printf(" ]");
}


/**
 * Retorna um bool indicando se a fila esta vazia
 * @return bool indicando se a fila esta vazia
 */
bool isVazia() {
   return (primeiro == ultimo); 
}


int main(int argc, char** argv){
   int x1, x2, x3;
   printf("\n==== FILA ESTATICA ====");

   inserir(5);
   inserir(7);
   inserir(8);
   inserir(9);

   printf("\nApos insercoes(5, 7, 8, 9): ");
   mostrar();

   x1 = remover();
   x2 = remover();

   printf("\nApos remocoes (%d, %d):", x1, x2);
   mostrar();

   inserir(3);
   inserir(4);


   printf("\nApos insercoes(3, 4): ");
   mostrar();

   x1 = remover();
   x2 = remover();
   x3 = remover();

   printf("\nApos remocoes (%d, %d, %d):", x1, x2, x3);
   mostrar();

   inserir(4);
   inserir(5);

   printf("\nApos insercoes(4, 5): ");
   mostrar();

   x1 = remover();
   x2 = remover();

   printf("\nApos remocoes (%d, %d):", x1, x2);
   mostrar();

   inserir(6);
   inserir(7);

   printf("\nApos insercoes(6, 7): ");
   mostrar();

   x1 = remover();

   printf("\nApos remocao (%d):", x1);
   mostrar();
}
