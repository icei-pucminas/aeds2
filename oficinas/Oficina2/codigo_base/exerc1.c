#include<stdio.h>

#define MAX_EMERGENCIA 5
#define MAX_PERIODICA 5
#define MAX_BACKGROUND 30

typedef struct {
    int id ;
    int prioridade ; // 0 -10 (0 = maxima prioridade )
} Tarefa ;

typedef struct {
    Tarefa pilha[MAX_EMERGENCIA] ; // pilha de tarefas
    int n; // numero de tarefas na lista
} PilhaEmergencia ;

typedef struct {
    Tarefa fila[MAX_PERIODICA] ; // fila de tarefas
    int primeiro; // posicao do primeiro
    int ultimo; // posicao do ultimo 
} FilaPeriodica ;

typedef struct {
    Tarefa lista[MAX_BACKGROUND] ; // lista de tarefas
    int n; // numero de tarefas na lista
} ListaBackground ;

Tarefa processarTarefa(PilhaEmergencia* p, FilaPeriodica* f, ListaBackground* l){
    // TO DO: IMPLEMENTAR
    // desempilhar uma tarefa da pilha (se houver)
    // OU desinfileirar uma tarefa da fila (se houver)
    // OU retirar a tarefa mais prioritária da lista
}

void promoverTarefa(PilhaEmergencia* p, ListaBackground* l, int id){
    // TO DO: IMPLEMENTAR
    // passar a tarefa de identificador id da lista para a pilha
}

void empilharEmergencia(PilhaEmergencia* p, Tarefa t){
    // TO DO: IMPLEMENTAR
    // empilhar uma tarefa na pilha
    if(p->n >= MAX_EMERGENCIA){ // pilha ta cheia
	printf("Pilha cheia\n");
    }else{
    	p->pilha[p->n] = t;
	p->n = p->n+1;
    }
}

Tarefa desempilharEmergencia(PilhaEmergencia* p){
    // TO DO: IMPLEMENTAR
    // desempilhar uma tarefa da pilha
    if(p->n == 0){
	    printf("Pilha vazia");
	    return null;
    }else{
	Tarefa desempilhada;
	desempilhada = p->pilha[p->n];
	p->n = p->n - 1;
	return desempilhada;
    }
}

void enfileirarPeriodica(FilaPeriodica* f, Tarefa t){
    // TO DO: IMPLEMENTAR
    // enfilierar um elemento na fila
}

Tarefa desenfileirarPeriodica(FilaPeriodica* f){
    // TO DO: IMPLEMENTAR
    // desinfileirar uma tarefa da fila
}

void inserirBackground(ListaBackground* l, Tarefa t){
    // TO DO: IMPLEMENTAR
    // inserir uma tarefa na lista
}

Tarefa removerBackground(ListaBackground* l){
    // TO DO: IMPLEMENTAR
    // remover a tarefa mais prioritaria da lista
}

void imprimirEstruturas(PilhaEmergencia* p, FilaPeriodica* f, ListaBackground* l){
    // TO DO: IMPLEMENTAR
    // printar a pilha, lista e fila
}


void criarTarefa(PilhaEmergencia* p, FilaPeriodica* f, ListaBackground* l){
    Tarefa tarefa;
    printf("ID: ");
    scanf("%d", &tarefa.id);
    printf("Prioridade: ");
    scanf("%d", &tarefa.prioridade);
    printf("1-Inserir na Pilha\n2-Inserir na Fila\n3-Inserir na lista\n");
    int local;
    printf("Onde Inserir: ");
    scanf("%d", &local);
    if(local == 1) empilharEmergencia(p, tarefa);
    else if(local == 2) enfileirarPeriodica(f, tarefa);
    else inserirBackground(l, tarefa);
}

int main(){
    PilhaEmergencia pilha;
    pilha.n = 0;
    FilaPeriodica fila;
    fila.primeiro = 0;
    fila.ultimo = 0;
    ListaBackground lista;
    lista.n = 0;

    int opcao;
    printf("########\n1-Criar Tarefa\n2-Processar Tarefa\n3-Promover Tarefa\n0-Sair\n");
    printf("Entre com a opcao: ");    
    scanf("%d", &opcao);
    while(opcao != 0){
        if(opcao == 1){
            criarTarefa(&pilha, &fila, &lista);
        }else if(opcao == 2){
            Tarefa processada = processarTarefa(&pilha, &fila, &lista);
            printf("Processei tarefa %d\n", processada.id);
        }else if(opcao == 3){
            printf("Qual o ID da tarefa a ser promovida?\n");
            int id;
            scanf("%d", &id);
            promoverTarefa(&pilha, &lista, id);
        }

        imprimirEstruturas(&pilha, &fila, &lista);

        printf("########\n1-Criar Tarefa\n2-Processar Tarefa\n3-Promover Tarefa\n0-Sair\n");
        printf("Entre com a opcao: ");    
        scanf("%d", &opcao);
    }
    return 0;
}
