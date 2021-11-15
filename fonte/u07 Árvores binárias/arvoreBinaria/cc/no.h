/**
 * No da arvore binaria
 * @author Max do Val Machado
 */
#include <iostream>

using namespace std;

class No {
    public:
        int elemento; // Conteudo do no.
        No *esq, *dir;  // Filhos da esq e dir.
        No(int);
};
