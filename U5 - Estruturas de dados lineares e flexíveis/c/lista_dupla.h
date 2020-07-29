#ifndef LISTADUPLA_H
#define LISTADUPLA_H
//=============================================================================
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <limits.h>
#include "celula.h"
//=============================================================================
typedef struct ListaDupla{
    struct CelulaDupla *primeiro, *ultimo;
    int size;
} ListaDupla;
//=============================================================================
ListaDupla new_lista_dupla(){
    ListaDupla temp;
    temp.primeiro = temp.ultimo = new_celula_dupla(-1);
    temp.size = 0;
    return temp;
}
//=============================================================================
int size_lista_dupla(ListaDupla *l){
    return l->size;
}
//=============================================================================
void insert_begin_dupla(ListaDupla *l, int elemento){
    
    CelulaDupla *temp = new_celula_dupla(-1);
    temp->prox = l->primeiro;

    l->primeiro->elemento = elemento; 
    l->primeiro->ant = temp;   
    l->primeiro = temp;
    l->size++;
}
//=============================================================================
void insert_end_dupla(ListaDupla *l, int elemento){    
    l->ultimo->prox = new_celula_dupla(elemento);
    l->ultimo->prox->ant = l->ultimo;
    l->ultimo = l->ultimo->prox;
    l->size++;
}
//=============================================================================
void insert_at_dupla(ListaDupla *l, int elemento, int pos){
    
    if(pos < 0 || pos > l->size)
        printf("Erro ao tentar inserir na posicao (%d/ tamanho = %d) invalida!", pos, l->size);
    else if (pos == 0)
        insert_begin_dupla(l, elemento);
    else if (pos == l->size)
        insert_end_dupla(l, elemento);
    else{
        
        CelulaDupla *ant = l->primeiro;
        for(int i=0; i<pos;i++) 
            ant = ant->prox;
            
        CelulaDupla *temp = new_celula_dupla(elemento);  
        temp->prox = ant->prox;
        temp->prox->ant = temp;
        temp->ant = ant;
        ant->prox = temp;
        l->size++;
    }
}
//=============================================================================
int remove_end_dupla(ListaDupla *l){

    if(l->primeiro == l->ultimo){
        printf("\nA lista esta vazia!\n");
        return INT_MIN;
    }
    
    CelulaDupla *temp = l->ultimo;
    int elemento = temp->elemento;

    l->ultimo = l->ultimo->ant;
    l->ultimo->prox = NULL;
    l->size--;

    free(temp);
    
    return elemento;
}
//=============================================================================
int remove_at_dupla(ListaDupla *l, int pos){

    if(l->primeiro == l->ultimo){
        printf("\nA lista esta vazia!\n");
        return INT_MIN;
    }else if(pos < 0 || pos > l->size-1)
        printf("Erro ao tentar remover item da posicao (%d/ tamanho = %d) invalida!", pos, l->size);
    else if(pos == l->size-1)
        remove_end_dupla(l);
    else{
        
        CelulaDupla *ant = l->primeiro;
        for(int i=0; i<pos;i++) 
            ant = ant->prox;
            
        CelulaDupla *temp = ant->prox;  
        int elemento = temp->elemento;

        temp->prox->ant = ant;
        ant->prox = temp->prox;
        free(temp);       

        l->size--;

        return elemento;
    }
}
//=============================================================================
int remove_begin_dupla(ListaDupla *l){
    return remove_at_dupla(l, 0);
}
//=============================================================================
bool pesquisar_lista_dupla(ListaDupla *l, int elemento){
    CelulaDupla *i;
    for (i = l->primeiro->prox; i != NULL; i = i->prox)
        if(i->elemento == elemento)
            return true;
    return false;
}
//=============================================================================
void print_lista_dupla(ListaDupla *l){
    CelulaDupla *i;
    printf("[");
    for (i = l->primeiro->prox; i != NULL; i = i->prox)
    {
        printf("%d, ", i->elemento);
    }
    printf("] \n");
}
//=============================================================================
void print_lista_dupla_inverso(ListaDupla *l){
    CelulaDupla *i;
    printf("[");
    for (i = l->ultimo; i != l->primeiro; i = i->ant)
    {
        printf("%d, ", i->elemento);
    }
    printf("] \n");
}
//=============================================================================
void delete_lista_dupla(ListaDupla *l){
    while(l->size > 0)
        remove_at_dupla(l,0);
    free(l->primeiro);
}
//=============================================================================
#endif