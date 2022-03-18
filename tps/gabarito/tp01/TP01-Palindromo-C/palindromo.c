
/**
 * @author: Thiago de Campos Ribeiro Nolasco
*/

// Bibliotecas utilizadas:
#include <stdio.h>
#include <string.h>
#include <locale.h>

#define true 1
#define false 0

// Prototipação:
int isFim(char s[]);
int palindrome(char s[]);

// Receives an input from keyboard and starts the program
int main(){
	setlocale(LC_ALL,"");
	// data declaration
	char str[1000];

//	scanf("%[^\n]", str);
//	getchar();

	fgets(str, 1000, stdin);
	setbuf(stdin, NULL);
	if(str[strlen(str) - 1] == '\n'){
		str[strlen(str) - 1] = '\0';
	}
	while(!(isFim(str))){
		
		if(palindrome(str)){
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
}// ending main


// Checks if the received string is equals to "FIM"
int isFim(char s[]){
	return (strlen(s) == 3 && s[0] == 'F' && s[1] == 'I' && s[2] == 'M');
}// ending isFim

// Checks if the given word is Palindrome
int palindrome(char s[]){
	int j = strlen(s) - 1;

	for(int i = 0; i < strlen(s); i++, j--){
		if(s[i] != s[j]) return false;
	}
	
	return true;
}// ending isPalindrome
