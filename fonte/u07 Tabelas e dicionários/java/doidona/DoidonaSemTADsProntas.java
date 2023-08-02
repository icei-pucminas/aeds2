class DoidonaSemTADsProntas {
   final int TAMT1 = 100;
   final int TAMT3 = 100;
   final int NULO = -0x7FFFFF;

   int[] t1;
   int[] t3;

   Celula primeiroListaT2, ultimoListaT2;
   No raizArvoreT2, raizArvoreT3;

   public Doidona (){
      t1 = new int[TAMT1];
      t3 = new int[TAMT3];

      for(int i = 0; i < TAMT1; i++){
         t1[i] = NULO;
      }
      for(int i = 0; i < TAMT3; i++){
         t3[i] = NULO;
      }

      primeiroListaT2 = ultimoListaT2 = new Celula();

      raizArvoreT2 = raizArvoreT3 = null;
   }

   public int hashT1(int elemento){
   }

   public int hashT2(int elemento){
   }

   public int hashT3(int elemento){
   }

   public int rehashT3(int elemento){
   }

   public void inserir(int elemento){
      int i = hashT1(elemento);

      if(elemento == NULO){
         // gerar msg de erro!!!!
      } else if(t1[i] == NULO){
         t1[i] = elemento;
      }else if(hashT2(elemento) == 0){
         inserirT3(elemento);
      }else if (hashT2(elemento) == 1){
         inserirLista(elemento);
      }else if (hashT2(elemento) == 2){
         raizArvoreT2 = inserirArvore(raizArvoreT2, elemento);
      } else {
         System.out.println("ERRO!!!!");
      }
   }

   public void inserirT3(int elemento){
      int i = hashT3(elemento);

      if(t3[i] == NULO){
         t3[i] = elemento;
      } else {
         i = rehashT3(elemento);

         if(t3[i] == NULO){
            t3[i] = elemento;
         } else {
            raizArvoreT3 = inserirArvore(raizArvoreT3, elemento);
         }
      }
   }

   public void inserirLista(int elemento){
      ultimoListaT2.prox = new Celula(elemento);
      ultimoListaT2 = ultimoListaT2.prox;
   }

   public No inserirArvore(No no, int elemento){
      if(no == null){
         no = new No (elemento);
      } else if (no.elemento < elemento){
         no.esq = inserirArvore(no.esq, elemento);
      } else if (no.elemento > elemento){
         no.dir = inserirArvore(no.dir, elemento);
      } else {
         System.out.println("Erro de Insercao");
      }
      return no;
   }

   public boolean pesquisar(int elemento){
      boolean resp;
      int i = hashT1(elemento);
      if(t1[i] == NULO){
         resp = false;
      }else if(t1[i] == elemento){
         resp = true;
      }else if(hashT2(elemento) == 0){
         resp = pesquisarT3(elemento);
      }else if (hashT2(elemento) == 1){
         resp = pesquisarLista(elemento);
      }else if (hashT2(elemento) == 2){
         resp = pesquisarArvore(raizArvoreT2, elemento);
      } else {
         resp = false;
         System.out.println("ERRO!!!!");
      }
      return resp;
   }

   public boolean pesquisarT3(int elemento){
      int i = hashT3(elemento);

      if(t3[i] == NULO){
         resp = false;
      }else if(t3[i] == elemento){
         resp = true;
      } else {
         i = rehashT3(elemento);

         if(t3[i] == NULO){
            resp = false;
         } else if(t3[i] == elemento){
            resp = true;
         } else {
            resp = pesquisarArvore(raizArvoreT3, elemento);
         }
      }

      return resp;
   }

   public boolean pesquisarLista(int elemento){
      boolean resp = false;
      for(Celula i = primeiroListaT2.prox; i != null; i = i.prox){
         if(i.elemento == elemento){
            resp = true;
            i = ultimoListaT2;
         }
      }
      return resp;
   }

   public boolean pesquisarArvore(No no, int elemento){
      boolean resp;

      if(no == null){
         resp = false;
      } else if (no.elemento < elemento){
         resp = pesquisarArvore(no.esq, elemento);
      } else if (no.elemento > elemento){
         resp = pesquisarArvore(no.dir, elemento);
      } else {
         resp = true;
      }
      return resp;
   }
}
