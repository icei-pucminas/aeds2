/*
 * Palíndromo em C - Refaça a questão anterior na linguagem C.
 * Palíndromo - Crie um método iterativo que recebe uma string 
 * como parâmetro e retorna true se essa ́e um “Palíndromo”. 
 * Na saída padrão, para cada linha de entrada, escreva uma linha
 * de saída com SIM/NÃO indicando se a linha ́e um palíndromo. 
 * Destaca-se que uma linha de entrada pode ter caracteres não letras.
*/
#include <stdbool.h>
#include <stdio.h>
#include <string.h>
#include <locale.h>

bool isPalindrome(char sentence[]) {
    /*
    * An boolean function that calculates if a 
    * sentence is a palindrome or not
    */
    int sentenceSize = strlen(sentence);
    printf("%d\n", sentenceSize);

    char invertedSentence[sentenceSize]; 

    printf("%d\n", strlen(invertedSentence));

    for (int index = sentenceSize - 1; index >= 0; index--) {
        char letter = sentence[index];
        //printf("%c\n", letter);
        //printf("%d\n", index);
        invertedSentence[sentenceSize - 1 - index] = letter;
    }

    printf("sentence: %s\n", sentence);
    printf("inverted sentence: %s\n", invertedSentence);

    int comparation = strcmp(sentence, invertedSentence);

    return comparation == 0 ? true : false;
}

int main() {
    /*
    * Main fuction that calls isPalindrome function,
    * and returns "SIM" if the sentence sent is a palindrome.
    */

    // Configurar a localidade para usar UTF-8
    setlocale(LC_ALL, "pt_BR.UTF-8");

    char line[1000];

    fgets(line, sizeof(line), stdin);
    line[strcspn(line, "\n")] = '\0';

    while (strcmp(line, "FIM") != 0) {
        printf((isPalindrome(line)) ? "SIM\n" : "NAO\n");

        fgets(line, sizeof(line), stdin);
        line[strcspn(line, "\n")] = '\0';   
    }

    return 0;
}