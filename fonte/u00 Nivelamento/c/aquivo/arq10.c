#include <stdio.h>
#include <string.h>

typedef struct cliente {
   char nome[100];
   int codigo;
} cliente;

void escrever(char*);
void ler(char*);

void main(int argc, char** argv){
   escrever("teste.txt");
   ler("teste.txt");
}

void escrever(char* nomeArq){
   cliente c1, c2;
   strcat(c1.nome, "Ze da Silva");		c1.codigo = 1;
   strcat(c2.nome, "Lele da Cuca");	c2.codigo = 11; 
   FILE *p = fopen(nomeArq, "ab");
   fwrite(&c1, sizeof(cliente), 1, p);
   fwrite(&c2, sizeof(cliente), 1, p);
   fclose(p);
}  

void ler(char* nomeArq){
   cliente c1, c2;
   FILE *p = fopen(nomeArq, "rb");
   fread(&c1, sizeof(cliente), 1, p);
   fread(&c2, sizeof(cliente), 1, p);
   fclose(p); 
   printf("%s -- %d\n", c1.nome, c1.codigo);
   printf("%s -- %d\n", c2.nome, c2.codigo);
}
