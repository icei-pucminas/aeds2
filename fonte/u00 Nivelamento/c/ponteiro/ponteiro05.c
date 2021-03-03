#include <stdio.h>
#include <stdlib.h>

#define MAXTAM 10

typedef struct Cliente {
   int codigo;
   char nome[MAXTAM];
} Cliente;


int main (int argc, char** argv){
   char* p1 = (char*) malloc (sizeof(char));
   int* p2 = (int*) malloc (sizeof(int));
   float* p3 = (float*) malloc (sizeof(float));
   Cliente* p4 = (Cliente*) malloc (sizeof(Cliente));
   int* p5 = (int*) malloc (MAXTAM * sizeof (int));
   Cliente* p6 =(Cliente*) malloc (MAXTAM * sizeof (Cliente));

   free(p1);
   free(p2);
   free(p3);
   free(p4);
   free(p5);
   free(p6);
}
