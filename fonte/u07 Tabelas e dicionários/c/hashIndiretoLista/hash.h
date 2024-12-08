/**
* Hash Indireto com Lista
* @author Davi Cândido de almeida
* @GitHub https://github.com/Davikandido
* @version 2 12/2024
*/

#ifndef HASH_H
#define HASH_H
//=============================================================================
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <limits.h>
#include "celula.h"
#include "lista.h"
//=============================================================================

// ------------------------------------ Hash Indireto com Lista -------------------------------------------- //

Lista **tabela;
int tamanho;

 #define NULO new_celula(INT_MIN);

 void hashInidiretoLista(int n){
    tamanho = n;
    tabela = (Lista**) malloc(tamanho* sizeof(Lista*));
    for(int i = 0; i < tamanho; i++){
        *tabela[i] = new_lista();
    }
}
//=============================================================================
void new_hashInidiretoLista(){
     hashInidiretoLista(7);
}
//=============================================================================
int h(int elemento){
    return elemento % tamanho;
}
//=============================================================================
int pesquisar_hash(int elemento){
    int pos = h(elemento);
    bool resp = pesquisar_lista(tabela[pos], elemento);
    return resp ? pos : -1;
}
//=============================================================================
void inserirInicio(int elemento) {
      int pos = h(elemento);
      insert_begin(tabela[pos], elemento);
   }
//=============================================================================
void insert_hash(int num){
    int pos = h(num);
    insert_begin(tabela[pos], num);
}
//=============================================================================
int remover_hash(int elemento) {
      int resp = INT_MIN;
      if (pesquisar_hash(elemento) == false) {
         exit(0);
      } else {
         int pos = h(elemento);
         resp = remover(tabela[pos], elemento);
      }
      return resp;
   }

// ------------------------------------ END - Hash Indireto com Lista -------------------------------------------- //

#endif