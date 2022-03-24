
/**
 * @author: Thiago de Campos Ribeiro Nolasco
*/


// Library used:
#include <stdio.h>

// Prototipacao:
void readInput(int quantity);

// receives an input from keyboard and starts the program
int main(void){
	// data declaration
	int value = 0, temp = 0;
	char breakLine = '\n';
	double entries = 0.00;
	
	// Opening the FILE
	FILE *p = fopen("test.txt", "wb+");
	if(p != NULL) {
		scanf("%d", &value);
		temp = value;
		while(temp != 0){
			scanf("%lf", &entries);

			fwrite(&entries, sizeof(double), 1, p);
			fwrite(&breakLine, sizeof(char), 1, p);

			temp--;
		}
	}else{
		printf("Error on opening the File...");
		return -1;
	}
	// Closing FILE
	fclose(p);


	readInput(value);
	// return with no errors
	return 0;
} // ending main

// receives a int "quantity" to read an archive with size of "quantity"
void readInput(int quantity){
	// data declaration
	int foo = 0; 
	double doubleValue = 0.00;
	FILE *p = fopen("test.txt", "rb+");
	
	fseek(p, 0, SEEK_SET);
	
	// Looping that will basicaly:
	// -> Put the file pointer into the beginning of the line (backwards)
	// -> Read a double from the archive, and then, transforms it into integer (narrowing conversion)
	// -> Put the file pointer back into the beginning of the line
	// -> Reads the same double (but without conversion)
	// -> And then, do the comparison...
	for(int i = quantity; i > 0; i--){
		fseek(p, ((sizeof(double) + sizeof(char)) * (i - 1)), SEEK_SET);
		fread(&doubleValue, sizeof(double), 1, p);
		foo = (int) doubleValue;


		if(foo == doubleValue){
			printf("%d\n", foo);
			fseek(p, ((sizeof(double) + sizeof(char)) * (i - 4)) + sizeof(int), SEEK_SET);
		}else{
			// printing only the necessary amount of decimals
			printf("%g\n", doubleValue);
		}		
	}
	// Closing FILE
	fclose(p);
} // ending method
