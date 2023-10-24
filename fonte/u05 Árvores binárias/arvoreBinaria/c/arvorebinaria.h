/**
 * Arvore binaria de pesquisa
 * @author Max do Val Machado
 */

#include "no.h"
#define bool   short
#define true   1
#define false  0

bool pesquisarRec(int, No*);
void caminharCentralRec(No*);
void caminharPreRec(No*);
void caminharPosRec(No*);
void inserirRec(int, No**);
void removerRec(int, No**);
void maiorEsq(No**, No**);

void start();
bool pesquisar(int);
void caminharCentral();
void caminharPre();
void caminharPos();
void inserir(int);
void remover(int);
