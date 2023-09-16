#ifndef FILA_H
#define FILA_H
//=============================================================================
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <limits.h>
#include "celula.h"
//=============================================================================
typedef struct Fila{
    struct Celula *primeiro, *ultimo;
    int size;
} Fila;
//=============================================================================
Fila new_fila(){
    Fila temp;
    temp.primeiro = temp.ultimo = new_celula(-1);
    temp.size = 0;
    return temp;
}
//=============================================================================
int size_fila(Fila *f){
    return f->size;
}
//=============================================================================
void enqueue_fila(Fila *f, int elemento){
    f->ultimo->prox = new_celula(elemento);
    f->ultimo = f->ultimo->prox;
    f->size++;
}
//=============================================================================
int dequeue_fila(Fila *f){
    
    if (f->primeiro == f->ultimo){
        printf("\nA fila esta vazia!\n");
        return INT_MIN;
    }
    
    Celula *temp = f->primeiro;
    f->primeiro = f->primeiro->prox;
    f->size--;
    free(temp);
    return f->primeiro->elemento;
}
//=============================================================================
void print_fila(Fila *f){
    Celula *i;
    printf("[");
    for (i = f->primeiro->prox; i != NULL; i = i->prox)
    {
        printf("%d, ", i->elemento);
    }
    printf("] \n");
}
//=============================================================================
void delete_fila(Fila *f){
    while(f->size > 0)
        dequeue_fila(f);
    free(f->primeiro);
}
//=============================================================================
#endif