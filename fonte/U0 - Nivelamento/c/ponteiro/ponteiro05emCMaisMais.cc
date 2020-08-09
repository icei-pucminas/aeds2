#include <iostream>
using namespace std;

#define MAXTAM 10

typedef struct Cliente {
   int codigo;
   char nome[MAXTAM];
} Cliente;


int main (int argc, char** argv){
   char* p1 = new char;
   int* p2 = new int;
   float* p3 = new float;
   Cliente* p4 = new Cliente;
   int* p5 = new int [MAXTAM];
   Cliente* p6 = new Cliente[MAXTAM];

   delete p1;
   delete p2;
   delete p3;
   delete p4;
   delete [] p5;
   delete [] p6;
}
