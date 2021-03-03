#include "lista_dupla.h"
//=============================================================================
int main() {

    ListaDupla l;
    int i, x1, x2, x3;
    printf("==== LISTA FLEXIVEL ====\n");

    l = new_lista_dupla();

    for(i=0; i < 5; i++)
        insert_end_dupla(&l, i);

    printf("Apos inserir os dados: \n");
    print_lista_dupla(&l);
    print_lista_dupla_inverso(&l);

    printf("Apos inserir no inicio: \n");
    insert_begin_dupla(&l, i++);
    print_lista_dupla(&l);
    print_lista_dupla_inverso(&l);

    printf("Apos inserir no final: \n");
    insert_end_dupla(&l, i++);
    print_lista_dupla(&l);
    print_lista_dupla_inverso(&l);

    printf("Apos inserir na posicao 4: \n");
    insert_at_dupla(&l, i++, 4);
    print_lista_dupla(&l);
    print_lista_dupla_inverso(&l);

    printf("Apos remover no inicio: \n");
    x1 = remove_begin_dupla(&l);
    print_lista_dupla(&l);
    print_lista_dupla_inverso(&l);

    printf("Apos remover no final: \n");
    x1 = remove_end_dupla(&l);
    print_lista_dupla(&l);
    print_lista_dupla_inverso(&l);

    printf("Apos remover na posicao 2: \n");
    x1 = remove_at_dupla(&l, 2);
    print_lista_dupla(&l);
    print_lista_dupla_inverso(&l);

    delete_lista_dupla(&l);

    return 0;
}