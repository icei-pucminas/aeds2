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
#include <wchar.h>

bool isPalindrome(wchar_t sentence[]) {
    /*
    * An boolean function that calculates if a 
    * sentence is a palindrome or not
    */
   int left = 0;
   int right = strlen(sentence) - 1;

   while (left < right) {
       printf("left: %c\n", sentence[left]);
       printf("right: %c\n", sentence[right]);
       if ((unsigned char)sentence[left] != (unsigned char)sentence[right]) {
           return false;
       }
       left++;
       right--;
   }

   return true;
}

int main() {
    /*
    * Main fuction that calls isPalindrome function,
    * and returns "SIM" if the sentence sent is a palindrome.
    */

    // Configurar a localidade para usar UTF-8
    setlocale(LC_ALL, "pt_BR.UTF-8");

    char line[1000];

    while (fgets(line, sizeof(line), stdin) != NULL) {
        line[strcspn(line, "\n")] = '\0'; // Remove o '\n'

        if (strcmp(line, "FIM") == 0) break;

        printf("%s\n", isPalindrome(line) ? "SIM" : "NAO");
    }

    return 0;
}