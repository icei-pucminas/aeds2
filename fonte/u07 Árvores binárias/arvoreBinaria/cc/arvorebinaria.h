/**
 * Arvore binaria de pesquisa
 * @author Max do Val Machado
 */

#include "no.h"

class ArvoreBinaria {
    private:
        No* raiz; // Raiz da arvore.
        bool pesquisar(int, No*);
        void caminharCentral(No*);
        void caminharPre(No*);
        void caminharPos(No*);
        void inserir(int, No* &);
        void remover(int, No* &);
        void maiorEsq(No*, No* &);

    public:
        ArvoreBinaria();
        bool pesquisar(int);
        void caminharCentral();
        void caminharPre();
        void caminharPos();
        void inserir(int);
        void remover(int);
};
