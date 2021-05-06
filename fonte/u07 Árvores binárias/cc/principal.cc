/**
 * Principal para Arvore Binaria de Pesquisa
 * @author Max do Val Machado
 */
#include "arvorebinaria.h"
#include <iostream>
using namespace std;

int main(){//int argc, char** argv){
   ArvoreBinaria* arvoreBinaria = new ArvoreBinaria();

   arvoreBinaria->inserir(3);
   arvoreBinaria->inserir(5);
   arvoreBinaria->inserir(1);
   arvoreBinaria->inserir(8);
   arvoreBinaria->inserir(2);
   arvoreBinaria->inserir(4);
   arvoreBinaria->inserir(7);
   arvoreBinaria->inserir(6);

   cout << "\nInserir: 3, 5, 1, 8, 2, 4, 7 e 6";
   cout << "\nCaminhar: central, pre e pos\n";
   arvoreBinaria->caminharCentral();
   arvoreBinaria->caminharPre();
   arvoreBinaria->caminharPos();


   cout << "\nRemover: 2";
   cout << "\nCaminhar: central, pre e pos\n";
   arvoreBinaria->remover(2);

   arvoreBinaria->caminharCentral();
   arvoreBinaria->caminharPre();
   arvoreBinaria->caminharPos();

   cout << "\nVoltando com a árvore inicial";
   cout << "\nRemover: 1";
   cout << "\nCaminhar: central, pre e pos\n";
   arvoreBinaria->inserir(2);
   arvoreBinaria->remover(1);

   arvoreBinaria->caminharCentral();
   arvoreBinaria->caminharPre();
   arvoreBinaria->caminharPos();

   cout << "\nVoltando com a árvore inicial";
   cout << "\nRemover: 3";
   cout << "\nCaminhar: central, pre e pos\n";
   arvoreBinaria->remover(2);
   arvoreBinaria->inserir(1);
   arvoreBinaria->inserir(2);
   arvoreBinaria->remover(3);

   arvoreBinaria->caminharCentral();
   arvoreBinaria->caminharPre();
   arvoreBinaria->caminharPos();


   return 1;
}
