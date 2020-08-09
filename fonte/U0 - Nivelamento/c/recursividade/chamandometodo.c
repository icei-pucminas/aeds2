#include <stdio.h> 
#include <stdlib.h> 

void terceiro(){
   printf("3o - inicio e fim\n");
}

void segundo(){
   printf("2o - inicio\n");
   terceiro();
   printf("2o - fim\n");
}

void primeiro(){
   printf("1o - inicio\n");
   segundo();
   printf("1o - fim\n");
}

int main(int argc, char *argv[]) { 
   printf("main - inicio\n");
   primeiro();
   printf("main - fim\n");

   return 0; 
}
