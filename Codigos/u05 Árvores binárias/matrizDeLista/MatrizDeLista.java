class MatrizDeLista {
   private CelulaMat inicio;
   private int linha, coluna;

   public MatrizDeLista(){
      this(3, 3);
   }

   public MatrizDeLista(int linha, int coluna){
      this.linha = linha;
      this.coluna = coluna;

      //alocar todas as celulas da matriz!!!
      //igual ao construtor da matriz flexível!!! 
      //Lembre-se que cada lista eh criada atutomaticamente no construtor de CelulaMat().
   }


   boolean pesquisar(int elemento){
      boolean resp = false;

      for(CelulaMat i = inicio; !resp && i != null; i = i.dir){
         for(CelulaMat j = i; !resp && j != null; j = j.inf){
            if(j.elemento == elemento){
               resp = true;
            } else {
               for(Celula k = j.primeiro.prox; k != null; k = k.prox){
                  if(k.elemento == elemento){
                     resp = true;
                     k = j.ultimo;
                  }
               }
            }
         }
      }

      return resp;
   }

   boolean pesquisar(int i, int j, int elemento){
      boolean resp = false;
      CelulaMat pi, pj;

      for(int ii = 0, pi = inicio; ii < i; ii++, pi = pi.dir){
         for(int jj = 0, pj = pi; jj < j; jj++, pj = pj.inf);
      }

      for(Celula k = pj.primeiro.prox; k != null; k = k.prox){
         if(k.elemento == elemento){
            resp = true;
            k = j.ultimo;
         }
      }

   }

}
