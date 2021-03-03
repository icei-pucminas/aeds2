#include "lista.h"
//=============================================================================
int main() {

    Lista l;
    int i, x1, x2, x3;
    printf("==== LISTA FLEXIVEL ====\n");

    l = new_lista();

    for(i=0; i < 5; i++)
        insert_end(&l, i);

    printf("Apos inserir os dados: \n");
    print_lista(&l);

    printf("Apos inserir no inicio: \n");
    insert_begin(&l, i++);
    print_lista(&l);

    printf("Apos inserir no final: \n");
    insert_end(&l, i++);
    print_lista(&l);

    printf("Apos inserir na posicao 4: \n");
    insert_at(&l, i++, 4);
    print_lista(&l);

    printf("Apos remover no inicio: \n");
    x1 = remove_begin(&l);
    print_lista(&l);

    printf("Apos remover no final: \n");
    x1 = remove_end(&l);
    print_lista(&l);

    printf("Apos remover na posicao 2: \n");
    x1 = remove_at(&l, 2);
    print_lista(&l);

    delete_lista(&l);

    return 0;
}