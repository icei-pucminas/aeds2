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

int array[MAXTAM];   // Elementos da pilha 
int n;               // Quantidade de array.


/**
 * Inicializacoes
 */
void start(){
   n = 0;
}


/**
 * Insere um elemento na primeira posicao da lista e move os demais
 * elementos para o fim da 
 * @param x int elemento a ser inserido.
 */
void inserirInicio(int x) {
   int i;

   //validar insercao
   if(n >= MAXTAM){
      printf("Erro ao inserir!");
      exit(1);
   } 

   //levar elementos para o fim do array
   for(i = n; i > 0; i--){
      array[i] = array[i-1];
   }

   array[0] = x;
   n++;
}


/**
 * Insere um elemento na ultima posicao da 
 * @param x int elemento a ser inserido.
 */
void inserirFim(int x) {

   //validar insercao
   if(n >= MAXTAM){
      printf("Erro ao inserir!");
      exit(1);
   }

   array[n] = x;
   n++;
}


/**
 * Insere um elemento em uma posicao especifica e move os demais
 * elementos para o fim da 
 * @param x int elemento a ser inserido.
 * @param pos Posicao de insercao.
 */
void inserir(int x, int pos) {
   int i;

   //validar insercao
   if(n >= MAXTAM || pos < 0 || pos > n){
      printf("Erro ao inserir!");
      exit(1);
   }

   //levar elementos para o fim do array
   for(i = n; i > pos; i--){
      array[i] = array[i-1];
   }

   array[pos] = x;
   n++;
}


/**
 * Remove um elemento da primeira posicao da lista e movimenta 
 * os demais elementos para o inicio da mesma.
 * @return resp int elemento a ser removido.
 */
int removerInicio() {
   int i, resp;

   //validar remocao
   if (n == 0) {
      printf("Erro ao remover!");
      exit(1);
   }

   resp = array[0];
   n--;

   for(i = 0; i < n; i++){
      array[i] = array[i+1];
   }

   return resp;
}


/**
 * Remove um elemento da ultima posicao da 
 * @return resp int elemento a ser removido.
 */
int removerFim() {

   //validar remocao
   if (n == 0) {
      printf("Erro ao remover!");
      exit(1);
   }

   return array[--n];
}


/**
 * Remove um elemento de uma posicao especifica da lista e 
 * movimenta os demais elementos para o inicio da mesma.
 * @param pos Posicao de remocao.
 * @return resp int elemento a ser removido.
 */
int remover(int pos) {
   int i, resp;

   //validar remocao
   if (n == 0 || pos < 0 || pos >= n) {
      printf("Erro ao remover!");
      exit(1);
   }

   resp = array[pos];
   n--;

   for(i = pos; i < n; i++){
      array[i] = array[i+1];
   }

   return resp;
}


/**
 * Mostra os array separados por espacos.
 */
void mostrar (){
   int i;

   printf("[ ");

   for(i = 0; i < n; i++){
      printf("%d ", array[i]);
   }

   printf("]\n");
}


/**
 * Procura um array e retorna se ele existe.
 * @param x int elemento a ser pesquisado.
 * @return <code>true</code> se o array existir,
 * <code>false</code> em caso contrario.
 */
bool pesquisar(int x) {
   bool retorno = false;
   int i;

   for (i = 0; i < n && retorno == false; i++) {
      retorno = (array[i] == x);
   }
   return retorno;
}


int main(int argc, char** argv){
   int x1, x2, x3;

   printf("==== LISTA ESTATICA ====\n");

   start();

   inserirInicio(1);
   inserirInicio(0);
   inserirFim(2);
   inserirFim(3);
   inserir(4, 3);
   inserir(5, 2);

   printf("Apos insercoes: ");
   mostrar();

   x1 = removerInicio();
   x2 = removerFim();
   x3 = remover(2);

   printf("Apos remocoes (%d, %d, %d): ", x1, x2, x3);
   mostrar();
}
