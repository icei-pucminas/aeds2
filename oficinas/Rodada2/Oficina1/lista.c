#include<stdio.h>
#include<stdlib.h>

typedef struct Celula{
	int valor;
	struct Celula* prox;
}Celula;

typedef struct Lista{
	Celula* primeiro;
	Celula* ultimo;
}Lista;

Lista* lista;

void mostrar(){
	Celula* tmp = lista->primeiro;
	printf("[");
	while(tmp!=NULL){
		printf("%d ,", tmp->valor);
		tmp = tmp->prox;
	}
	printf("]\n");
}

void start(){
	lista = (Lista*) malloc(sizeof(Lista));
	lista->primeiro = NULL;
	lista->ultimo = NULL;
}

Celula* criarCelula(int valor){
	Celula* nova = (Celula*) malloc(sizeof(Celula));
	nova->valor = valor;
	nova->prox = NULL;
	return nova;
}

void inserirInicio(int x){
	printf("Inserindo %d no inicio\n", x);
	Celula *nova = criarCelula(x);
	if(lista->primeiro == NULL){
		lista->primeiro = nova;
		lista->ultimo = nova;
	}else{
		nova->prox = lista->primeiro;
		lista->primeiro = nova;
	}

	mostrar();
}

void inserirFim(int x){
	printf("Inserindo %d no fim\n", x);
	Celula *nova = criarCelula(x);
	lista->ultimo->prox = nova;
	lista->ultimo = nova;  

	mostrar();
}

void inserir(int x, int pos){
	printf("Inserindo %d na pos %d\n", x, pos);
	Celula *nova = criarCelula(x);
	int cont = 0;
	Celula* tmp = lista->primeiro;
	while(cont < pos-1){
		cont++;
		tmp = tmp->prox;
	}
	nova->prox = tmp->prox;
	tmp->prox = nova;
	mostrar();
}

int removerPrimeiro(){
	printf("Removendo primeiro\n");
	Celula* tmp = lista->primeiro;
	lista->primeiro = tmp->prox;
	int valor = tmp->valor;
	free(tmp);

	mostrar();
	return valor;
}

int removerUltimo(){
	printf("Removendo ultimo\n");
	Celula* tmp = lista->primeiro;
	while(tmp->prox != lista->ultimo){
		tmp = tmp->prox;
	}
	Celula* antigoUltimo = lista->ultimo;
	lista->ultimo = tmp;
	lista->ultimo->prox = NULL;
	int valor = antigoUltimo->valor;
	free(antigoUltimo);

	mostrar();
	return valor;
}

int remover(int pos){
	printf("Removendo pos %d\n", pos);
	int cont = 0;
	Celula* tmp = lista->primeiro;
	while(cont < pos-1){
		cont++;
		tmp = tmp->prox;
	}
	Celula* remover = tmp->prox;
	int valor = remover->valor;
	tmp->prox = remover->prox;
	free(remover);

	mostrar();
	return valor;
}

int main(){
	start();
	inserirInicio(3);
	inserirInicio(2);
	inserirFim(1);
	inserirFim(4);
	inserir(5,2);
	inserir(6,2);
	inserir(7,2);
	inserir(8,2);
	removerPrimeiro();
	removerUltimo();
	removerUltimo();
	remover(2);
	remover(2);
	mostrar();
	free(lista);
	return 0;
}
