/**
 * @author: Thiago de Campos Ribeiro Nolasco
*/


// Biblioteca utilizada:
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define true 1;
#define false 0;

// Prototipação:
int isFim(char s[]);
const char* isVogal(char s[]);
const char* isConsoante(char s[]);
const char* isInt(char s[]);
const char* isFloat(char s[]);

int main(void){
	
	// data declaration
	char str[1000], returned[3], result[16];
	int pos = 0;

	// CAN BE USED INSTED OF SCANF("%[^\n]"...):
	/*fgets(str, 1000, stdin);
	setbuf(stdin, NULL);
	if(str[strlen(str) - 1] == '\n'){
		str[strlen(str) - 1] = '\0';
	}*/
	
	scanf("%[^\n]", str);
	getchar();
	while(!(isFim(str))){
		

		printf("%s %s %s %s\n", isVogal(str), isConsoante(str), isInt(str), isFloat(str));
		scanf("%[^\n]", str);
		getchar();	
	}

	// Return without errors
	return 0;

}// ending main

// Checks if the received string is equals to "FIM"
int isFim(char s[]){
	return (strlen(s) == 3 && s[0] == 'F' && s[1] == 'I' && s[2] == 'M');
}// ending isFim

// Checks if the received string has only vowels
const char* isVogal(char s[]){
	for(int i = 0; i < strlen(s); i++){
		if((s[i] != 65) && (s[i] != 69) && (s[i] != 73) && (s[i] != 79) && (s[i] != 85) && (s[i] != 97) && (s[i] != 101) && (s[i] != 105) && (s[i] != 111) && (s[i] != 117)){
			return "NAO";		
		}
	}
	return "SIM";
}// ending isVogal

// Checks if the received string has 
const char* isConsoante(char s[]){
	for(int i = 0; i < strlen(s); i++){
		if((((s[i] == 65) || (s[i] == 69) || (s[i]) == 85) || (s[i] == 97) || (s[i] == 101) || (s[i] == 105) || (s[i] == 111) || (s[i] == 117)) || ((s[i] < 65 || s[i] > 90) && (s[i] < 97 || s[i] > 112))){
			return "NAO";
		}
	}
	return "SIM";
}// ending isConsoante

// Checks if the received string has only integers
const char* isInt(char s[]){
	for(int i = 0; i < strlen(s); i++){
		if(s[i] < 48 || s[i] > 57) return "NAO";
	}
	return "SIM";
}

const char* isFloat(char s[]){
	int count = 0, countChars = 0;
	for(int i = 0; i < strlen(s); i++){
		if(s[i] == 44 || s[i] == 46 || s[i] == 59) count++;
		if(s[i] >= 48 && s[i] <= 57) countChars++;
	}

	if((count == 0 || count == 1) && countChars == strlen(s) - count) return "SIM";
	return "NAO";
}
