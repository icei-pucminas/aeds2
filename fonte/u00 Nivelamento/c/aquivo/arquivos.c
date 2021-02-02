#include <stdio.h>
#include <stdlib.h>
#include <string.h>
//=============================================================================
void gravar_arquivo_texto(){

    // ABRIR O ARQUIVO
    FILE *arq = fopen("arquivo.txt", "w");

    if(arq == NULL){
        printf("Erro ao tentar abrir o arquivo!\n");
        return;
    }

    // ESCREVER NO ARQUIVO
    fprintf(arq, "%s\t", "Algoritmos");
    fprintf(arq, "%d\t", 1);
    fprintf(arq, "%f\t", 5.3);
    fprintf(arq, "%c\t", 'X');
        
    // FECHA O ARQUIVO
    fclose(arq);
}
//=============================================================================
void ler_texto_texto(){

    char texto[12], caracter;
    int inteiro;
    float real;

    // ABRIR O ARQUIVO
    FILE *arq = fopen("arquivo.txt", "r");

    if(arq == NULL){
        printf("Erro ao tentar abrir o arquivo!\n");
        return;
    }

    // LE O ARQUIVO
    fscanf(arq, "%99[^\t]\t", &texto); // LER STRING
    fscanf(arq, "%d\t", &inteiro);
    fscanf(arq, "%f\t", &real);
    fscanf(arq, "%c\t", &caracter);
        
    // FECHA O ARQUIVO
    fclose(arq);  

    printf("texto: %s\n", texto);  
    printf("inteiro: %d\n", inteiro); 
    printf("real: %f\n", real); 
    printf("caracter: %c\n", caracter); 
}
//=============================================================================
void gravar_arquivo_binario(){

    char texto[12] = "Algoritmos", caracter = 'X';
    int inteiro = 1;
    float real = 5.3;

    // ABRIR O ARQUIVO
    FILE *arq = fopen("arquivo.bin", "wb");

    if(arq == NULL){
        printf("Erro ao tentar abrir o arquivo!\n");
        return;
    }

    // ESCREVER NO ARQUIVO
    fwrite(&texto, sizeof(char), 12, arq);
    fwrite(&inteiro, sizeof(int), 1, arq);
    fwrite(&real, sizeof(float), 1, arq);
    fwrite(&caracter,sizeof(char), 1, arq);
        
    // FECHA O ARQUIVO
    fclose(arq);
}
//=============================================================================
void ler_texto_binario(){

    char texto[12], caracter;
    int inteiro;
    float real;

    // ABRIR O ARQUIVO
    FILE *arq = fopen("arquivo.bin", "rb");

    if(arq == NULL){
        printf("Erro ao tentar abrir o arquivo!\n");
        return;
    }

    // LE O ARQUIVO
    fread(&texto, sizeof(char), 12, arq);
    fread(&inteiro, sizeof(int), 1, arq);
    fread(&real, sizeof(float), 1, arq);
    fread(&caracter,sizeof(char), 1, arq);
        
    // FECHA O ARQUIVO
    fclose(arq);  

    printf("texto: %s\n", texto);  
    printf("inteiro: %d\n", inteiro); 
    printf("real: %f\n", real); 
    printf("caracter: %c\n", caracter); 
}
//=============================================================================

int main(){

    gravar_arquivo_texto();
    ler_texto_texto();

    gravar_arquivo_binario();
    ler_texto_binario();

    return 1;
}