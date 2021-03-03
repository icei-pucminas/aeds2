#include "pilha.h"
//=============================================================================
int main() {

    Pilha p;
    int i, x1, x2, x3;
    printf("==== PILHA FLEXIVEL ====\n");

    p = new_pilha();

    for(i=0; i < 10; i++)
        push_pilha(&p, i);

    printf("Apos inserrir os dados: \n");
    print_pilha(&p);

    x1 = pop_pilha(&p);
    x2 = pop_pilha(&p);
    x3 = pop_pilha(&p);

    printf("Apos as remocoes (%d, %d, %d) \n", x1, x2, x3);
    print_pilha(&p);

    delete_pilha(&p);

    return 0;
}