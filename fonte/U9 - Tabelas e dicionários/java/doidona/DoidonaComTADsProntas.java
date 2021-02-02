class DoidonaComTADsProntas {
   final int TAMT1 = 100;
   final int TAMT3 = 100;
   final int NULO = -0x7FFFFF;

   int[] t1;
   int[] t3;

   ArvoreBinaria arvoreBinaria;
   ListaSimples lista;
   AVL arvoreAVL;

   public Doidona(){
      t1 = new int [TAMT1];
      t3 = new int [TAMT3];

      for(int i = 0; i < TAMT1; i++){
         t1[i] = NULO;
      }
      for(int i = 0; i < TAMT3; i++){
         t3[i] = NULO;
      }

      arvoreBinaria = new ArvoreBinaria();
      arvoreAVL = new AVL();
      lista = new ListaSimples();
   }

   public int hashT1(int elemento){
   }

   public int hashT2(int elemento){
      return elemento % 3;
   }

   public int hashT3(int elemento){
   }

   public int rehashT3(int elemento){
   }

   public void inserir(int elemento){
      int i = hashT1(elemento);
      if(elemento == NULO) {
         //gerar msg de erro para o usuario...
      } else if(t1[i] == NULO){
         t1[i] = elemento;
      }else if(hashT2(elemento) == 0){
         int i = hashT3(elemento);

         if(t3[i] == NULO){
            t3[i] = elemento;
         } else {
            i = rehashT3(elemento);

            if(t3[i] == NULO){
               t3[i] = elemento;
            } else {
               arvoreBinaria.inserir(elemento);
            }
         }
      }else if (hashT2(elemento) == 1){
         lista.inserirFim(elemento);
      }else if (hashT2(elemento) == 2){
         arvoreAVL.inserir(elemento);
      } else {
         System.out.println("ERRO!!!!");
      }
   }
   void remover (int valor){
   }

   boolean pesquisar (int valor){
      boolean resp = false;
      int pos = hashT1(valor);
      if(t1[pos] == valor){
         resp = true;
      }else {
         pos = hashT2(valor);
         if (pos == 0){
            pos = hashT3(valor);
            if(t3[pos] == valor){
               resp = true;
            }else{
               pos = rehashT3(valor);
               if(t3[pos] == valor){
                  resp = true;
               }else{
                  resp = arvoreBinaria.pesquisar(valor);
               }
            }
         }else if (pos == 1){
            resp = lista.pesquisar(valor);
         } else {
            resp = arvoreAVL.pesquisar(valor);
         }
      }
      return resp;
   }

   void mostrar(){
      //t1, t3, arvoreBinaria, lista, arvoreAVL
      for(int i = 0; i < TAMT1; i++){
         if(t1[i] != NULO){
            System.out.println(t1[i]);
         }
      }
      for(int i = 0; i < TAMT3; i++){
         if(t3[i] != NULO){
            System.out.println(t3[i]);
         }
      }
      arvoreBinaria.mostrar();
      lista.mostrar();
      arvoreAVL.mostrar();
   }
}
