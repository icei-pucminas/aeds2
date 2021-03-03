/**
 * Lista dupla dinamica
 * @author Max do Val Machado
 * @version 2 01/2015
 */
#include <stdio.h>
#include <stdlib.h>
#include <err.h>

#define bool   short
#define true   1
#define false  0

//TIPO CELULA ===================================================================
typedef struct CelulaDupla {
	int elemento;        // Elemento inserido na celula.
	struct CelulaDupla* prox; // Aponta a celula prox.
   struct CelulaDupla* ant;  // Aponta a celula anterior.
} CelulaDupla;

CelulaDupla* novaCelulaDupla(int elemento) {
   CelulaDupla* nova = (CelulaDupla*) malloc(sizeof(CelulaDupla));
   nova->elemento = elemento;
   nova->ant = nova->prox = NULL;
   return nova;
}

//LISTA PROPRIAMENTE DITA =======================================================
CelulaDupla* primeiro;
CelulaDupla* ultimo;


/**
 * Cria uma lista dupla sem elementos (somente no cabeca).
 */
void start () {
   primeiro = novaCelulaDupla(-1);
   ultimo = primeiro;
}


/**
 * Insere um elemento na primeira posicao da lista.
 * @param x int elemento a ser inserido.
 */
void inserirInicio(int x) {
   CelulaDupla* tmp = novaCelulaDupla(x);

   tmp->ant = primeiro;
   tmp->prox = primeiro->prox;
   primeiro->prox = tmp;
   if (primeiro == ultimo) {                    
      ultimo = tmp;
   } else {
      tmp->prox->ant = tmp;
   }
   tmp = NULL;
}


/**
 * Insere um elemento na ultima posicao da lista.
 * @param x int elemento a ser inserido.
 */
void inserirFim(int x) {
   ultimo->prox = novaCelulaDupla(x);
   ultimo->prox->ant = ultimo;
   ultimo = ultimo->prox;
}


/**
 * Remove um elemento da primeira posicao da lista.
 * @return resp int elemento a ser removido.
 */
int removerInicio() {
   if (primeiro == ultimo) {
      errx(1, "Erro ao remover (vazia)!");
   }

   CelulaDupla* tmp = primeiro;
   primeiro = primeiro->prox;
   int resp = primeiro->elemento;
   tmp->prox = primeiro->ant = NULL;
   free(tmp);
   tmp = NULL;
   return resp;
}


/**
 * Remove um elemento da ultima posicao da lista.
 * @return resp int elemento a ser removido.
 */
int removerFim() {
   if (primeiro == ultimo) {
      errx(1, "Erro ao remover (vazia)!");
   } 
   int resp = ultimo->elemento;
   ultimo = ultimo->ant;
   ultimo->prox->ant = NULL;
   free(ultimo->prox);
   ultimo->prox = NULL;
   return resp;
}


/**
 *  Calcula e retorna o tamanho, em numero de elementos, da lista.
 *  @return resp int tamanho
 */
int tamanho() {
   int tamanho = 0; 
   CelulaDupla* i;
   for(i = primeiro; i != ultimo; i = i->prox, tamanho++);
   return tamanho;
}


/**
 * Insere um elemento em uma posicao especifica considerando que o 
 * primeiro elemento valido esta na posicao 0.
 * @param x int elemento a ser inserido.
 * @param pos int posicao da insercao.
 * @throws Exception Se <code>posicao</code> invalida.
 */
void inserir(int x, int pos) {

   int tam = tamanho();

   if(pos < 0 || pos > tam){
      errx(1, "Erro ao remover (posicao %d/%d invalida!", pos, tam);
   } else if (pos == 0){
      inserirInicio(x);
   } else if (pos == tam){
      inserirFim(x);
   } else {
      // Caminhar ate a posicao anterior a insercao
      CelulaDupla* i = primeiro;
      int j;
      for(j = 0; j < pos; j++, i = i->prox);

      CelulaDupla* tmp = novaCelulaDupla(x);
      tmp->ant = i;
      tmp->prox = i->prox;
      tmp->ant->prox = tmp->prox->ant = tmp;
      tmp = i = NULL;
   }
}


/**
 * Remove um elemento de uma posicao especifica da lista
 * considerando que o primeiro elemento valido esta na posicao 0.
 * @param posicao Meio da remocao.
 * @return resp int elemento a ser removido.
 * @throws Exception Se <code>posicao</code> invalida.
 */
int remover(int pos) {
   int resp;
   int tam = tamanho();

   if (primeiro == ultimo){
      errx(1, "Erro ao remover (vazia)!");
   } else if(pos < 0 || pos >= tam){
      errx(1, "Erro ao remover (posicao %d/%d invalida!", pos, tam);
   } else if (pos == 0){
      resp = removerInicio();
   } else if (pos == tam - 1){
      resp = removerFim();
   } else {
      // Caminhar ate a posicao anterior a insercao
      CelulaDupla* i = primeiro->prox;
      int j;
      for(j = 0; j < pos; j++, i = i->prox);

      i->ant->prox = i->prox;
      i->prox->ant = i->ant;
      resp = i->elemento;
      i->prox = i->ant = NULL;
      free(i);
      i = NULL;
   }

   return resp;
}


/**
 * Mostra os elementos da lista separados por espacos.
 */
void mostrar() {
   CelulaDupla* i;
   printf("[ ");
   for (i = primeiro->prox; i != NULL; i = i->prox) {
      printf("%d ", i->elemento);
   }
   printf("] \n");
}


/**
 * Mostra os elementos da lista de forma invertida 
 * e separados por espacos.
 */
void mostrarInverso() {
   printf("[ ");
   CelulaDupla* i;
   for (i = ultimo; i != primeiro; i = i->ant){
      printf("%d ", i->elemento);
   }
   printf("] \n"); // Termina de mostrar.
}


/**
 * Procura um elemento e retorna se ele existe.
 * @param x Elemento a pesquisar.
 * @return <code>true</code> se o elemento existir,
 * <code>false</code> em caso contrario.
 */
bool pesquisar(int x) {
   bool resp = false;
   CelulaDupla* i;

   for (i = primeiro->prox; i != NULL; i = i->prox) {
      if(i->elemento == x){
         resp = true;
         i = ultimo;
      }
   }
   return resp;
}


int main(int argc, char** argv) {
   start();

   printf("LISTA DINAMICA DUPLAMENTE ENCADEADA\n\n");

   inserirInicio(2);
   inserirInicio(1);
   inserirFim(5);
   inserirFim(6);
   inserir(3, 2);
   inserir(4, 3);
   inserir(7, 6);
   inserir(0, 0);
   inserirFim(8);
   inserirFim(9);

   printf("Apos insercoes: ");
   mostrar();
   mostrarInverso();

   remover(3);
   remover(2);
   removerFim();
   removerInicio();
   remover(0);
   remover(4);

   printf("Apos remocoes: ");
   mostrar();
   mostrarInverso();
   return 0;
}
