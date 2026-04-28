#include<stdio.h>
#include<stdlib.h>

typedef struct Celula{
	int elemento;
	struct Celula* sup;
	struct Celula* inf;
	struct Celula* dir;
	struct Celula* esq;
}Celula;

typedef struct Matriz{
	Celula* inicio;
	int tam;
}Matriz;

Celula* novaCelula(int x){
	Celula* nova = (Celula*) malloc(sizeof(Celula));
	nova->elemento = x;
	nova->sup = nova->inf = nova->esq = nova->dir = NULL;
	return nova;
}

Matriz* novaMatriz(int tam){
	Matriz* matriz = (Matriz*) malloc(sizeof(Matriz));
	matriz->tam = tam;
	int numero = tam*tam;
	matriz->inicio = novaCelula(numero--);
	Celula* tmp = matriz->inicio;
	for(int i=1; i < tam; i++){
		Celula* nova = novaCelula(numero--);
		tmp->dir = nova;
		nova->esq = tmp;
		tmp = nova;
	}
	Celula* tmpAnterior = matriz->inicio->dir;//tmpA=8
	Celula* tmpAnteriorP = matriz->inicio;//tmpAP=9
	for(int i=1; i<tam; i++){
		Celula* tmp = novaCelula(numero--);//6
		tmp->sup = tmpAnteriorP;//6->9
		tmpAnteriorP->inf = tmp;
		for(int j=1; j<tam; j++){
			Celula* nova = novaCelula(numero--);
			tmp->dir = nova;
			nova->esq = tmp;
			nova->sup = tmpAnterior;
			tmpAnterior->inf = nova;
			tmpAnterior = tmpAnterior->dir;
			tmp = nova;
		}
		tmpAnterior = tmpAnteriorP->inf->dir;
		tmpAnteriorP = tmpAnteriorP->inf;

	}

	return matriz;
}

Celula* getProximo(Celula* i, int linha){ 
	Celula* proximo = NULL;
	if(linha % 2 == 0){
		if(i->dir == NULL) proximo = i->inf;
		else proximo = i->dir;
	} else {
		if(i->esq == NULL) proximo = i->inf;
		else proximo = i->esq;
	}
	return proximo;
}


void mostrar(Matriz* matriz){ 
	Celula* atual = matriz->inicio;
	Celula* primeiro = matriz->inicio;
	for(int i=0; i<matriz->tam; i++){
		for(int j=0; j<matriz->tam; j++){
			printf("%d ",atual->elemento);
			atual = atual->dir;
		}
		printf("\n");
		atual = primeiro->inf;
		primeiro = primeiro->inf;
	}
}

int main(){
	Matriz* matriz = novaMatriz(3);
	mostrar(matriz);
	return 0;
}
