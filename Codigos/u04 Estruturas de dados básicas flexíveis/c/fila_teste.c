#include "fila.h"
//=============================================================================
int main() {

    Fila f;
    int i, x1, x2, x3;
    printf("==== FILA FLEXIVEL ====\n");

    f = new_fila();

    for(i=0; i < 10; i++)
        enqueue_fila(&f, i);

    printf("Apos inserrir os dados: \n");
    print_fila(&f);

    x1 = dequeue_fila(&f);
    x2 = dequeue_fila(&f);
    x3 = dequeue_fila(&f);

    printf("Apos as remocoes (%d, %d, %d) \n", x1, x2, x3);
    print_fila(&f);

    delete_fila(&f);

    return 0;
}