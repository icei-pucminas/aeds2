#include <stdio.h>
#include <string.h>
#include <stdbool.h>

bool isPalindrome(char *stringLine) {
    /**
    * This function receives a string and returns true if it is a palindrome
    * and false otherwise.
    */
    bool isPalindrome = true;
    int stringLength = strlen(stringLine);

    for (int index = 0; index < stringLength / 2; index++) {
        if (stringLine[index] != stringLine[stringLength - 1 - index]) {
            isPalindrome = false;
            
            return isPalindrome;
        }
    }

    return isPalindrome;
}

int main() {
    /*
    * This function reads a string from the input and checks if it is a palindrome.
    */
    char stringLine[1000];
    
    fgets(stringLine, sizeof(stringLine), stdin);
    stringLine[strcspn(stringLine, "\n")] = '\0'; 

    while (strcmp(stringLine, "FIM") != 0) {
        if (isPalindrome(stringLine)) {
            printf("SIM\n");
        } else {
            printf("NAO\n");
        }

        fgets(stringLine, sizeof(stringLine), stdin);
        stringLine[strcspn(stringLine, "\n")] = '\0';
    }

    return 0;
}
