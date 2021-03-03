#ifndef LISTA_H
#define LISTA_H
//=============================================================================
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <limits.h>
#include "celula.h"
//=============================================================================
typedef struct Lista{
    struct Celula *primeiro, *ultimo;
    int size;
} Lista;
//=============================================================================
Lista new_lista(){
    Lista temp;
    temp.primeiro = temp.ultimo = new_celula(-1);
    temp.size = 0;
    return temp;
}
//=============================================================================
int size_lista(Lista *l){
    return l->size;
}
//=============================================================================
void insert_begin(Lista *l, int elemento){
    
    Celula *temp = new_celula(-1);
    temp->prox = l->primeiro;

    l->primeiro->elemento = elemento;    
    l->primeiro = temp;
    l->size++;
}
//=============================================================================
void insert_end(Lista *l, int elemento){    
    l->ultimo->prox = new_celula(elemento);
    l->ultimo = l->ultimo->prox;
    l->size++;
}
//=============================================================================
void insert_at(Lista *l, int elemento, int pos){
    
    if(pos < 0 || pos > l->size)
        printf("Erro ao tentar inserir na posicao (%d/ tamanho = %d) invalida!", pos, l->size);
    else if (pos == 0)
        insert_begin(l, elemento);
    else if (pos == l->size)
        insert_end(l, elemento);
    else{
        
        Celula *ant = l->primeiro;
        for(int i=0; i<pos;i++) 
            ant = ant->prox;
            
        Celula *temp = new_celula(elemento);  
        temp->prox = ant->prox;
        ant->prox = temp;
        l->size++;
    }
}
//=============================================================================
int remove_at(Lista *l, int pos){

    if(l->primeiro == l->ultimo){
        printf("\nA lista esta vazia!\n");
        return INT_MIN;
    }else if(pos < 0 || pos > l->size-1)
        printf("Erro ao tentar remover item da posicao (%d/ tamanho = %d) invalida!", pos, l->size);
    else{
        
        Celula *ant = l->primeiro;
        for(int i=0; i<pos;i++) 
            ant = ant->prox;
            
        Celula *temp = ant->prox;  
        int elemento = temp->elemento;

        ant->prox = temp->prox;
        free(temp);       

        if(pos == l->size-1)
            l->ultimo = ant;

        l->size--;

        return elemento;
    }
}
//=============================================================================
int remove_begin(Lista *l){
    return remove_at(l, 0);
}
//=============================================================================
int remove_end(Lista *l){
    return remove_at(l, l->size-1);
}
//=============================================================================
bool pesquisar_lista(Lista *l, int elemento){
    Celula *i;
    for (i = l->primeiro->prox; i != NULL; i = i->prox)
        if(i->elemento == elemento)
            return true;
    return false;
}
//=============================================================================
void print_lista(Lista *l){
    Celula *i;
    printf("[");
    for (i = l->primeiro->prox; i != NULL; i = i->prox)
    {
        printf("%d, ", i->elemento);
    }
    printf("] \n");
}
//=============================================================================
void delete_lista(Lista *l){
    while(l->size > 0)
        remove_at(l,0);
    free(l->primeiro);
}
//=============================================================================
#endif