#ifndef PILHA_H
#define PILHA_H
//=============================================================================
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <limits.h>
#include "celula.h"
//=============================================================================
typedef struct Pilha{
    struct Celula *topo;
    int size;
} Pilha;
//=============================================================================
Pilha new_pilha(){
    Pilha temp;
    temp.topo = NULL;
    temp.size = 0;
    return temp;
}
//=============================================================================
int size_pilha(Pilha *p){
    return p->size;
}
//=============================================================================
void push_pilha(Pilha *p, int elemento){
    Celula *temp = new_celula(elemento);
    temp->prox = p->topo;
    p->topo = temp;
    p->size++;
}
//=============================================================================
int pop_pilha(Pilha *p){
    if (p->topo == NULL){
        printf("\nA pilha esta vazia!\n");
        return INT_MIN;
    }
    int elemento = p->topo->elemento;
    Celula *temp = p->topo;
    p->topo = p->topo->prox;
    p->size--;
    free(temp);
    return elemento;
}
//=============================================================================
void print_pilha(Pilha *p){
    Celula *i;
    printf("[");
    for (i = p->topo; i != NULL; i = i->prox)
    {
        printf("%d, ", i->elemento);
    }
    printf("] \n");
}
//=============================================================================
void delete_pilha(Pilha *p){
    while(p->size > 0)
        pop_pilha(p);
}
//=============================================================================
#endif