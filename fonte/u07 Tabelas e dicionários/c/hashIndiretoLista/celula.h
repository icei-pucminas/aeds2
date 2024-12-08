 #ifndef CELULA_H
 #define CELULA_H
 //=============================================================================
#include <stdio.h>
#include <stdlib.h>
 //=============================================================================
typedef struct Celula{
    int elemento;
    struct Celula *prox;
}Celula;
//=============================================================================
Celula* new_celula(int elemento){
    Celula *temp = (Celula*)malloc(sizeof(Celula));
    temp->elemento = elemento;
    temp->prox = NULL;
    return temp;
}
 //=============================================================================
 typedef struct CelulaDupla{
    int elemento;
    struct CelulaDupla *prox, *ant;
}CelulaDupla;
//=============================================================================
CelulaDupla* new_celula_dupla(int elemento){
    CelulaDupla *temp = (CelulaDupla*)malloc(sizeof(CelulaDupla));
    temp->elemento = elemento;
    temp->ant = NULL;
    temp->prox = NULL;
    return temp;
}
 //=============================================================================
#endif