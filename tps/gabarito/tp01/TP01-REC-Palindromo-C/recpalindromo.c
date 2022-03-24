
/**
 * @author: Thiago de Campos Ribeiro Nolasco
*/

// Included libraries:
#include <stdio.h>
#include <string.h>

#define true 1
#define false 0

// Prototipação
int isFim(char s[]);
int palindrome(char s[], int count);

// Receives an input from keyboard and starts the program
int main (void){
	// data declaration
	char str[1000];

	fgets(str, 1000, stdin);
	setbuf(stdin, NULL);
	if(str[strlen(str) - 1] == '\n'){
		str[strlen(str) - 1] = '\0';
	}
	while(!(isFim(str))){
		if(palindrome(str, 0)){
			printf("SIM\n");
		}else{
			printf("NAO\n");
		}

		fgets(str, 1000, stdin);
		setbuf(stdin, NULL);
		if(str[strlen(str) - 1] == '\n'){
			str[strlen(str) - 1] = '\0';
		}
	}

	// Return without errors
	return 0;	
} // ending main

// Checks if the received string is equals to "FIM"
int isFim(char s[]){
	return(strlen(s) == 3 && s[0] == 'F' && s[1] == 'I' && s[2] == 'M');		
} // ending method

// Checks if the received string is Palindrome (using recursion)
int palindrome(char s[], int count){
	int resp = true;
	int j = strlen(s) - 1 - count;

	if(count < j){
		if(s[count] == s[j]){
			resp = palindrome(s, count + 1);
		}else{
			resp = false;
		}
	}
	return resp;
} // ending method
